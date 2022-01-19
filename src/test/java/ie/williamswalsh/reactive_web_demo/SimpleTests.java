package ie.williamswalsh.reactive_web_demo;

import ie.williamswalsh.reactive_web_demo.web.OtherCtrlr;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

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

    @Test
    void testingResponseBodyWithJsonFile() throws IOException {
        // Create WebTestClient from ctrlr
        WebTestClient webTestClient = WebTestClient.bindToController(new OtherCtrlr()).build();

        // Access JSON file
        ClassPathResource classPathResource = new ClassPathResource("method2.json");
        String method2ResponseBody = StreamUtils.copyToString(classPathResource.getInputStream(), Charset.defaultCharset());


        // Expectations/Assertions
        webTestClient
                .get()
                .uri("/getCar")
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .json(method2ResponseBody);

    }
}
