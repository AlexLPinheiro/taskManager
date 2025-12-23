package Estudos.ToDo.Dtos.CategoryDTOs;

import Estudos.ToDo.Validations.Annotations.UniqueCategoryName;
import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDTO (
    @NotBlank
    @UniqueCategoryName
    String categoryName
){}
