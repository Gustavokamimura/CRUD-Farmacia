package com.crudfarmacia.farmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crudfarmacia.farmacia.model.ProdutoModel;
import com.crudfarmacia.farmacia.repository.ProdutoRepository;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProdutoModel findById(@PathVariable Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ProdutoModel save(@RequestBody ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}
