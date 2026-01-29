package Estudos.ToDo.Dtos.TaskDTOs;

import java.time.LocalDate;

public record TaskUpdateDTO(
        String taskName,
        LocalDate expirationDate
) {
}
