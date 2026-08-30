package com.sivalabs.demo;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

class SafetyCheckAdvisor implements CallAdvisor {
    private static final Logger logger = LoggerFactory.getLogger(SafetyCheckAdvisor.class);
    private final List<String> sensitiveWords;

    SafetyCheckAdvisor(List<String> sensitiveWords) {
        this.sensitiveWords = sensitiveWords;
    }

    @Override
    @NonNull
    public ChatClientResponse adviseCall(
            @NonNull ChatClientRequest chatClientRequest,
            @NonNull CallAdvisorChain callAdvisorChain) {
        logger.info("Checking for sensitive words");
        if (!CollectionUtils.isEmpty(this.sensitiveWords)
                && this.sensitiveWords.stream().anyMatch(w -> chatClientRequest.prompt().getContents().contains(w))) {
            logger.info("Found sensitive words in the request. Abort further processing");
            return createFailureResponse(chatClientRequest);
        }
        return callAdvisorChain.nextCall(chatClientRequest);
    }

    private ChatClientResponse createFailureResponse(ChatClientRequest chatClientRequest) {
        String failureResponse = "I'm unable to respond to that due to sensitive content.";
        return ChatClientResponse.builder()
                .chatResponse(ChatResponse.builder()
                    .generations(List.of(new Generation(new AssistantMessage(failureResponse))))
                    .build())
                .context(Map.copyOf(chatClientRequest.context()))
                .build();
    }

    @Override
    @NonNull
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
