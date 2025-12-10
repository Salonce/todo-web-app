package salonce.dev.todolist.article.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import salonce.dev.todolist.article.application.exceptions.ArticleNotFound;
import salonce.dev.todolist.task.application.exceptions.ApiError;

@RestControllerAdvice
public class ArticleControllerAdvice {
    @ExceptionHandler(ArticleNotFound.class)
    public ResponseEntity<ApiError> articleNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("Article not found"));
    }
}
