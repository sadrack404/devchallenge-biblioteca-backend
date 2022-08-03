package DevChallenger.bibliotecabackend.domain.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EnitityException extends RuntimeException{

    private static final Long serialVersionUID = 1L;

    public EnitityException(String mesagem){
        super(mesagem);
    }
}
