package Estudos.ToDo.Repositories;

import Estudos.ToDo.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface TaskRepository
        extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
}
