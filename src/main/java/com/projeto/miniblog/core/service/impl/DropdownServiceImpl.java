package com.projeto.miniblog.core.service.impl;

import com.projeto.miniblog.core.model.data.DropdownData;
import com.projeto.miniblog.core.service.DropdownService;
import com.projeto.miniblog.core.service.EmocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DropdownServiceImpl implements DropdownService {
    @Autowired
    EmocaoService emocaoService;
    public List<DropdownData> getEmocoes() {

        return emocaoService.listarTodasEmocoes().stream().map(
                (emocaoEntity -> new DropdownData(emocaoEntity.getId().toString(),emocaoEntity.getNome()))).collect(Collectors.toList());
    }
}
