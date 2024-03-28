package com.example.nameservice;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NameService {

    private NameMapper nameMapper;

    public NameService(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    public List<Name> findAll() {
        return nameMapper.findAll();
    }

    public List<Name> findByNameStartingWith(String prefix) {
        return nameMapper.findByNameStartingWith(prefix);
    }

    public Name findById(int id) {
        Optional<Name> name = this.nameMapper.findById(id);
        return name.orElseThrow(() -> new NameNotFoundException("name not found"));
    }
}
