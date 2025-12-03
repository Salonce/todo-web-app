package salonce.dev.todolist.article.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import salonce.dev.todolist.task.application.exceptions.ApiError;
import salonce.dev.todolist.task.application.exceptions.TaskNotFound;

@RestControllerAdvice
public class ArticleControllerAdvice {
    @ExceptionHandler(TaskNotFound.class)
    public ResponseEntity<ApiError> articleNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Article not found"));
    }
}
