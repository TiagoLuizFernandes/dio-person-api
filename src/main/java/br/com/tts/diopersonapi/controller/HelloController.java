package br.com.tts.diopersonapi.controller;

import br.com.tts.diopersonapi.dto.MessageResponseDTO;
import br.com.tts.diopersonapi.dto.request.PersonDTO;
import br.com.tts.diopersonapi.exception.PersonNotFoundException;
import br.com.tts.diopersonapi.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping(path = "/api/v1/hello")
public class HelloController {


    @GetMapping
    public String hello(){

        return "Hello";

    }

}
