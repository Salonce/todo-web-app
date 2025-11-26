package salonce.dev.todolist.article.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import salonce.dev.todolist.account.infrastructure.security.AccountPrincipal;
import salonce.dev.todolist.article.application.ArticleService;
import salonce.dev.todolist.article.presentation.dtos.ArticleCreateRequest;
import salonce.dev.todolist.article.presentation.dtos.ArticleViewResponse;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/api/articles")
    public ResponseEntity<Page<ArticleViewResponse>> getAllArticles(Pageable pageable){
        return ResponseEntity.ok(articleService.getAllArticles(pageable));
    }

    @GetMapping("/api/articles/{slug}")
    public ResponseEntity<ArticleViewResponse> getArticleResponse(@AuthenticationPrincipal AccountPrincipal principal, @PathVariable String slug){
        return ResponseEntity.ok(articleService.getArticle(slug));
    }

    // limit permissions to admin and mod in the service
    @PostMapping("/api/articles")
    public ResponseEntity<ArticleViewResponse> saveArticle(@AuthenticationPrincipal AccountPrincipal principal, @RequestBody ArticleCreateRequest articleCreateRequest){
        return ResponseEntity.ok(articleService.saveArticle(principal, articleCreateRequest));
    }
}
