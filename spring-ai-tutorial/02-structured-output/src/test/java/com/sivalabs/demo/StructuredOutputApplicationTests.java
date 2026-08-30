package com.sivalabs.demo;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.assertj.MvcTestResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class StructuredOutputApplicationTests {

    @Autowired
    MockMvcTester mockMvcTester;

    @Test
    void suggestTitles() {
        MvcTestResult testResult =
                mockMvcTester
                .post()
                .uri("/ai/suggest-titles")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "topic": "Spring Boot Tips and Tricks",
                            "count": 3
                        }
                        """)
                .exchange();

        assertThat(testResult)
                .hasStatusOk()
                .bodyJson()
                .convertTo(ChatController.TitleSuggestionsResponse.class)
                .satisfies(suggestionsResponse -> {
                    System.out.println("Response:\n"+suggestionsResponse);
                    assertThat(suggestionsResponse.titles()).isNotEmpty();
                });
    }

    @Test
    void getLanguages() {
        MvcTestResult testResult =
                mockMvcTester
                .get()
                .uri("/ai/langs")
                .exchange();

        assertThat(testResult)
                .hasStatusOk()
                .bodyJson()
                .convertTo(InstanceOfAssertFactories.map(String.class, Object.class))
                .satisfies(output -> {
                    System.out.println("Response:\n"+output);
                    assertThat(output).isNotEmpty();
                });
    }

    @Test
    void generateTweet() {
        MvcTestResult testResult =
                mockMvcTester
                .post()
                .uri("/ai/gen-tweet")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "prompt": "IntelliJ IDEA 2026.2 is released with a lot of new features such as Logpoints, Dependency completion in Gradle, Spring Security Inlays and Unlocking, Docker Compose improvements. Checkout https://www.jetbrains.com/idea/whatsnew/2026-2/ for more details."
                        }
                        """)
                .exchange();

        assertThat(testResult)
                .hasStatusOk()
                .bodyJson()
                .convertTo(ChatController.Tweet.class)
                .satisfies(tweet -> {
                    System.out.println("Response:\n"+tweet);
                    assertThat(tweet.content()).isNotBlank();
                });
    }

}
