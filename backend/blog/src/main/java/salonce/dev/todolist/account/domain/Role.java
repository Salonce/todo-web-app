package salonce.dev.todolist.account.domain;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Role {

    private String name;

    protected Role() {}

    private Role(String name) {
        this.name = name;
    }

    public static final Role ADMIN = new Role("ADMIN");
    public static final Role USER = new Role("USER");
    public static final Role MODERATOR = new Role("MODERATOR");

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
