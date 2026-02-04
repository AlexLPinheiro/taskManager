package Estudos.ToDo.Dtos.TaskDTOs;

import Estudos.ToDo.Entities.Task;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskResponseDTO toResponse(Task task);

    List<TaskResponseDTO> toResponseList(List<Task> tasks);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    Task toEntity(TaskRequestDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateEntityFromDto(TaskUpdateDTO dto , @MappingTarget Task task);

}
