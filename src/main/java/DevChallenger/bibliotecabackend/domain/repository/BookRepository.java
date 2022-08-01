package DevChallenger.bibliotecabackend.domain.repository;


import DevChallenger.bibliotecabackend.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}