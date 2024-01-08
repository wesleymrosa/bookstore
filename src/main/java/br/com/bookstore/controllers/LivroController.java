package br.com.bookstore.controllers;

import br.com.bookstore.dtos.LivroDTO;
import br.com.bookstore.entities.Livro;
import br.com.bookstore.repository.LivroRepository;
import br.com.bookstore.servicies.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private LivroService service;

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        Optional<Livro> obj = service.getById(id);
        return ResponseEntity.ok().body(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
        Optional<Livro> obj = service.getById(id);
        var livroNOVO = obj.get();
            livroNOVO.setId(livroDTO.getId());
            livroNOVO.setNome(livroDTO.getNome());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(livroNOVO));
    }
}
