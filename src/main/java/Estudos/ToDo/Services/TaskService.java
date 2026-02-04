package Estudos.ToDo.Services;

import Estudos.ToDo.Dtos.TaskDTOs.*;
import Estudos.ToDo.Entities.Category;
import Estudos.ToDo.Entities.Task;
import Estudos.ToDo.Repositories.CategoryRepository;
import Estudos.ToDo.Repositories.TaskRepository;
import Estudos.ToDo.Specs.TaskSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;// Crio uma instância do repository
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, CategoryRepository categoryRepository, TaskMapper taskMapper){
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
        this.taskMapper = taskMapper;
    }//Crio um construtor para o servico, injetando as depêndencias

    public List<TaskResponseDTO> getAll(){
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.toResponseList(tasks);

//        return taskRepository.findAll()
//                .stream()
//                .map(task -> new TaskResponseDTO(
//                        task.getId(),
//                        task.getTaskName(),
//                        task.getCreationDate(),
//                        task.getExpirationDate()
//                ))
//                .toList()
//                ;

    }//Metodo para listar todos as entidades

    public TaskResponseDTO getById(Long id){

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("task não encontrada"));

         return taskMapper.toResponse(task);

    }

    public List<TaskResponseDTO> filterTasks(TaskFilterDTO filter) {

        Specification<Task> spec = Specification
                .where(TaskSpecification.taskNameContains((filter.taskName())))
                .and(TaskSpecification.expirationBefore(filter.expirationDate()))
                .and(TaskSpecification.hasCategory(filter.categoryId()));

        List<Task> tasks = taskRepository.findAll(spec);

        return taskMapper.toResponseList(tasks);


//        return taskRepository.findAll(spec)
//                .stream()
//                .map(task -> new TaskResponseDTO(
//                        task.getId(),
//                        task.getTaskName(),
//                        task.getCreationDate(),
//                        task.getExpirationDate()
//                ))
//                .toList();

    }

    public TaskResponseDTO saveTask(TaskRequestDTO dto){

        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Task task = taskMapper.toEntity(dto);
        task.setCategory(category);

        Task saved = taskRepository.save(task);

//        task.setTaskName(dto.taskName());
//        task.setCreationDate(dto.creationDate());
//        task.setExpirationDate(dto.expirationDate());
//        task.setCategory(category);
//
//        Task saved = taskRepository.save(task);
//
//        return new TaskResponseDTO(
//                saved.getId(),
//                saved.getTaskName(),
//                saved.getCreationDate(),
//                saved.getExpirationDate()
//        );

        return taskMapper.toResponse(saved);
    }//Metodo para criar uma entidade

    public TaskResponseDTO updatetask(TaskUpdateDTO dto, Long id){

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        taskMapper.updateEntityFromDto(dto, task);

        Task updated = taskRepository.save(task);

        return taskMapper.toResponse(updated);


//        task.setTaskName(dto.taskName());
//        task.setExpirationDate(dto.expirationDate());
//
//        return new TaskResponseDTO(
//                task.getId(),
//                task.getTaskName(),
//                task.getCreationDate(),
//                task.getExpirationDate()
//        );
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }//Metodo para deletar uma entidade
}
