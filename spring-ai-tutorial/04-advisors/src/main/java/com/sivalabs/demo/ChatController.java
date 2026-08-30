package com.sivalabs.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ChatController {
    private static final Logger log = LoggerFactory.getLogger(ChatController.class);
    private final ChatClient chatClient;

    ChatController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultAdvisors(
                    new MyLoggingAdvisor(),
                    new SafetyCheckAdvisor(List.of("fuck", "screw"))
                )
                .build();
    }

    @PostMapping("/ai/chat")
    Answer chat(@RequestBody @Valid Question question) {
        log.info("Prompt: {}", question.question());
        String response = chatClient
                            .prompt(question.question())
                            .call()
                            .content();
        log.info("LLM Response: {}", response);
        return new Answer(response);
    }

    record Question(@NotBlank String question) {}

    record Answer(String answer) {}

}