package salonce.dev.todolist.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import salonce.dev.todolist.application.TaskService;
import salonce.dev.todolist.domain.Task;
import salonce.dev.todolist.infrastructure.security.AccountPrincipal;
import salonce.dev.todolist.presentation.in.PostTaskRequest;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<Task> getTask(@AuthenticationPrincipal AccountPrincipal accountPrincipal, @PathVariable Long taskId){

        Long id = accountPrincipal.id();
        String email = accountPrincipal.email();

        return ResponseEntity.ok(taskService.getTask(taskId));
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> saveTask(@AuthenticationPrincipal OAuth2User oAuth2User, @RequestBody PostTaskRequest postTaskRequest){
        Task savedTask = taskService.saveTask(postTaskRequest);
        return ResponseEntity
                .created(URI.create("/tasks/" + savedTask.getId()))
                .body(savedTask);
    }

    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<Void> deleteTask(@AuthenticationPrincipal OAuth2User oAuth2User, @PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
