package ie.williamswalsh.reactive_web_demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherCtrlr {

    @GetMapping(value = "/getString")
    @ResponseStatus(HttpStatus.CREATED)
    public String getMethodForTesting() {
        return "getMethodForTesting output";
    }
}
