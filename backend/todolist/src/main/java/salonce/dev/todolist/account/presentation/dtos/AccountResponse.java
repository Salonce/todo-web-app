package salonce.dev.todolist.account.presentation.dtos;

import java.util.Set;

public record AccountResponse(Long id, String email, String name, Set<String> roles) {}
