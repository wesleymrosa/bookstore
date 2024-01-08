package br.com.bookstore.servicies;

import br.com.bookstore.entities.Livro;
import br.com.bookstore.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    public Livro create(Livro obj) {
        return repository.save(obj);
    }

    public List<Livro> getAll() {
        return repository.findAll();
    }

    public Optional<Livro> getById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
