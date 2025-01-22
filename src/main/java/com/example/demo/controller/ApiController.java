
package com.example.demo.controller;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @GetMapping
    public HelloWorldResponse helloWorld() {
        HelloWorldResponse response = new HelloWorldResponse("Hello World");
        response.add(Link.of("http://localhost:8080/api/v1").withSelfRel());
        return response;
    }

    public static class HelloWorldResponse extends RepresentationModel<HelloWorldResponse> {
        private final String message;

        public HelloWorldResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
