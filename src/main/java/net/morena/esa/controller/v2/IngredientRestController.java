package net.morena.esa.controller.v2;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import net.morena.esa.dto.IngredientDTO;
import net.morena.esa.sevice.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.TEXT_HTML;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/ingredient")
public class IngredientRestController {

    private final IngredientService ingredientService;
    private final XmlMapper xmlMapper;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(@RequestHeader("Accept") String acceptHeader) {
        var ingredients = ingredientService.getAll()
                .stream()
                .map(IngredientDTO::toDTO)
                .collect(Collectors.toList());

        if (acceptHeader.contains(MediaType.TEXT_HTML_VALUE)) {
            try {
                Transformer transformer = TransformerFactory
                        .newInstance()
                        .newTemplates(new StreamSource("src/main/resources/xslt/ingredients.xslt"))
                        .newTransformer();
                StringWriter writer = new StringWriter();
                transformer.transform(new StreamSource(
                                new ByteArrayInputStream(xmlMapper.writeValueAsBytes(ingredients))),
                        new StreamResult(writer));

                return ResponseEntity.ok().contentType(TEXT_HTML).body(writer.toString());
            } catch (TransformerException | JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        else if (acceptHeader.contains(MediaType.APPLICATION_XML_VALUE) ||
                acceptHeader.contains(MediaType.APPLICATION_JSON_VALUE) ||
                acceptHeader.contains(MediaType.ALL_VALUE))
            return ResponseEntity.ok(ingredients);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id,
                                     @RequestHeader("Accept") String acceptHeader) {
        var ingredient = IngredientDTO.toDTO(ingredientService.getById(id));

        if (acceptHeader.contains(MediaType.TEXT_HTML_VALUE)) {
            try {
                Transformer transformer = TransformerFactory
                        .newInstance()
                        .newTemplates(new StreamSource("src/main/resources/xslt/ingredient.xslt"))
                        .newTransformer();
                StringWriter writer = new StringWriter();
                transformer.transform(new StreamSource(
                                new ByteArrayInputStream(xmlMapper.writeValueAsBytes(ingredient))),
                        new StreamResult(writer));

                return ResponseEntity.ok().contentType(TEXT_HTML).body(writer.toString());
            } catch (TransformerException | JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        else if (acceptHeader.contains(MediaType.APPLICATION_XML_VALUE) ||
                acceptHeader.contains(MediaType.APPLICATION_JSON_VALUE) ||
                acceptHeader.contains(MediaType.ALL_VALUE))
            return ResponseEntity.ok(ingredient);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(path = "/create",
                 consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> postCreate(@RequestBody IngredientDTO dto) {
        ingredientService.create(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        ingredientService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}