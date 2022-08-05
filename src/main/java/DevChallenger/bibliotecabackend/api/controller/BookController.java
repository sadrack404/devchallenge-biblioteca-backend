package DevChallenger.bibliotecabackend.api.controller;

import DevChallenger.bibliotecabackend.domain.Exception.EntityException;
import DevChallenger.bibliotecabackend.domain.Exception.IdNotFoundException;
import DevChallenger.bibliotecabackend.domain.model.Book;
import DevChallenger.bibliotecabackend.domain.repository.BookRepository;
import DevChallenger.bibliotecabackend.domain.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/obras")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book listOneBook(@PathVariable Long id) {
        return bookService.validbook(id);
    }

    @PostMapping
    public Book registrerBook(@RequestBody Book book) {
        return bookService.registrerBook(book);
    }

    @PutMapping("/{id}")
    public Book alterBook(@PathVariable Long id, @RequestBody Book book) {

        Book bookNew = bookService.validbook(id);
        BeanUtils.copyProperties(book, bookNew, "id");
        try {
            return bookService.registrerBook(bookNew);
        } catch (IdNotFoundException e) {
            throw new EntityException(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

}