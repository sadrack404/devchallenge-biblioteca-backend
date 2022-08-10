package DevChallenger.bibliotecabackend.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String image;

    @ManyToOne
    private Publisher publisher;

    @ManyToOne
    private Author author;

}
