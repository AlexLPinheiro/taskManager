package Estudos.ToDo.Services;

import Estudos.ToDo.Dtos.TaskDTOs.TaskRequestDTO;
import Estudos.ToDo.Dtos.TaskDTOs.TaskResponseDTO;
import Estudos.ToDo.Dtos.TaskDTOs.TaskUpdateDTO;
import Estudos.ToDo.Entities.Task;
import Estudos.ToDo.Repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;// Crio uma instância do repository

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }//Crio um construtor para o servico, injetando o repositorio

    public List<TaskResponseDTO> getAll(){


        return taskRepository.findAll()
                .stream()
                .map(task -> new TaskResponseDTO(
                        task.getId(),
                        task.getTaskName(),
                        task.getCreationDate(),
                        task.getExpirationDate()
                ))
                .toList()
                ;

    }//Metodo para listar todos as entidades

    public TaskResponseDTO saveTask(TaskRequestDTO dto){
        Task task = new Task();

        task.setTaskName(dto.taskName());
        task.setCreationDate(dto.creationDate());
        task.setExpirationDate(dto.expirationDate());

        Task saved = taskRepository.save(task);

        return new TaskResponseDTO(
                saved.getId(),
                saved.getTaskName(),
                saved.getCreationDate(),
                saved.getExpirationDate()
        );
    }//Metodo para criar uma entidade

    public TaskResponseDTO updatetask(TaskUpdateDTO dto, Long id){

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        task.setTaskName(dto.taskName());
        task.setExpirationDate(dto.expirationDate());

        return new TaskResponseDTO(
                task.getId(),
                task.getTaskName(),
                task.getCreationDate(),
                task.getExpirationDate()
        );
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }//Metodo para deletar uma entidade
}
