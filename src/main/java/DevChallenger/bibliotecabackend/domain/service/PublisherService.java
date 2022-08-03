package DevChallenger.bibliotecabackend.domain.service;

import DevChallenger.bibliotecabackend.domain.Exception.IdNotFoundException;
import DevChallenger.bibliotecabackend.domain.model.Publisher;
import DevChallenger.bibliotecabackend.domain.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;

@Service
public class PublisherService {
    @Autowired
    PublisherRepository publisherRepository;

    public Publisher registrerPublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }
    public void deletePublisher (Long id){
        try {
            publisherRepository.deleteById(id);
        } catch (EmptyStackException e){
            throw new IdNotFoundException(
                    String.format("Id não encontado %d", id)
            );
        };
    }



}