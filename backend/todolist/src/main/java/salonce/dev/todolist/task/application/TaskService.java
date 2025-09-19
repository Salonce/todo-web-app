package salonce.dev.todolist.task.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import salonce.dev.todolist.task.application.exceptions.TaskNotFound;
import salonce.dev.todolist.task.domain.Task;
import salonce.dev.todolist.task.infrastructure.TaskRepository;
import salonce.dev.todolist.task.presentation.in.PostTaskRequest;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public Task saveTask(PostTaskRequest postTaskRequest, Long accountId){
        Task task = new Task();
        task.setDescription(postTaskRequest.description());
        task.setCompleted(postTaskRequest.completed());
        task.setAccountId(accountId);
        return taskRepository.save(task);
    }

    @Transactional
    public List<Task> getTasks(Long accountId){
        return taskRepository.findByAccountId(accountId);
    }

    @Transactional
    public Task getTask(Long id, Long accountId){
        return taskRepository.findByIdAndAccountId(id, accountId).orElseThrow(TaskNotFound::new);
    }

    @Transactional
    public void deleteTask(Long id, Long accountId){
        if (taskRepository.existsByIdAndAccountId(id, accountId))
            taskRepository.deleteByIdAndAccountId(id, accountId);
        else
            throw new TaskNotFound();
    }
}
