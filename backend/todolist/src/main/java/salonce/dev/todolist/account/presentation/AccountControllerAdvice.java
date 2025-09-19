package salonce.dev.todolist.account.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import salonce.dev.todolist.task.application.exceptions.ApiError;
import salonce.dev.todolist.task.application.exceptions.TaskNotFound;

@RestControllerAdvice
public class AccountControllerAdvice {
    @ExceptionHandler(TaskNotFound.class)
    public ResponseEntity<ApiError> accountNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("A not found"));
    }
}
