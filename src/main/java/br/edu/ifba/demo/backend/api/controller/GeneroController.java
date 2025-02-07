package br.edu.ifba.demo.backend.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.demo.backend.api.dto.GeneroDTO;
import br.edu.ifba.demo.backend.api.model.GeneroModel;
import br.edu.ifba.demo.backend.api.repository.GeneroRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/genero")
public class GeneroController {
    private GeneroRepository generoRepository;

    public GeneroController(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    // * Listar todos */
    @GetMapping("/listall")
    public List<GeneroDTO> listall() {
        List<GeneroModel> generosModel = generoRepository.findAll();
        List<GeneroDTO> generosDto = GeneroDTO.converterLista(generosModel);
        return generosDto;
    }

    // * Pegar por ID */
    @GetMapping("/getById/{id}")
    public GeneroDTO getById(@PathVariable Long id) {
        Optional<GeneroModel> genModel = generoRepository.findById(id);
        if (genModel.isPresent()) {
            GeneroDTO genDto = GeneroDTO.converter(genModel.get());
            return genDto;
        }
        return null;
    }

    // * Salvar (cadastrar/editar) */
    @PostMapping
    public ResponseEntity<GeneroModel> saveGenero(@RequestBody GeneroModel gen) {
        GeneroModel savedGen = generoRepository.save(gen);
        return new ResponseEntity<GeneroModel>(savedGen, HttpStatus.CREATED);
    }

    // * Deletar */
    @DeleteMapping("/{id}")
    public ResponseEntity<GeneroModel> deleteGenero(@PathVariable Long id) {
        Optional<GeneroModel> gen = generoRepository.findById(id);
        if (gen.isPresent()) {
            generoRepository.delete(gen.get());
            return new ResponseEntity<GeneroModel>(gen.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<GeneroModel>(HttpStatus.NOT_FOUND);
        }
    }
}
