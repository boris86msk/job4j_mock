package ru.checkdev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.checkdev.domain.Notify;
import ru.checkdev.service.ProducerService;

@Controller
public class KafkaTestController {
    private final ProducerService service;

    public KafkaTestController(ProducerService service) {
        this.service = service;
    }

    @PostMapping("/")
    public String simpleGet(@RequestBody Notify notify) {
        service.sendMessageToTopic(notify);
        return HttpStatus.OK.toString();
    }
}
