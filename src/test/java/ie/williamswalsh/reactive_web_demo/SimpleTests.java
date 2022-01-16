package ie.williamswalsh.reactive_web_demo;

import ie.williamswalsh.reactive_web_demo.web.OtherCtrlr;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;

class SimpleTests {

    @Test
    void testingResponse() {
        // Create WebTestClient from ctrlr
        WebTestClient webTestClient = WebTestClient.bindToController(new OtherCtrlr()).build();

        // Expectations/Assertions
        webTestClient
                .get()
                .uri("/getString")
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    void testingResponseBody() {
        // Create WebTestClient from ctrlr
        WebTestClient webTestClient = WebTestClient.bindToController(new OtherCtrlr()).build();

        // Expectations/Assertions
        webTestClient
                .get()
                .uri("/getCar")
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                    .jsonPath("$").isNotEmpty()
                .jsonPath("$['brand']").isEqualTo("Ferrari")
                .jsonPath("non_existant_field").doesNotExist();

    }
}

class Sample {

    public String returnString() {
        return "x";
    }
}
