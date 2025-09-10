package salonce.dev.todolist.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salonce.dev.todolist.application.TaskService;
import salonce.dev.todolist.domain.Task;
import salonce.dev.todolist.presentation.in.PostTaskRequest;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class MainController {

    private final TaskService taskService;

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Long taskId){
        return ResponseEntity.ok(taskService.getTask(taskId));
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> saveTask(@RequestBody PostTaskRequest postTaskRequest){
        Task savedTask = taskService.createTask(postTaskRequest);
        return ResponseEntity
                .created(URI.create("/tasks/" + savedTask.getId()))
                .body(savedTask);
    }

    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
