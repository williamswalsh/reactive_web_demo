package ie.williamswalsh.reactive_web_demo.web;

import ie.williamswalsh.reactive_web_demo.domain.Car;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class OtherCtrlr {

    @GetMapping(value = "/getString")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> dummyGetMethodForTesting() {
        return Mono.just("getMethodForTesting output");
    }

    @GetMapping(value = "/getCar")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Car> dummyGetCarMethod() {

        // I know this isn't a proper use of reactive
        // This is just to test WebTestClient
        return Mono.just(new Car("Ferrari", "F12", 2012, 1L));
    }
}
