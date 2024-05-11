package com.example.view.Kafka;

import com.example.view.Student;
import com.example.view.ViewService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class KafkaConsumer {
    private final ObjectMapper objectMapper;
    private final ViewService viewService;

    @KafkaListener(topics = "students", groupId = "students")
    public void consumeMessage(String student_json) throws JsonProcessingException {
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        student_json = student_json.replace("\\", ""); // Remover as barras invertidas
        student_json = student_json.substring(1, student_json.length() - 1); // Remover as aspas externas
        JsonNode jsonNodeRoot = objectMapper.readTree(student_json);
        JsonNode name = jsonNodeRoot.get("name");
        JsonNode email = jsonNodeRoot.get("email");
        Student student = new Student();
        student.setEmail(email.asText());
        student.setName(name.asText());
        viewService.addStudent(student);
    }
}