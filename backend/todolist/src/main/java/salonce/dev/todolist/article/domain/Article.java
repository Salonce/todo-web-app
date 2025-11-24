package salonce.dev.todolist.article.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import salonce.dev.todolist.account.domain.Account;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(nullable = false, unique = true)
    private String slug;

    @Lob
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
