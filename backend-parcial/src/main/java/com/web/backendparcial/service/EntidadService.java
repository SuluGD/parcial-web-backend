package com.web.backendparcial.service;

import com.web.backendparcial.dto.EntidadDTO;
import java.util.List;

public interface EntidadService {
    EntidadDTO create(EntidadDTO entidadDTO);
    EntidadDTO update(Long id, EntidadDTO entidadDTO);
    void delete(Long id);
    List<EntidadDTO> findAll();
    EntidadDTO findById(Long id);
} 