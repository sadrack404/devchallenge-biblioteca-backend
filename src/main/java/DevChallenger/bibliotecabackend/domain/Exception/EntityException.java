package DevChallenger.bibliotecabackend.domain.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EntityException extends RuntimeException{
    private static final Long serialVersionUID = 1L;
    public EntityException(String mesagem){
        super(mesagem);
    }
}
