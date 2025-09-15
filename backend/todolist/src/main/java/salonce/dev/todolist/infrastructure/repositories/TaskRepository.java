package salonce.dev.todolist.infrastructure.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salonce.dev.todolist.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {}
