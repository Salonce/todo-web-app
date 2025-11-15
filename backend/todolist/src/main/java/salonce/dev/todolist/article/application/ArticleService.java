package salonce.dev.todolist.article.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import salonce.dev.todolist.account.application.AccountService;
import salonce.dev.todolist.account.domain.Account;
import salonce.dev.todolist.account.infrastructure.security.AccountPrincipal;
import salonce.dev.todolist.article.application.exceptions.ArticleNotFound;
import salonce.dev.todolist.article.domain.Article;
import salonce.dev.todolist.article.infrastructure.ArticleRepository;
import salonce.dev.todolist.article.presentation.ArticleMapper;
import salonce.dev.todolist.article.presentation.dtos.ArticleSaveRequest;
import salonce.dev.todolist.article.presentation.dtos.ArticleResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final AccountService accountService;
    private final ArticleRepository articleRepository;

    @Transactional
    public List<ArticleResponse> getAllArticles(){
        return articleRepository.findAll().stream().map(ArticleMapper::toArticleResponse).toList();
    }

//    public ArticleResponse getArticle(Long articleId){
//        Article article = articleRepository.findById(articleId).orElseThrow(ArticleNotFound::new);
//        return ArticleMapper.toArticleResponse(article);
//    }

    public ArticleResponse getArticle(String slug){
        Article article = articleRepository.findBySlug(slug).orElseThrow(ArticleNotFound::new);
        return ArticleMapper.toArticleResponse(article);
    }

    @Transactional
    public ArticleResponse saveArticle(AccountPrincipal principal, ArticleSaveRequest articleSaveRequest){
        Account account = accountService.findAccount(principal.id());
        Article article = new Article(articleSaveRequest.title(), generateSlug(articleSaveRequest.title()), articleSaveRequest.content(), account);
        return ArticleMapper.toArticleResponse(articleRepository.save(article));
    }

    private String generateSlug(String title) {
        return title.toLowerCase()
                .trim()
                .replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-");
    }

}
