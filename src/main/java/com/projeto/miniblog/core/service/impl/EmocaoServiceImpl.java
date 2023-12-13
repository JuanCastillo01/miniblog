package com.projeto.miniblog.core.service.impl;

import com.projeto.miniblog.core.model.EmocaoEntity;
import com.projeto.miniblog.core.repository.EmocaoRepository;
import com.projeto.miniblog.core.service.EmocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmocaoServiceImpl implements EmocaoService {
    @Autowired
    EmocaoRepository repository;

    public List<EmocaoEntity> listarTodasEmocoes() {
        return repository.findAll();
    }
}
