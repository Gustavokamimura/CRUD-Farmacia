package com.crudfarmacia.farmacia.repository;

import com.crudfarmacia.farmacia.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
    List<CategoriaModel> findByNomeContaining(String nome);
}
