package com.crudfarmacia.farmacia.controller;

import com.crudfarmacia.farmacia.model.CategoriaModel;
import com.crudfarmacia.farmacia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<CategoriaModel> findAll() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaModel findById(@PathVariable Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public CategoriaModel save(@RequestBody CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
    }

    @GetMapping("/nome/{nome}")
    public List<CategoriaModel> findByNomeContaining(@PathVariable String nome) {
        return categoriaRepository.findByNomeContaining(nome);
    }
}
