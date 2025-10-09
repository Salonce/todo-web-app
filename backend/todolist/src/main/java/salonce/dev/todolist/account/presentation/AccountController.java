package salonce.dev.todolist.account.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import salonce.dev.todolist.account.application.AccountService;
import salonce.dev.todolist.account.infrastructure.security.AccountPrincipal;
import salonce.dev.todolist.account.presentation.dtos.AccountResponse;
import salonce.dev.todolist.account.presentation.dtos.PatchProfileRequest;

@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/auth")
    public ResponseEntity<AccountPrincipal> getAuth(@AuthenticationPrincipal AccountPrincipal principal){
        return ResponseEntity.ok(principal);
    }

    @GetMapping("/account")
    public ResponseEntity<AccountResponse> getAccount(@AuthenticationPrincipal AccountPrincipal principal){
        return ResponseEntity.ok(AccountMapper.toAccountResponse(accountService.findAccount(principal.id())));
    }

    @PatchMapping("/profile")
    public ResponseEntity<AccountResponse> patchProfile(@AuthenticationPrincipal AccountPrincipal principal, @RequestBody PatchProfileRequest patchProfileRequest){
        return ResponseEntity.ok(AccountMapper.toAccountResponse(accountService.updateProfile(principal.id(), patchProfileRequest)));
    }
}
