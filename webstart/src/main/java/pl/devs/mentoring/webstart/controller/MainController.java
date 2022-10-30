package pl.devs.mentoring.webstart.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MainController {

    @GetMapping("/my-test")
    public SomeObject test() {
        System.out.println("Got a request");
        return new SomeObject("Hello");
    }
}

class SomeObject {
    String message;

    public SomeObject(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
