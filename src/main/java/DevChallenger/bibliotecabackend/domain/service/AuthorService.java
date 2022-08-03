package DevChallenger.bibliotecabackend.domain.service;


import DevChallenger.bibliotecabackend.domain.Exception.IdNotFoundException;
import DevChallenger.bibliotecabackend.domain.model.Author;
import DevChallenger.bibliotecabackend.domain.repository.AurhorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorService {
    @Autowired
    AurhorRepository authorRepository;
    public Author registrerAuthor(Author author){
        return authorRepository.save(author);
    }
    public void deleteAuthor (Long id){
        authorRepository.deleteById(id);
    }

    public Author validAuthor (Long id) {
        return authorRepository.findById(id).orElseThrow(
                () -> new IdNotFoundException("Id não encontrado no cadastro"));
    }
}
