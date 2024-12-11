package br.edu.ifba.demo.backend.api.dto;

import java.io.Serializable;

import br.edu.ifba.demo.backend.api.model.LivroModel;

public class LivroDTO implements Serializable {
    private Long id_livro;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano_publicacao;
    private String genero;
    private Integer isbn;
    private Integer num_paginas;

    public static LivroDTO converter(LivroModel livroModel) {
        var livro = new LivroDTO();
        livro.setId_livro(livroModel.getId_livro());
        livro.setTitulo(livroModel.getTitulo());
        livro.setAutor(livroModel.getAutor());
        livro.setEditora(livroModel.getEditora());
        livro.setAno_publicacao(livroModel.getAno_publicacao());
        livro.setGenero(livroModel.getGenero());
        livro.setIsbn(livroModel.getIsbn());
        livro.setNum_paginas(livroModel.getNum_paginas());
        return livro;
    }

    public LivroDTO() {
        super();
    }

    public LivroDTO(Long id_livro, String titulo, String autor, String editora, Integer ano_publicacao, String genero,
            Integer isbn, Integer num_paginas) {
        this.id_livro = id_livro;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano_publicacao = ano_publicacao;
        this.genero = genero;
        this.isbn = isbn;
        this.num_paginas = num_paginas;
    }

    public LivroDTO(String titulo, String autor, String editora, Integer ano_publicacao, String genero, Integer isbn,
            Integer num_paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano_publicacao = ano_publicacao;
        this.genero = genero;
        this.isbn = isbn;
        this.num_paginas = num_paginas;
    }

    public Long getId_livro() {
        return id_livro;
    }

    public void setId_livro(Long id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(Integer ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getNum_paginas() {
        return num_paginas;
    }

    public void setNum_paginas(Integer num_paginas) {
        this.num_paginas = num_paginas;
    }

}
