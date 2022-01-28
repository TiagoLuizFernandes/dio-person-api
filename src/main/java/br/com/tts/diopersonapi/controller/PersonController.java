package br.com.tts.diopersonapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/people")
public class PersonController {

    @GetMapping
    public String hello() {
        return "oi";
    }

}
