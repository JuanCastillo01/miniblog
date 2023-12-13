package com.projeto.miniblog.core.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.Temporal;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "postagens")
public class PostagemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String corpo;

    private String usuario;

    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "emocoesFk")
    private EmocaoEntity emocao;

}