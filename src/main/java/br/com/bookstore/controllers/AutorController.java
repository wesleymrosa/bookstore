package br.com.bookstore.controllers;

import br.com.bookstore.dtos.AutorDTO;
import br.com.bookstore.entities.Autor;
import br.com.bookstore.servicies.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {
    @Autowired
    private AutorService service;

    @PostMapping
    public ResponseEntity<Autor> create(@RequestBody Autor obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        Optional<Autor> obj = service.getById(id);
        return ResponseEntity.ok().body(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Autor>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody AutorDTO AutorDTO) {
        Optional<Autor> obj = service.getById(id);
        var AutorNOVO = obj.get();
        AutorNOVO.setId(AutorDTO.getId());
        AutorNOVO.setNome(AutorDTO.getNome());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(AutorNOVO));
    }
}
