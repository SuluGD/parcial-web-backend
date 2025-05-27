package com.web.backendparcial.service.impl;

import com.web.backendparcial.dto.EntidadDTO;
import com.web.backendparcial.entity.Entidad;
import com.web.backendparcial.repository.EntidadRepository;
import com.web.backendparcial.service.EntidadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EntidadServiceImpl implements EntidadService {

    @Autowired
    private EntidadRepository entidadRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EntidadDTO create(EntidadDTO entidadDTO) {
        Entidad entidad = modelMapper.map(entidadDTO, Entidad.class);
        entidad = entidadRepository.save(entidad);
        return modelMapper.map(entidad, EntidadDTO.class);
    }

    @Override
    public EntidadDTO update(Long id, EntidadDTO entidadDTO) {
        if (!entidadRepository.existsById(id)) {
            throw new RuntimeException("Entidad no encontrada con el id: " + id);
        }
        Entidad entidad = modelMapper.map(entidadDTO, Entidad.class);
        entidad.setId(id);
        entidad = entidadRepository.save(entidad);
        return modelMapper.map(entidad, EntidadDTO.class);
    }

    @Override
    public void delete(Long id) {
        if (!entidadRepository.existsById(id)) {
            throw new RuntimeException("Entidad no encontrada con el id: " + id);
        }
        entidadRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntidadDTO> findAll() {
        return entidadRepository.findAll().stream()
                .map(entidad -> modelMapper.map(entidad, EntidadDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public EntidadDTO findById(Long id) {
        Entidad entidad = entidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entidad not found with id: " + id));
        return modelMapper.map(entidad, EntidadDTO.class);
    }
} 