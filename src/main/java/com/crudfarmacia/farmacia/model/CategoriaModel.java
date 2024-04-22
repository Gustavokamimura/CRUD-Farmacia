package com.crudfarmacia.farmacia.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome categoria é Obrigatório")
    @Size(min = 5, max = 255, message = "O atributo nome categoria deve conter no mínimo 5 e no máximo 255 caracteres")
    private String nome;

    @NotBlank(message = "O atributo descrição é Obrigatório")
    @Size(min = 5, max = 255, message = "O atributo descrição deve conter no mínimo 5 e no máximo 255 caracteres")
    private String descricao;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("categoria")
    private List<Produto> produtos; // Corrigido para produtos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() { // Adicionado getter para produtos
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) { // Adicionado setter para produtos
        this.produtos = produtos;
    }
}
