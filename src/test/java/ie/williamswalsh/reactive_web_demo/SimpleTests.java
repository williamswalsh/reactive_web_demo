package ie.williamswalsh.reactive_web_demo;

import ie.williamswalsh.reactive_web_demo.web.OtherCtrlr;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;

class SimpleTests {

    @Test
    void testing() {

        // Mock class
        Sample sample = Mockito.mock(Sample.class);
        // Mock method
        when(sample.returnString()).thenReturn("y");
        // Create WebTestClient from ctrlr
        WebTestClient webTestClient = WebTestClient.bindToController(new OtherCtrlr()).build();

        webTestClient
                .get()
                .uri("/getString")
                .exchange()
                .expectStatus().isCreated();
    }
}

class Sample {

    public String returnString() {
        return "x";
    }
}
