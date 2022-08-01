package DevChallenger.bibliotecabackend.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String authorName;

    @Column
    private int age;

}