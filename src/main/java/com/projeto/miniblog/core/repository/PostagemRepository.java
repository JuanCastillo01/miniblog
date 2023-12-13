package com.projeto.miniblog.core.repository;

import com.projeto.miniblog.core.model.PostagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemEntity, Long> {

    List<PostagemEntity> findByUsuario(String usuario);

    List<PostagemEntity> findByEmocaoId(Long emocao);
}
