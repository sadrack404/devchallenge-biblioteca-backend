package DevChallenger.bibliotecabackend.api.controller;

import DevChallenger.bibliotecabackend.domain.Exception.EnitityException;
import DevChallenger.bibliotecabackend.domain.Exception.IdNotFoundException;
import DevChallenger.bibliotecabackend.domain.model.Author;
import DevChallenger.bibliotecabackend.domain.repository.AurhorRepository;
import DevChallenger.bibliotecabackend.domain.service.AuthorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/autores")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private AurhorRepository authorRepository;

    @GetMapping
    public List<Author> listAllAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author listOneAuthor(Long id){
        return authorService.validAuthor(id);
    }
    @PostMapping
    public Author registerAuthor(@RequestBody Author author){
        return authorService.registrerAuthor(author);
    }

    @PutMapping("/{id}")
    public Author alterAuthor (@PathVariable Long id, @RequestBody Author author){
        var authorNew = authorService.validAuthor(id);
        BeanUtils.copyProperties(author, authorNew, "id");
        try {
           return authorService.registrerAuthor(authorNew);
        } catch (IdNotFoundException e) {
            throw new EnitityException(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public void deleteAuthor (@PathVariable Long id){
       var a  = authorService.validAuthor(id);
       authorService.deleteAuthor(id);
    }
}