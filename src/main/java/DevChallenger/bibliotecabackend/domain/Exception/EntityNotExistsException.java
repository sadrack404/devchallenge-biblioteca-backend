package DevChallenger.bibliotecabackend.domain.Exception;

public class EntityNotExistsException extends RuntimeException{
    private static final Long serialVersionUID = 1L;

    public EntityNotExistsException(String mesagem){
        super(mesagem);
    }
}
