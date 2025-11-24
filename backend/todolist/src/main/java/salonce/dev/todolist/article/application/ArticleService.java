package salonce.dev.todolist.article.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import salonce.dev.todolist.account.application.AccountService;
import salonce.dev.todolist.account.domain.Account;
import salonce.dev.todolist.account.infrastructure.security.AccountPrincipal;
import salonce.dev.todolist.article.application.exceptions.ArticleNotFound;
import salonce.dev.todolist.article.domain.Article;
import salonce.dev.todolist.article.infrastructure.ArticleRepository;
import salonce.dev.todolist.article.presentation.ArticleMapper;
import salonce.dev.todolist.article.presentation.dtos.ArticleCreateRequest;
import salonce.dev.todolist.article.presentation.dtos.ArticleResponse;


@Service
@RequiredArgsConstructor
public class ArticleService {

    private final AccountService accountService;
    private final ArticleRepository articleRepository;

    @Transactional
    public Page<ArticleResponse> getAllArticles(Pageable pageable){
        return articleRepository.findAll(pageable).map(ArticleMapper::toArticleResponse);
    }

    public ArticleResponse getArticle(String slug){
        Article article = articleRepository.findBySlug(slug).orElseThrow(ArticleNotFound::new);
        return ArticleMapper.toArticleResponse(article);
    }

    @Transactional
    public ArticleResponse saveArticle(AccountPrincipal principal, ArticleCreateRequest articleCreateRequest){
        Account account = accountService.findAccount(principal.id());
        Article article = new Article(articleCreateRequest.title(), generateSlug(articleCreateRequest.title()), articleCreateRequest.content(), account);
        return ArticleMapper.toArticleResponse(articleRepository.save(article));
    }

    private String generateSlug(String title) {
        return title.toLowerCase()
                .trim()
                .replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-");
    }

}
