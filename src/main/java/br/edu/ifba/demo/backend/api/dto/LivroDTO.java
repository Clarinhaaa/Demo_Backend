package br.edu.ifba.demo.backend.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.demo.backend.api.model.LivroModel;

public class LivroDTO implements Serializable {
    private Long id_livro;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano_publicacao;
    private Integer isbn;
    private Integer num_paginas;
    private Long genero_id;

    //* Converter model para DTO */
    public static LivroDTO converter(LivroModel livModel) {
        var livDto = new LivroDTO();
        livDto.setId_livro(livModel.getId_livro());
        livDto.setTitulo(livModel.getTitulo());
        livDto.setAutor(livModel.getAutor());
        livDto.setEditora(livModel.getEditora());
        livDto.setAno_publicacao(livModel.getAno_publicacao());
        livDto.setIsbn(livModel.getIsbn());
        livDto.setNum_paginas(livModel.getNum_paginas());
        livDto.setGenero_id(livModel.getGenero().getId_genero());
        return livDto;
    }

    public static List<LivroDTO> converterLista(List<LivroModel> listaLivModel) {
        List<LivroDTO> listaLivDto = new ArrayList<LivroDTO>();
        for (LivroModel liv : listaLivModel) {
            listaLivDto.add(LivroDTO.converter(liv));
        }
        return listaLivDto;
    }

    public LivroDTO() {}

    public LivroDTO(Long id_livro, String titulo, String autor, String editora, Integer ano_publicacao, Integer isbn,
            Integer num_paginas, Long genero_id) {
        this.id_livro = id_livro;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano_publicacao = ano_publicacao;
        this.isbn = isbn;
        this.num_paginas = num_paginas;
        this.genero_id = genero_id;
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

    public Long getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(Long genero_id) {
        this.genero_id = genero_id;
    }

    
}
