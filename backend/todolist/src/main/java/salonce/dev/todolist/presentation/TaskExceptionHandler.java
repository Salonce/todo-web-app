package salonce.dev.todolist.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import salonce.dev.todolist.application.exceptions.ApiError;
import salonce.dev.todolist.application.exceptions.TaskNotFound;

@RestControllerAdvice
public class TaskExceptionHandler {

    @ExceptionHandler(TaskNotFound.class)
    public ResponseEntity<ApiError> taskNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Task not found"));
    }
}
