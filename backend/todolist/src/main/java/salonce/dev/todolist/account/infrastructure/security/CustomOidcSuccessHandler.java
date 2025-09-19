package salonce.dev.todolist.account.infrastructure.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import salonce.dev.todolist.account.application.AccountService;
import salonce.dev.todolist.account.application.AccountDto;
import salonce.dev.todolist.account.domain.Account;

import java.io.IOException;
import java.util.HashSet;

@RequiredArgsConstructor
@Component
public class CustomOidcSuccessHandler implements AuthenticationSuccessHandler {

    private final AccountService accountService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        OAuth2AuthenticationToken oauth2 = (OAuth2AuthenticationToken) authentication;
        String provider = oauth2.getAuthorizedClientRegistrationId();

        OidcUser oidcUser = (OidcUser) authentication.getPrincipal();

        String subject = oidcUser.getSubject();
        String email = oidcUser.getEmail();
        String name = oidcUser.getName();

        AccountDto accountDto = new AccountDto(email, subject, provider, name);
        Account account = accountService.loadOrCreateAccount(accountDto);
        AccountPrincipal accountPrincipal = new AccountPrincipal(account.getId(), account.getEmail(), new HashSet<>());

        Authentication auth = new UsernamePasswordAuthenticationToken(
                accountPrincipal,
                null,
                authentication.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(auth);
        response.sendRedirect("/home");
    }
}
