package com.web.backendparcial.service.impl;

import com.web.backendparcial.dto.ContratoDTO;
import com.web.backendparcial.entity.Contrato;
import com.web.backendparcial.entity.Entidad;
import com.web.backendparcial.repository.ContratoRepository;
import com.web.backendparcial.repository.EntidadRepository;
import com.web.backendparcial.service.ContratoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContratoServiceImpl implements ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private EntidadRepository entidadRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContratoDTO create(ContratoDTO contratoDTO) {
        Entidad entidad = entidadRepository.findById(contratoDTO.getEntidadId())
                .orElseThrow(() -> new RuntimeException("Entidad no encontrada con el id: " + contratoDTO.getEntidadId()));
        
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        contrato.setEntidad(entidad);
        contrato = contratoRepository.save(contrato);
        return modelMapper.map(contrato, ContratoDTO.class);
    }

    @Override
    public ContratoDTO update(Long id, ContratoDTO contratoDTO) {
        if (!contratoRepository.existsById(id)) {
            throw new RuntimeException("Contrato no encontrado con el id: " + id);
        }
        
        Entidad entidad = entidadRepository.findById(contratoDTO.getEntidadId())
                .orElseThrow(() -> new RuntimeException("Entidad no encontrada con el id: " + contratoDTO.getEntidadId()));
        
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        contrato.setId(id);
        contrato.setEntidad(entidad);
        contrato = contratoRepository.save(contrato);
        return modelMapper.map(contrato, ContratoDTO.class);
    }

    @Override
    public void delete(Long id) {
        if (!contratoRepository.existsById(id)) {
            throw new RuntimeException("Contrato no encontrado con el id: " + id);
        }
        contratoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContratoDTO> findAll() {
        return contratoRepository.findAll().stream()
                .map(contrato -> modelMapper.map(contrato, ContratoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ContratoDTO findById(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado con el id: " + id));
        return modelMapper.map(contrato, ContratoDTO.class);
    }
} 