package com.lambdaschool.com.countries.controllers;

import com.lambdaschool.com.countries.models.HelloModels;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @GetMapping("/countries/{msg}")
    public ResponseEntity<?> getMessage(@PathVariable String msg)
    {
        HelloModels myMsg = new HelloModels(msg);
        return new ResponseEntity<>(myMsg, HttpStatus.OK);
    }
}
