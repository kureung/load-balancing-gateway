package io.github.kureung.springgateway.gateway;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

@Disabled
class GateWayTest {
    @Test
    void routingLoadBalanceExternalTest() {
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < 100; i++) {
            String call = call();
            if (call.equals("hello")) {
                countA++;
            }

            if (call.equals("hello2")) {
                countB++;
            }
        }
        System.out.println("countA = " + countA);
        System.out.println("countB = " + countB);
    }

    private String call() {
        return WebClient.create("http://localhost:7777")
                .get()
                .uri("/hello")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}

