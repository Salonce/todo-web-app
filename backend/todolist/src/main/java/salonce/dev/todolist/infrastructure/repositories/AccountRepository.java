package salonce.dev.todolist.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salonce.dev.todolist.domain.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findBySubjectAndProvider(String subject, String provider);

}
