package net.morena.esa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class EsaApp {
    public static void main(String[] args) {
        SpringApplication.run(EsaApp.class, args);
    }
}