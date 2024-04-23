package com.crudfarmacia.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudfarmacia.farmacia.model.ProdutoModel;


public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}

