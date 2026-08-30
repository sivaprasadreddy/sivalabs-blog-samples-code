package com.sivalabs.demo;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;

class MyLoggingAdvisor implements CallAdvisor {
    private static final Logger logger = LoggerFactory.getLogger(MyLoggingAdvisor.class);

    @Override
    @NonNull
    public ChatClientResponse adviseCall(@NonNull ChatClientRequest chatClientRequest,
                                         @NonNull CallAdvisorChain callAdvisorChain) {
        logger.info("request: {}", chatClientRequest);

        ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);

        logger.info("response: {}", chatClientResponse.chatResponse());

        return chatClientResponse;
    }

    @Override
    public @NonNull String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int getOrder() {
        return 20;
    }
}
