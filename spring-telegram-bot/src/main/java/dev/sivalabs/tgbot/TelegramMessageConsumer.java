package dev.sivalabs.tgbot;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class TelegramMessageConsumer {

    private final RestClient client;
    private final TelegramProperties properties;

    private long offset = 0;

    public TelegramMessageConsumer(TelegramProperties properties) {
        this.properties = properties;
        this.client = RestClient.builder()
                .baseUrl("https://api.telegram.org")
                .build();
    }

    @Scheduled(fixedDelay = 1000)
    public void poll() {

        var response = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/bot{token}/getUpdates")
                        .queryParam("offset", offset)
                        .queryParam("timeout", 30)
                        .build(properties.botToken()))
                .retrieve()
                .body(TelegramUpdates.class);

        if (response == null) {
            return;
        }

        for (var update : response.result()) {
            offset = update.updateId() + 1;

            if (update.message() != null &&
                update.message().text() != null) {

                System.out.println(
                        "Received: " + update.message().text()
                );
            }
        }
    }
}