package salonce.dev.todolist.article.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import salonce.dev.todolist.account.infrastructure.security.AccountPrincipal;
import salonce.dev.todolist.article.application.ArticleService;
import salonce.dev.todolist.article.presentation.dtos.ArticleSaveRequest;
import salonce.dev.todolist.article.presentation.dtos.ArticleResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> getAllArticles(){
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @GetMapping("/api/articles/{slug}")
    public ResponseEntity<ArticleResponse> getArticleResponse(@AuthenticationPrincipal AccountPrincipal principal, @PathVariable String slug){
        return ResponseEntity.ok(articleService.getArticle(slug));
    }

    // limit permissions to admin and mod in the service
    @PostMapping("/api/articles")
    public ResponseEntity<ArticleResponse> saveArticle(@AuthenticationPrincipal AccountPrincipal principal, @RequestBody ArticleSaveRequest articleSaveRequest){
        return ResponseEntity.ok(articleService.saveArticle(principal, articleSaveRequest));
    }
}
