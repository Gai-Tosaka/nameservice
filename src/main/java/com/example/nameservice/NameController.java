package com.example.nameservice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class NameController {

    private NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/names")
    public List<Name> findNames(@RequestParam(required = false) String startsWith) {
        if (startsWith != null) {
            return nameService.findByNameStartingWith(startsWith);
        } else {
            return nameService.findAll();
        }
    }

    @GetMapping("/names/{id}")
    public Name findNameById(@PathVariable int id) {
        return nameService.findById(id);
    }
}
