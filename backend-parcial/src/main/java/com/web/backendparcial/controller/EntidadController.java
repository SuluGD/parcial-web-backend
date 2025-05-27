package com.web.backendparcial.controller;

import com.web.backendparcial.dto.EntidadDTO;
import com.web.backendparcial.service.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entidades")
@CrossOrigin(origins = "*")
public class EntidadController {

    @Autowired
    private EntidadService entidadService;

    @PostMapping
    public ResponseEntity<EntidadDTO> create(@RequestBody EntidadDTO entidadDTO) {
        return new ResponseEntity<>(entidadService.create(entidadDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntidadDTO> update(@PathVariable Long id, @RequestBody EntidadDTO entidadDTO) {
        return ResponseEntity.ok(entidadService.update(id, entidadDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entidadService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EntidadDTO>> findAll() {
        return ResponseEntity.ok(entidadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(entidadService.findById(id));
    }
} 