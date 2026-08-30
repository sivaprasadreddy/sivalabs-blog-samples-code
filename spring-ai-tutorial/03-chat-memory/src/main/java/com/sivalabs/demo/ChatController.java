package com.sivalabs.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/")
class ChatController {
    private final ChatClient chatClient;

    ChatController(ChatClient.Builder builder, ChatMemory chatMemory) {
        this.chatClient = builder
                .defaultAdvisors(
                    MessageChatMemoryAdvisor.builder(chatMemory).build(),
                    new SimpleLoggerAdvisor()
                )
                .build();
    }

    @PostMapping("/ai/simple-chat")
    ResponseEntity<Answer> chat(@RequestBody @Valid Question question) {
        String conversationId = "demo";
        var response = this.chatClient.prompt()
                .user(question.question())
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId))
                .call().content();
        Answer output = new Answer(response);
        return ResponseEntity.ok()
                .body(output);
    }

    @PostMapping("/ai/chat")
    ResponseEntity<Answer> chat(@RequestBody @Valid Question question,
                                @CookieValue(name = "X-CONV-ID", required = false) String convId) {
        String conversationId = convId == null ? UUID.randomUUID().toString() : convId;
        var response = this.chatClient.prompt()
                .user(question.question())
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId))
                .call().content();
        ResponseCookie cookie = ResponseCookie.from("X-CONV-ID", conversationId)
                .path("/")
                .maxAge(3600)
                .build();
        Answer output = new Answer(response);
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(output);
    }

    record Question(@NotBlank String question) {}

    record Answer(String answer) {}

}