package com.projeto.miniblog.api.controller;

import com.projeto.miniblog.core.model.PostagemEntity;
import com.projeto.miniblog.core.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListagemPostController {
    @Autowired
    private PostagemService postagemService;

    @GetMapping("/")
    public String home() {
        return "listar-postagens";
    }

    @GetMapping("/listar-postagens")
    public String mainPage(Model model) {
        List<PostagemEntity> postagens = postagemService.listarPostagens();
        model.addAttribute("postagens", postagens);
        return "listar-postagens";
    }
}

