package Estudos.ToDo.Services;

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

    public List<Task> getAll(){
        return taskRepository.findAll();
    }//Metodo para listar todos as entidades

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }//Metodo para criar uma entidade

    public void delete(Long id){
        taskRepository.deleteById(id);
    }//Metodo para deletar uma entidade
}
