package salonce.dev.todolist.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class Task{

    @GeneratedValue
    @Id
    private Long id;

    @Setter
    private String description;

    @Setter
    private Boolean completed;
}
