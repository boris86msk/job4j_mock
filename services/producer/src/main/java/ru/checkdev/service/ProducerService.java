package ru.checkdev.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.checkdev.domain.Notify;

@Service
@Slf4j
public class ProducerService {
    private final KafkaTemplate<String, Notify> template;

    public ProducerService(KafkaTemplate<String, Notify> template) {
        this.template = template;
    }

    public void sendMessageToTopic(Notify notify) {
        template.send("job4j-events", notify);
        log.info("send message");
    }
}
