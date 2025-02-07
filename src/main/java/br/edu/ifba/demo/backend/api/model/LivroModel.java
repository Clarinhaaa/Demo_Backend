package br.edu.ifba.demo.backend.api.model;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "livro")
public class LivroModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livro")
    private Long id_livro;
    
    @Column(name = "titulo", nullable = false)
	private String titulo;

	@Column(name = "autor", nullable = false)
    private String autor;
    
    @Column(name = "editora", nullable = true)
    private String editora;
    
    @Column(name = "ano_publicacao", nullable = true)
    private Integer ano_publicacao;

    @Column(name = "isbn", nullable = true)
    private Integer isbn;

    @Column(name = "num_paginas", nullable = true)
    private Integer num_paginas;

    @ManyToOne
    @JoinColumn(name = "genero", nullable = false)
    private GeneroModel genero;
}
