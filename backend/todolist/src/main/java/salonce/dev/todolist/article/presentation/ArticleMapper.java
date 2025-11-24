package salonce.dev.todolist.article.presentation;

import salonce.dev.todolist.article.domain.Article;
import salonce.dev.todolist.article.presentation.dtos.ArticleResponse;

public class ArticleMapper {
    public static ArticleResponse toArticleResponse(Article article){
        return new ArticleResponse(article.getTitle(), article.getSlug(), article.getContent(), article.getAuthor().getName(), article.getCreatedAt(), article.getUpdatedAt());
    }
}
