package DevChallenger.bibliotecabackend.api.controller;

import DevChallenger.bibliotecabackend.domain.Exception.EntityException;
import DevChallenger.bibliotecabackend.domain.model.Book;
import DevChallenger.bibliotecabackend.domain.model.Publisher;
import DevChallenger.bibliotecabackend.domain.repository.PublisherRepository;
import DevChallenger.bibliotecabackend.domain.service.PublisherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/publicadora")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping
    public List<Publisher> listAllPublisher(){
        return publisherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Publisher listOnePublisher (@PathVariable Long id){
        return publisherService.validPublisher(id);
    }

    @PostMapping
    public Publisher registrerPublisher(@RequestBody Publisher publisher){
        return publisherService.registrerPublisher(publisher);
    }

    @PutMapping("/{id}")
    public Publisher alterPublisher (@PathVariable Long id, @RequestBody Book book){

        var bookNew = publisherService.validPublisher(id);
        BeanUtils.copyProperties(book,bookNew, "id");
        try {
            return publisherService.registrerPublisher(bookNew);
        } catch (EmptyResultDataAccessException e){
            throw new EntityException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletePublisher (@PathVariable Long id){
        publisherService.deletePublisher(id);
    }
}