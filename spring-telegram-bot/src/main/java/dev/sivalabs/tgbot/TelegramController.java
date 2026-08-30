package dev.sivalabs.tgbot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TelegramController {

    private final TelegramService telegramService;

    public TelegramController(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    record Message(String message){}

    @PostMapping("/api/tg/send")
    void send(@RequestBody Message message) {
        telegramService.sendMessage(message.message());
    }
}
