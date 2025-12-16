package Estudos.ToDo.Repositories;

import Estudos.ToDo.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
}
