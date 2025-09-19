package salonce.dev.todolist.account.domain;

import jakarta.persistence.Embedded;
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

    public Account (String email, String subject, String provider){
        this.email = email;
        identities.addIdentity(provider, subject, this);
    }

    @GeneratedValue
    @Id
    private Long id;

    @Setter
    private String email;

    @Setter
    @Embedded
    private Identities identities = new Identities();

    public Boolean identityExists(String provider, String subject){
        return identities.identityExists(provider, subject);
    }
}
