package DevChallenger.bibliotecabackend.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "name")
    private String authorName;

    @Column(nullable = false)
    private LocalDate birthDate;

}