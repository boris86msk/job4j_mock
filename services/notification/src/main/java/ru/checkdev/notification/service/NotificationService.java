package ru.checkdev.notification.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.checkdev.notification.domain.Notify;

import javax.annotation.PreDestroy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Service
@Slf4j
public class NotificationService {

    private final TemplateService templates;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Autowired
    public NotificationService(final TemplateService templates) {
        this.templates = templates;
    }

    @KafkaListener(topics = "job4j-events", containerFactory = "kafkaListenerContainerFactory")
    public void put(final Notify notify) {
        log.info("a message was received from 'job4j-events' topic");
        this.scheduler.execute(() -> this.templates.send(notify));
    }

    @PreDestroy
    public void close() {
        this.scheduler.shutdown();
    }
}
