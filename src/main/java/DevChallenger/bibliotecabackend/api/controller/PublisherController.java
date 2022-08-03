package DevChallenger.bibliotecabackend.api.controller;


import DevChallenger.bibliotecabackend.domain.model.Book;
import DevChallenger.bibliotecabackend.domain.model.Publisher;
import DevChallenger.bibliotecabackend.domain.service.PublisherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/publicadora")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public List<Publisher> listAllBooks(){
        return publisherService.listAllPublishers();
    }

    @GetMapping("/{id}")
    public Optional<Publisher> listOneBook (@PathVariable Long id){
        return publisherService.listOnePublisher(id);
    }

    @PostMapping
    public Publisher registrerBook(@RequestBody Publisher publisher){
        return publisherService.registrerPublisher(publisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> alterBook (@PathVariable Long id, @RequestBody Book book){
        Optional<Publisher> bookNew = publisherService.listOnePublisher(id);
        if (bookNew.isPresent()) {
            BeanUtils.copyProperties(book,bookNew.get(), "id");
            Publisher publisherSave = publisherService.registrerPublisher(bookNew.get());
            return ResponseEntity.ok(publisherSave);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public void deleteBook (@PathVariable Long id){
        publisherService.deletePublisher(id);
    }
}