package com.web.backendparcial.service;

import com.web.backendparcial.dto.ContratoDTO;
import java.util.List;

public interface ContratoService {
    ContratoDTO create(ContratoDTO contratoDTO);
    ContratoDTO update(Long id, ContratoDTO contratoDTO);
    void delete(Long id);
    List<ContratoDTO> findAll();
    ContratoDTO findById(Long id);
} 