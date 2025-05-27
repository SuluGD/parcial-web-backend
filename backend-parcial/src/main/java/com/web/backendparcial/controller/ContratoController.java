package com.web.backendparcial.controller;

import com.web.backendparcial.dto.ContratoDTO;
import com.web.backendparcial.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratos")
@CrossOrigin(origins = "*")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public ResponseEntity<ContratoDTO> create(@RequestBody ContratoDTO contratoDTO) {
        return new ResponseEntity<>(contratoService.create(contratoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> update(@PathVariable Long id, @RequestBody ContratoDTO contratoDTO) {
        return ResponseEntity.ok(contratoService.update(id, contratoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contratoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ContratoDTO>> findAll() {
        return ResponseEntity.ok(contratoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(contratoService.findById(id));
    }
} 