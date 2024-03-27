package com.example.nameservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NameController {

    private NameMapper nameMapper;

    public NameController(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    @GetMapping("/names")

    public List<Name> findNames(@RequestParam(required = false) String startsWith) {
        if (startsWith != null) {
            return nameMapper.findByNameStartingWith(startsWith);
        } else {
            return nameMapper.findAll();
        }
    }
}
