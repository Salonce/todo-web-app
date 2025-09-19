package salonce.dev.todolist.account.presentation;

import salonce.dev.todolist.account.domain.Account;
import salonce.dev.todolist.account.presentation.dtos.AccountResponse;

public class AccountMapper {
    public static AccountResponse toAccountResponse(Account account){
        return new AccountResponse(account.getId(), account.getEmail());
    }
}
