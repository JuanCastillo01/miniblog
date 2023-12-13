package com.projeto.miniblog.core.service.impl;

import com.projeto.miniblog.core.model.PostagemEntity;
import com.projeto.miniblog.core.repository.PostagemRepository;
import com.projeto.miniblog.core.service.PostagemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostagemServiceImpl implements PostagemService {
    @Autowired
    PostagemRepository repository;

    public List<PostagemEntity> listarPostagens() {
        Sort sortByDataCriacaoDesc = Sort.by(Sort.Direction.DESC, "dataCriacao");
        return repository.findAll(sortByDataCriacaoDesc);
    }

    public List<PostagemEntity> listarPostagensPorUsuario(String usuario) {
        return repository.findByUsuario(usuario);
    }

    public List<PostagemEntity> listarPostagensPorEmocoes(Long emocao) {
        return repository.findByEmocaoId(emocao);
    }

    @Override
    public PostagemEntity criarPostagem(PostagemEntity dto) {

        return repository.save(dto);
    }

    @Override
    public PostagemEntity buscraPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Postagem not found with id: " + id));
    }

    @Override
    public void deletarPostagem(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void atualizarPostagem(PostagemEntity postagem) {
        if (repository.existsById(postagem.getId())){
            repository.save(postagem);
        }
    }
}
