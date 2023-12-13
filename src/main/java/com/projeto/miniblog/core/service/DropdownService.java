package com.projeto.miniblog.core.service;

import com.projeto.miniblog.core.model.data.DropdownData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DropdownService {
    List<DropdownData> getEmocoes();
}
