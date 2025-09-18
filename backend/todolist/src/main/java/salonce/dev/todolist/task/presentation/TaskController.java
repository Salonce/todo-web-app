package salonce.dev.todolist.task.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import salonce.dev.todolist.task.application.TaskService;
import salonce.dev.todolist.task.domain.Task;
import salonce.dev.todolist.account.infrastructure.security.AccountPrincipal;
import salonce.dev.todolist.task.presentation.in.PostTaskRequest;

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
    public ResponseEntity<Task> saveTask(@AuthenticationPrincipal AccountPrincipal accountPrincipal, @RequestBody PostTaskRequest postTaskRequest){
        Task savedTask = taskService.saveTask(postTaskRequest);
        return ResponseEntity
                .created(URI.create("/tasks/" + savedTask.getId()))
                .body(savedTask);
    }

    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<Void> deleteTask(@AuthenticationPrincipal AccountPrincipal accountPrincipal, @PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
