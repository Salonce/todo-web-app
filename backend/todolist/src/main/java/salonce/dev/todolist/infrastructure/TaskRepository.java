package salonce.dev.todolist.infrastructure;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salonce.dev.todolist.domain.Task;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {}
