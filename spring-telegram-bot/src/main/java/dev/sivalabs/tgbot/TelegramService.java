package dev.sivalabs.tgbot;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class TelegramService {

    private final RestClient restClient;
    private final TelegramProperties properties;

    public TelegramService(TelegramProperties properties) {
        this.properties = properties;
        this.restClient = RestClient.builder()
                .baseUrl("https://api.telegram.org")
                .build();
    }

    public void sendMessage(String message) {
        restClient.post()
                .uri("/bot{token}/sendMessage", properties.botToken())
                .body(Map.of(
                        "chat_id", properties.chatId(),
                        "text", message
                ))
                .retrieve()
                .toBodilessEntity();
    }
}