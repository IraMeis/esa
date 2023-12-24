package net.morena.esa.sevice;


import lombok.RequiredArgsConstructor;
import net.morena.esa.entity.LogEvent;
import net.morena.esa.entity.MailCondition;
import net.morena.esa.jms.ConsumerMail;
import net.morena.esa.repository.MailConditionRepo;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;
    private final MailConditionRepo mailConditionRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerMail.class);

    public void sendMail(String address, LogEvent logEvent) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(address);
        simpleMailMessage.setSubject(
                String.format("Change in %s", logEvent.getTableName()));
        simpleMailMessage.setText(
                String.format(
                        "Change in %s of type %s. %s",
                        logEvent.getTableName(),
                        logEvent.getEventType(),
                        logEvent.getDescription()));
        mailSender.send(simpleMailMessage);
    }

    public void resolve(LogEvent logEvent) {
        List<MailCondition> mails = mailConditionRepo.findAllByIsDeletedFalse();
        mails.forEach(mail -> {
            try {
                JSONObject condition = new JSONObject(mail.getCondition());
                if (condition.opt(logEvent.getEventType()) == null)
                    return;
                var conditionList = ((JSONArray)condition.opt(logEvent.getEventType())).toList();
                if (conditionList.contains(logEvent.getTableName()) || conditionList.contains("any"))
                    sendMail(mail.getAddress(), logEvent);
            }
            catch (Exception e){
                LOGGER.info(e.getMessage(), e);
            }
        });
    }
}