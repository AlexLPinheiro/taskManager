package Estudos.ToDo.Dtos.TaskDTOs;

import java.time.LocalDate;

public record TaskResponseDTO(
        Long id,
        String taskName,
        LocalDate creationDate,
        LocalDate expirationDate
) {
}
