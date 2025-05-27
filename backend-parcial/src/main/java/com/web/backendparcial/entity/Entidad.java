package com.web.backendparcial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "entidad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nit;
    
    @Column(nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "entidad", cascade = CascadeType.ALL)
    private List<Contrato> contratos;
} 