package salonce.dev.todolist.task.presentation.in;

public record PutTaskRequest(Long id, String description, Boolean completed){};
