package Estudos.ToDo.Controllers;

import Estudos.ToDo.Dtos.TaskDTOs.TaskFilterDTO;
import Estudos.ToDo.Dtos.TaskDTOs.TaskRequestDTO;
import Estudos.ToDo.Dtos.TaskDTOs.TaskResponseDTO;
import Estudos.ToDo.Dtos.TaskDTOs.TaskUpdateDTO;
import Estudos.ToDo.Repositories.TaskRepository;
import Estudos.ToDo.Services.TaskService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAll(){
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getById(
            @PathVariable Long id
    ){
      return ResponseEntity.ok(taskService.getById(id));
    };

    @GetMapping("/filter")
    public ResponseEntity<List<TaskResponseDTO>> filterTasks(
            @Valid TaskFilterDTO filter
            ) {
        return ResponseEntity.ok(taskService.filterTasks(filter));
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(
            @Valid @RequestBody TaskRequestDTO dto
            ){
        TaskResponseDTO response = taskService.saveTask(dto);

        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> update(
            @Valid @RequestBody TaskUpdateDTO dto, @PathVariable Long id
    ){
        TaskResponseDTO response = taskService.updatetask(dto, id);

        return ResponseEntity.status(204).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
