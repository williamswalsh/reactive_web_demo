package ie.williamswalsh.web;

import ie.williamswalsh.domain.Car;
import ie.williamswalsh.domain.CarBrand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
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
        return Mono.just(new Car("22KY1", CarBrand.FERRARI, "F12", 2012));
    }

    @GetMapping(value = "/getMultipleCars")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Car> getMultipleCars() {
        Car ferrari = new Car("22KY1", CarBrand.FERRARI, "F12", 2022);
        Car lamborghini = new Car("22KY2", CarBrand.LAMBOURGHINI, "Aventador LMP500", 2022);
        Flux<Car> carFlux = Flux.just(lamborghini, ferrari);
        //
        // return ServerResponse.created(URI.create("http://localhost:8080/2222"))
        //         .body(carFlux, Car.class);

        // I know this isn't a proper use of reactive
        // This is just to test WebTestClient
        return Mono.just(new Car("22KY1", CarBrand.FERRARI, "F12", 2022));
    }

    @GetMapping(value = "/getAllCars")
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<Car> getAllCars() {
        Car ferrari = new Car("22KY1", CarBrand.FERRARI, "F12", 2022);
        Car lamborghini = new Car("22KY2", CarBrand.LAMBOURGHINI, "Aventador LMP500", 2022);

        return Flux.just(lamborghini, ferrari);
    }
}
