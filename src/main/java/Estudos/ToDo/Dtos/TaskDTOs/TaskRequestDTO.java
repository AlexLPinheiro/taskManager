package Estudos.ToDo.Dtos.TaskDTOs;

import java.time.LocalDate;

public record TaskRequestDTO(
        String taskName,
        LocalDate creationDate,
        LocalDate expirationDate

) {
}
