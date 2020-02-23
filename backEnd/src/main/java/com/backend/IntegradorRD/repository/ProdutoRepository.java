package com.backend.IntegradorRD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.IntegradorRD.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
