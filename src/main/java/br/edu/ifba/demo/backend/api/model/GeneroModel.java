package br.edu.ifba.demo.backend.api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "genero")
public class GeneroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Long id_genero;

    @Column(name = "nome_genero", nullable = false)
    private String nome_genero;

    @Column(name = "status_genero", nullable = false)
    private boolean status_genero;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    List<LivroModel> livros;
}
