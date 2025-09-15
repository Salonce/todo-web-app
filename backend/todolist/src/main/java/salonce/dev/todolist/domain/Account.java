package salonce.dev.todolist.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class Account {

    @GeneratedValue
    @Id
    private Long id;

    @Setter
    private String email;

    @Setter
    private String subject;

    @Setter
    private String provider;


    public Account (String email, String subject, String provider){
        this.email = email;
        this.subject = subject;
        this.provider = provider;
    }
}
