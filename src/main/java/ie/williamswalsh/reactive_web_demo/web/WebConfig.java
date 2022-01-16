package ie.williamswalsh.reactive_web_demo.web;

import ie.williamswalsh.reactive_web_demo.domain.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
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
    }

    private Mono<ServerResponse> methodRefExample(ServerRequest serverRequest) {
        return ServerResponse.ok().body(just("methodRefExample"), String.class);
    }

    private Mono<ServerResponse> secondMethodRefExample(ServerRequest serverRequest) {
        Mono<Car> carMono = Mono.just(new Car("Ferrari", "F12", 2012, 1L));

        return ServerResponse.created(URI.create("http://localhost:8080/1111"))
                .body(carMono, Car.class);
    }
}
