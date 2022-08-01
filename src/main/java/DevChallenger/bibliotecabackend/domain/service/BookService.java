package DevChallenger.bibliotecabackend.domain.service;

import DevChallenger.bibliotecabackend.domain.model.Book;
import DevChallenger.bibliotecabackend.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }
    public Optional<Book> listOneBook(Long id){
        return bookRepository.findById(id);
    }
    public Book registrerBook(Book book){
        return bookRepository.save(book);
    }
    public void deleteBook (Long id){
        bookRepository.deleteById(id);
    }
}
