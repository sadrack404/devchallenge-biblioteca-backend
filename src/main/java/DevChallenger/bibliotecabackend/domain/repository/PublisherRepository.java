package DevChallenger.bibliotecabackend.domain.repository;

import DevChallenger.bibliotecabackend.domain.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
