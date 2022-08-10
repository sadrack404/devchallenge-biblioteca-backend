package DevChallenger.bibliotecabackend.domain.service;

import DevChallenger.bibliotecabackend.domain.Exception.EntityNotExistsException;
import DevChallenger.bibliotecabackend.domain.Exception.IdNotFoundException;
import DevChallenger.bibliotecabackend.domain.model.Author;
import DevChallenger.bibliotecabackend.domain.repository.AurhorRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
@Service
public class AuthorService {
    @Autowired
    AurhorRepository authorRepository;

    public Author registrerAuthor(Author author){
        return authorRepository.save(author);
    }

    public void deleteAuthor (Long id){
        try {
            authorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new IdNotFoundException(String.format("O autor com o id %d não foi encontrado", id));
        }
    }

    public Author validAuthor (Long id) {
        return authorRepository.findById(id).orElseThrow(
                () -> new IdNotFoundException(
                        String.format("O autor com o id %d não foi encontrado", id)
                )
        );
    }
}