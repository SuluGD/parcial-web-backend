package com.web.backendparcial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "contrato")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String identificador;
    
    @Column(nullable = false)
    private Double valor;
    
    @Column(name = "nombre_contratante", nullable = false)
    private String nombreContratante;
    
    @Column(name = "documento_contratante", nullable = false)
    private String documentoContratante;
    
    @Column(name = "nombre_contratista", nullable = false)
    private String nombreContratista;
    
    @Column(name = "documento_contratista", nullable = false)
    private String documentoContratista;
    
    @Column(name = "fecha_inicial", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    
    @Column(name = "fecha_final", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    
    @ManyToOne
    @JoinColumn(name = "entidad_id", nullable = false)
    private Entidad entidad;
} 