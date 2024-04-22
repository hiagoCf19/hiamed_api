package med.hia.api.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExeptionEntityHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleNotFound(){
        return ResponseEntity .notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBadRequest(MethodArgumentNotValidException exception){
        var errors= exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(ErrorBadRequestDTO::new));
    }
    private record ErrorBadRequestDTO(String campo, String message){
        public ErrorBadRequestDTO(FieldError erro){
           this(erro.getField(), erro.getDefaultMessage());
        }
    }

}
