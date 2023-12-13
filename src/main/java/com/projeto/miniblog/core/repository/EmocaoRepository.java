package com.projeto.miniblog.core.repository;

import com.projeto.miniblog.core.model.EmocaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmocaoRepository extends JpaRepository<EmocaoEntity,Long> {
}
