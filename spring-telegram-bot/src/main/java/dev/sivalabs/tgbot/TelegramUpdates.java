package dev.sivalabs.tgbot;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record TelegramUpdates(
        boolean ok,
        List<TelegramUpdate> result
) {
}

record TelegramUpdate(
        @JsonProperty("update_id")
        long updateId,
        TelegramMessage message
) {}

record TelegramMessage(
        long message_id,
        TelegramChat chat,
        String text
) {}

record TelegramChat(
        long id,
        String type
) {}