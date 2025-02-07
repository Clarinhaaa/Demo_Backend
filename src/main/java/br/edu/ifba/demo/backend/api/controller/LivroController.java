package br.edu.ifba.demo.backend.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.demo.backend.api.dto.LivroDTO;
import br.edu.ifba.demo.backend.api.model.LivroModel;
import br.edu.ifba.demo.backend.api.repository.GeneroRepository;
import br.edu.ifba.demo.backend.api.repository.LivroRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/livro")
public class LivroController {
    private LivroRepository livroRepository;
    private GeneroRepository generoRepository;

    public LivroController(LivroRepository livroRepository, GeneroRepository generoRepository) {
        this.livroRepository = livroRepository;
        this.generoRepository = generoRepository;
    }

    // * Listar todos */
    @GetMapping("/listall")
    public List<LivroDTO> listall() {
        List<LivroModel> livrosModel = livroRepository.findAll();
        List<LivroDTO> livrosDto = LivroDTO.converterLista(livrosModel);
        return livrosDto;
    }

    // * Pegar pelo ID */
    @GetMapping("/getById/{id}")
    public LivroDTO getById(@PathVariable Long id) {
        Optional<LivroModel> livModel = livroRepository.findById(id);
        if (livModel.isPresent()) {
            LivroDTO livDto = LivroDTO.converter(livModel.get());
            return livDto;
        }
        return null;
    }

    // * Salvar (cadastrar/editar) */
    @PostMapping
    public ResponseEntity<LivroDTO> saveLivro(@RequestBody LivroDTO liv) {
        LivroModel savedLiv = new LivroModel();

        savedLiv.setId_livro(liv.getId_livro());
        savedLiv.setTitulo(liv.getTitulo());
        savedLiv.setAutor(liv.getAutor());
        savedLiv.setEditora(liv.getEditora());
        savedLiv.setAno_publicacao(liv.getAno_publicacao());
        savedLiv.setIsbn(liv.getIsbn());
        savedLiv.setNum_paginas(liv.getNum_paginas());
        savedLiv.setGenero(generoRepository.findById(liv.getGenero_id()).get());
        livroRepository.save(savedLiv);

        LivroDTO livDto = LivroDTO.converter(savedLiv);
        return new ResponseEntity<LivroDTO>(livDto, HttpStatus.CREATED);
    }

    // * Deletar */
    @DeleteMapping("/{id}")
    public ResponseEntity<LivroModel> deleteLivro(@PathVariable Long id) {
        Optional<LivroModel> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            livroRepository.delete(livro.get());
            return new ResponseEntity<LivroModel>(livro.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
