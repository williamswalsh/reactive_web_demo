package ie.williamswalsh.web;

import ie.williamswalsh.domain.Car;
import ie.williamswalsh.domain.CarBrand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;

@Configuration
public class WebConfig {

    @Bean
    public RouterFunction<ServerResponse> helloRouterFx(){
        return route( GET("/hello"), request -> ok().body(just("Hello"), String.class))
                .andRoute( GET("/method"), this::methodRefExample)
                .andRoute( GET("/method2"), this::secondMethodRefExample);
                // .andRoute( GET("/getMultipleCars"), this::getMultipleCars);
    }

    private Mono<ServerResponse> methodRefExample(ServerRequest serverRequest) {
        return ServerResponse.ok().body(just("methodRefExample"), String.class);
    }

    private Mono<ServerResponse> secondMethodRefExample(ServerRequest serverRequest) {
        Mono<Car> carMono = Mono.just(new Car("21C12", CarBrand.FERRARI, "F12", 2021));

        return ServerResponse.created(URI.create("http://localhost:8080/1111"))
                .body(carMono, Car.class);
    }

    private Mono<ServerResponse> getMultipleCars(ServerRequest serverRequest) {
        Car ferrari = new Car("21C12", CarBrand.FERRARI, "F12", 2021);
        Car lamborghini = new Car("20C12", CarBrand.LAMBOURGHINI, "LMP500", 2021);
        Flux<Car> carFlux = Flux.just(lamborghini, ferrari);

        return ServerResponse.created(URI.create("http://localhost:8080/2222"))
                .body(carFlux, Car.class);
    }
}
