package salonce.dev.todolist.task.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import salonce.dev.todolist.task.application.exceptions.TaskNotFound;
import salonce.dev.todolist.task.domain.Task;
import salonce.dev.todolist.task.infrastructure.TaskRepository;
import salonce.dev.todolist.task.presentation.in.PostTaskRequest;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public Task saveTask(PostTaskRequest postTaskRequest){
        Task task = new Task();
        task.setDescription(postTaskRequest.description());
        task.setCompleted(postTaskRequest.completed());
        return taskRepository.save(task);
    }

    @Transactional
    public Task getTask(Long id){
        return taskRepository.findById(id).orElseThrow(TaskNotFound::new);
    }

    @Transactional
    public void deleteTask(Long id){
        if (taskRepository.existsById(id))
            taskRepository.deleteById(id);
        else
            throw new TaskNotFound();
    }
}
