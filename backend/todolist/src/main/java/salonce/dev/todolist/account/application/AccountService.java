package salonce.dev.todolist.account.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import salonce.dev.todolist.account.domain.Account;
import salonce.dev.todolist.account.infrastructure.AccountRepository;
import salonce.dev.todolist.task.application.exceptions.AccountNotFound;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public Account saveAccount(AccountDto accountDto){
        Account account = new Account(accountDto.email(), accountDto.subject(), accountDto.provider());
        return accountRepository.save(account);
    }

    public Account loadOrCreateAccount(AccountDto accountDto){
        return accountRepository.findByIdentity(accountDto.subject(), accountDto.provider())
                .orElseGet(() -> accountRepository.save(new Account(accountDto.email(), accountDto.subject(), accountDto.provider())));
    }

    public Account findAccount(Long id){
        return accountRepository.findById(id).orElseThrow(AccountNotFound::new);
    }
}
