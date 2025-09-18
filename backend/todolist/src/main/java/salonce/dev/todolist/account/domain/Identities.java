package salonce.dev.todolist.account.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Embeddable
public class Identities {

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<Identity> items = new HashSet<>();

    public Boolean identityExists(String provider, String subject){
        return items.stream().anyMatch(identity -> (identity.getProvider().equals(provider) && identity.getSubject().equals(subject)));
    }

    public void addIdentity(String provider, String subject, Account account){
        Identity identity = new Identity(provider, subject, account);
        items.add(identity);
    }

    public void addIdentityIfAbsent(String provider, String subject, Account account) {
        if (!identityExists(provider, subject)) {
            addIdentity(provider, subject, account);
        }
    }
}
