package com.web.backendparcial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.backendparcial.dto.ContratoDTO;
import com.web.backendparcial.service.ContratoService;

@RestController
@RequestMapping("/api/contratos")
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