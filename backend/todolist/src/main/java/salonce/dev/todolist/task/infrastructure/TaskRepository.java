package salonce.dev.todolist.task.infrastructure;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salonce.dev.todolist.task.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {}
