package DevChallenger.bibliotecabackend.domain.repository;

import DevChallenger.bibliotecabackend.domain.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AurhorRepository extends JpaRepository<Author, Long> {

}
