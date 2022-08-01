package DevChallenger.bibliotecabackend.api.controller;

import DevChallenger.bibliotecabackend.domain.model.Book;
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

    @GetMapping
    public List<Book> listAllBooks(){
        return bookService.listAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> listOneBook (@PathVariable Long id){
        return bookService.listOneBook(id);
    }

    @PostMapping
    public Book registrerBook(@RequestBody Book book){
        return bookService.registrerBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> alterBook (@PathVariable Long id,@RequestBody Book book){
        Optional<Book> bookNew = bookService.listOneBook(id);
        if (bookNew.isPresent()) {
            BeanUtils.copyProperties(book,bookNew.get(), "id");
            Book bookSalvo = bookService.registrerBook(bookNew.get());
            return ResponseEntity.ok(bookSalvo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteBook (@PathVariable Long id){
        bookService.deleteBook(id);
    }

}