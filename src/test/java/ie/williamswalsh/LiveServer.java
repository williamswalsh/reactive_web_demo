package ie.williamswalsh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LiveServer {

    @Autowired
    private WebTestClient client;

    @Test
    public void testWithLiveServerApiCall() {
        client
                .get()
                .uri("/getCar")
                .exchange()
                .expectStatus().isCreated()
                .expectBody().jsonPath("$.brand")
                .isEqualTo("FERRARI");
    }

    @Test
    public void testWithLiveServerApiCallFluxReceived() {
        client
                .get()
                .uri("/getAllCars")
                .exchange()
                .expectStatus().isCreated()
                .expectBody().jsonPath("$[0].brand")
                .isEqualTo("LAMBOURGHINI");
    }
}
