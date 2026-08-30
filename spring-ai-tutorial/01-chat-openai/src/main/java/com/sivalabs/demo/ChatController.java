package com.sivalabs.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
class ChatController {
    private static final Logger log = LoggerFactory.getLogger(ChatController.class);
    private final ChatClient chatClient;

    ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
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

    @PostMapping("/ai/chat2")
    Answer chat2(@RequestBody @Valid Question question) {
        String response = chatClient
                .prompt()
                .system("You are a friendly, helpful assistant. You always respond professionally")
                .user(question.question())
                .call()
                .content();
        return new Answer(response);
    }

    @PostMapping("/ai/chat3")
    Answer chat3(@RequestBody @Valid Question question) {
        String systemPrompt =
            """
            You are a friendly, helpful assistant.
            You always respond professionally.
            """;
        SystemMessage systemMessage = new SystemMessage(systemPrompt);
        UserMessage userMessage = new UserMessage(question.question());

        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
        String response = chatClient
                            .prompt(prompt)
                            .call()
                            .content();

        return new Answer(response);
    }

    @PostMapping("/ai/suggest-titles")
    Answer suggestTitles(@RequestBody @Valid TitleSuggestionsRequest req) {
        String response;

        PromptTemplate pt = new PromptTemplate("""
        I would like to give a presentation about the following:
        
        {topic}
        
        Give me {count} title suggestions for this topic.
        
        Make sure the title is relevant to the topic and it should be a single short sentence.
        """);

        Map<String, Object> vars = Map.of(
                "topic", req.topic(),
                "count", req.count()
        );

        Message message = pt.createMessage(vars);
        response = chatClient.prompt().messages(message).call().content();

        return new Answer(response);
    }

    @PostMapping("/ai/suggest-titles2")
    Answer suggestTitles2(@RequestBody @Valid TitleSuggestionsRequest req) {
        String response = chatClient
                .prompt()
                .system("You are a friendly, helpful assistant. You always respond professionally")
                .user(u ->
                    u.text("""
                        I would like to give a presentation about the following:
                        
                        {topic}
                        
                        Give me {count} title suggestions for this topic.
                        
                        Make sure the title is relevant to the topic and it should be a single short sentence.
                        """)
                     .param("topic", req.topic())
                     .param("count", req.count())
                )
                .call().content();

        return new Answer(response);
    }

    record Question(@NotBlank String question) {}

    record Answer(String answer) {}

    record TitleSuggestionsRequest(@NotBlank String topic, @NotNull Integer count) {}

}