package com.projeto.miniblog.core.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "emocoes", uniqueConstraints = {
        @UniqueConstraint(name = "nomeEmocao_UNIQUE", columnNames = {"nomeEmocao"})
})
public class EmocaoEntity  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cor;
    private String descricao;
}

