package DevChallenger.bibliotecabackend.domain.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException {

    private static final Long serialVersionUID = 1L;

    public IdNotFoundException(String mesagem){
        super(mesagem);
    }
}