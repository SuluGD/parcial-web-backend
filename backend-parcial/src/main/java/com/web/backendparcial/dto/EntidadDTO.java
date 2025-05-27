package com.web.backendparcial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntidadDTO {
    private Long id;
    private String nit;
    private String nombre;
    private List<ContratoDTO> contratos;
} 