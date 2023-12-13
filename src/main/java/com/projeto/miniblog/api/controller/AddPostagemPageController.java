package com.projeto.miniblog.api.controller;

import com.projeto.miniblog.core.model.EmocaoEntity;
import com.projeto.miniblog.core.model.PostagemEntity;
import com.projeto.miniblog.core.service.EmocaoService;
import com.projeto.miniblog.core.service.PostagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AddPostagemPageController {
    @Autowired
    PostagemService postagemService;
    @Autowired
    EmocaoService emocaoService;

    // Display the form for creating postagens
    @GetMapping("/create-postagem")
    public String showCreatePostagemForm(Model model) {
        List<EmocaoEntity> emoList = emocaoService.listarTodasEmocoes();
        model.addAttribute("emoList", emoList);
        return "create-postagem";
    }
    @PostMapping("/criar-postagem")

    public String criarPost(@ModelAttribute("postagemEntity") @Valid PostagemEntity postagemEntity, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-postagem";
        }
        postagemEntity.setDataCriacao(LocalDateTime.now());
        // Process the form submission and save the post
        postagemService.criarPostagem(postagemEntity);

        // Redirect to a success page or another endpoint
        return "redirect:/listar-postagens";
    }

}
