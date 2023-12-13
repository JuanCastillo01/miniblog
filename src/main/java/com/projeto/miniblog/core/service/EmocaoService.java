package com.projeto.miniblog.core.service;

import com.projeto.miniblog.core.model.EmocaoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmocaoService {
    List<EmocaoEntity> listarTodasEmocoes();
}
