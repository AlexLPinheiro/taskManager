package Estudos.ToDo.Validations.Validators;

import Estudos.ToDo.Repositories.CategoryRepository;
import Estudos.ToDo.Validations.Annotations.UniqueCategoryName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class UniqueCategoryNameValidator
        implements ConstraintValidator<UniqueCategoryName, String> {

    private final CategoryRepository categoryRepository;

    public UniqueCategoryNameValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext context) {
        if (value == null || value.isBlank()){
            return true;
        }

        return !categoryRepository.existsByCategoryName(value);
    }
}

