package com.example.kafka.config;

import com.example.kafka.domain.Account;
import com.example.kafka.serviceRepo.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private final AccountService accountService;
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    public JsonKafkaConsumer(AccountService accountService) {
        this.accountService = accountService;
    }

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Account account) {
        LOGGER.info(String.format("Json message recieved -> %s", account.toString()));
        accountService.createAccount(account);
    }
}
