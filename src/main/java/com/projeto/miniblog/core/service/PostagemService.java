package com.projeto.miniblog.core.service;

import com.projeto.miniblog.core.model.PostagemEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostagemService {

    List<PostagemEntity> listarPostagens();
    List<PostagemEntity> listarPostagensPorUsuario(String usuario);
    List<PostagemEntity> listarPostagensPorEmocoes(Long emocao);

    PostagemEntity criarPostagem(PostagemEntity dto);

    PostagemEntity buscraPorId(Long id);

    void deletarPostagem(Long id);

    void atualizarPostagem(PostagemEntity postagem);
}
