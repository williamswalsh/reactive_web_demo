package ie.williamswalsh.reactive_web_demo.web;

import ie.williamswalsh.reactive_web_demo.domain.Car;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

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

    @GetMapping(value = "/getMultipleCars")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Car> getMultipleCars() {
        Car ferrari = new Car("Ferrari", "F12", 2012, 1L);
        Car lamborghini = new Car("Lamborghini", "Murceilago LP640", 2012, 2L);
        Flux<Car> carFlux = Flux.just(lamborghini, ferrari);
        //
        // return ServerResponse.created(URI.create("http://localhost:8080/2222"))
        //         .body(carFlux, Car.class);

        // I know this isn't a proper use of reactive
        // This is just to test WebTestClient
        return Mono.just(new Car("Ferrari", "F12", 2012, 1L));
    }
}
