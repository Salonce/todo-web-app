package salonce.dev.todolist.article.domain;

import jakarta.persistence.*;
import lombok.Getter;
import salonce.dev.todolist.account.domain.Account;


@Entity
@Getter
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(nullable = false, unique = true)
    private String slug;

    private String content;

    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private Account author;

    protected Article(){}

    public Article(String title, String slug, String content, Account author) {
        this.title = title;
        this.content = content;
        this.slug = slug;
        this.author = author;
    }
}
