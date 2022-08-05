package DevChallenger.bibliotecabackend.domain.service;

import DevChallenger.bibliotecabackend.domain.Exception.IdNotFoundException;
import DevChallenger.bibliotecabackend.domain.model.Book;
import DevChallenger.bibliotecabackend.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public Book registrerBook(Book book){
        return bookRepository.save(book);
    }
    public void deleteBook (Long id){
        try {
            bookRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new IdNotFoundException(
                    String.format("Livro com o id não encontrado %d", id)
            );
        }
    }

    public Book validbook(Long id){
        return bookRepository.findById(id).orElseThrow(() ->
                new IdNotFoundException(
                        String.format("Livro com o id não encontrado %d", id)));
    }
}
