package com.projeto.miniblog.api.controller;

import com.projeto.miniblog.core.model.EmocaoEntity;
import com.projeto.miniblog.core.model.PostagemEntity;
import com.projeto.miniblog.core.service.EmocaoService;
import com.projeto.miniblog.core.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EditarController {
    @Autowired
    private PostagemService postagemService;
    @Autowired
    private EmocaoService emocaoService;

    @GetMapping("/editar-postagem/{id}")
    public String editarPostagemPage(@PathVariable Long id, Model model) {
        PostagemEntity postagem = postagemService.buscraPorId(id);
        List<EmocaoEntity> emoList = emocaoService.listarTodasEmocoes();
        model.addAttribute("postagem", postagem);
        model.addAttribute("emoList", emoList);
        return "editar-postagem";
    }

    @PostMapping("/atualizar-postagem")
    public String atualizarPostagem(@ModelAttribute PostagemEntity postagem) {
        postagemService.atualizarPostagem(postagem);
        return "redirect:/admin";
    }


}

