package br.com.bookstore.servicies;

import br.com.bookstore.entities.Autor;
import br.com.bookstore.repository.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository repository;

    public Autor create(Autor obj) {

        return repository.save(obj);
    }

    public List<Autor> getAll() {

        return repository.findAll();
    }

    public Optional<Autor> getById(Long id) {

        return  repository.findById(id);
    }

    @Transactional
    public void delete(Long id) {

        repository.deleteById(id);
    }


}
