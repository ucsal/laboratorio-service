package com.sistema.laboratorio.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "laboratorios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Boolean disponivel;
}

