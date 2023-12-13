package com.projeto.miniblog.api.controller;

import com.projeto.miniblog.core.model.PostagemEntity;
import com.projeto.miniblog.core.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private PostagemService postagemService;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        List<PostagemEntity> postagens = postagemService.listarPostagens();
        model.addAttribute("postagens", postagens);
        return "admin";
    }
    @GetMapping("/deletar-postagem/{id}")
    public String deletarPostagem(@PathVariable Long id) {
        postagemService.deletarPostagem(id);
        return "redirect:/admin";
    }
}
