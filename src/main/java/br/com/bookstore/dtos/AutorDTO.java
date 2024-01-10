package br.com.bookstore.dtos;

import br.com.bookstore.entities.Autor;

import java.io.Serializable;

public class AutorDTO implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long id;
    private String nome;

    public AutorDTO() {
    }

    public AutorDTO(Autor obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

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

}
