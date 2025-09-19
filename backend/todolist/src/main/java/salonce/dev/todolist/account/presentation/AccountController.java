package salonce.dev.todolist.account.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import salonce.dev.todolist.account.application.AccountService;
import salonce.dev.todolist.account.infrastructure.security.AccountPrincipal;
import salonce.dev.todolist.account.presentation.out.AccountResponse;

@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/account")
    public ResponseEntity<AccountResponse> getAccount(@AuthenticationPrincipal AccountPrincipal principal){
        return ResponseEntity.ok(AccountMapper.toAccountResponse(accountService.findAccount(principal.id())));
    }

    @PutMapping("/account")
    public ResponseEntity<AccountResponse> updateAccount(@AuthenticationPrincipal AccountPrincipal principal){

    }
}
