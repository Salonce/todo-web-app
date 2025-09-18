package salonce.dev.todolist.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
public class Identity {

    protected Identity() {}
    public Identity(String provider, String subject, Account account) {
        this.provider = provider;
        this.subject = subject;
        this.account = account;
    }

    @GeneratedValue
    @Id
    private Long id;

    private String provider;
    private String subject;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;
}
