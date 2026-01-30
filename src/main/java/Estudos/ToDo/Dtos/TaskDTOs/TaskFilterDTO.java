package Estudos.ToDo.Dtos.TaskDTOs;

import java.time.LocalDate;

public record TaskFilterDTO (
        String taskName,
        LocalDate expirationDate,
        Long categoryId
)
{}
