package DevChallenger.bibliotecabackend.domain.service;

import DevChallenger.bibliotecabackend.domain.Exception.IdNotFoundException;
import DevChallenger.bibliotecabackend.domain.model.Author;
import DevChallenger.bibliotecabackend.domain.model.Book;
import DevChallenger.bibliotecabackend.domain.model.Publisher;
import DevChallenger.bibliotecabackend.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorService authorService;

    @Autowired
    PublisherService publisherService;

    public Book registrerBook(Book book){
        Long authorId = book.getAuthor().getId();
        Author author = authorService.validAuthor(authorId);
        book.setAuthor(author);

        Long publisherId = book.getPublisher().getId();
        Publisher publisher = publisherService.validPublisher(publisherId);
        book.setPublisher(publisher);

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
