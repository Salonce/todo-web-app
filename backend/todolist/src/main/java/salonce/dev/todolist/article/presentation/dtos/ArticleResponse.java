package salonce.dev.todolist.article.presentation.dtos;

import java.time.LocalDateTime;

public record ArticleResponse (String title, String slug, String content, String authorName, LocalDateTime createdAt, LocalDateTime updatedAt){
}
