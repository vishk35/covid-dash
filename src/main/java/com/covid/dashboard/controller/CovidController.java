package com.covid.dashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidController {

	 @GetMapping(value = "/{id}")
    public String findById(@PathVariable("id") Long id) {
        return "test";
    }
}
