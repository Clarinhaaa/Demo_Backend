package br.edu.ifba.demo.backend.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.demo.backend.api.model.GeneroModel;
import br.edu.ifba.demo.backend.api.model.LivroModel;

public class GeneroDTO implements Serializable {
    private Long id_genero;
    private String nome_genero;
    private boolean status_genero;
    private List<LivroDTO> livros;

    public static GeneroDTO converter(GeneroModel genModel) {
        GeneroDTO genDto = new GeneroDTO();
        genDto.setId_genero(genModel.getId_genero());
        genDto.setNome_genero(genModel.getNome_genero());
        genDto.setStatus_genero(genModel.isStatus_genero());
        genDto.setLivros(LivroDTO.converterLista(genModel.getLivros()));
        return genDto;
    }

    public static List<GeneroDTO> converterLista(List<GeneroModel> listaGenModel) {
        List<GeneroDTO> listaGenDto = new ArrayList<GeneroDTO>();
        for (GeneroModel gen : listaGenModel) {
            listaGenDto.add(GeneroDTO.converter(gen));
        }
        return listaGenDto;
    }

    public GeneroDTO() {}

    public GeneroDTO(Long id_genero, String nome_genero, boolean status_genero, List<LivroDTO> livros) {
        this.id_genero = id_genero;
        this.nome_genero = nome_genero;
        this.status_genero = status_genero;
        this.livros = livros;
    }

    public Long getId_genero() {
        return id_genero;
    }

    public void setId_genero(Long id_genero) {
        this.id_genero = id_genero;
    }

    public String getNome_genero() {
        return nome_genero;
    }

    public void setNome_genero(String nome_genero) {
        this.nome_genero = nome_genero;
    }

    public boolean isStatus_genero() {
        return status_genero;
    }

    public void setStatus_genero(boolean status_genero) {
        this.status_genero = status_genero;
    }

    public List<LivroDTO> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroDTO> livros) {
        this.livros = livros;
    }
}
