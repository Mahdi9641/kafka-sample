package com.example.kafka.controller;

import com.example.kafka.config.JsonKafkaProducer;
import com.example.kafka.config.KafkaProducer;
import com.example.kafka.domain.Account;
import com.example.kafka.serviceRepo.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final JsonKafkaProducer jsonKafkaProducer;
    private final AccountService accountService;

    public MessageController(KafkaProducer kafkaProducer, JsonKafkaProducer jsonKafkaProducer, AccountService accountService) {
        this.kafkaProducer = kafkaProducer;
        this.jsonKafkaProducer = jsonKafkaProducer;
        this.accountService = accountService;
    }

    @GetMapping("/sendStringMessage")
    public ResponseEntity<String> sendStringMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

    @PostMapping("/sendJsonMessage")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Account account){
        jsonKafkaProducer.sendMessage(account);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }

    @GetMapping("/getAccounts")
    public List<Account> getAccounts(){
        return accountService.findAllAccount();
    }
}
