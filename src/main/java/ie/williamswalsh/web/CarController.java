package ie.williamswalsh.web;

import ie.williamswalsh.domain.Car;
import ie.williamswalsh.domain.CarBrand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController {

    private static Map<String, Car> regCarMap;

    private static Map<String, Car> initRegistrationSystem() {
        regCarMap = new HashMap<>();
        regCarMap.put("11D60291", new Car("11D60291", CarBrand.VOLKSWAGON, "Golf", 2011));
        regCarMap.put("15KY1000", new Car("15KY1000", CarBrand.AUDI, "A3", 2015));
        return regCarMap;
    }

    @ResponseBody
    @GetMapping("/{registration}")
    public Mono<Car> getCarByRegistration(@PathVariable("registration") String registration) {
        initRegistrationSystem();
        return Mono.just(regCarMap.get(registration));
    }
}

