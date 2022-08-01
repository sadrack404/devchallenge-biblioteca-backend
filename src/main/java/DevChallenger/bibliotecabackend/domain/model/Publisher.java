package DevChallenger.bibliotecabackend.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String namePublisher;

}
