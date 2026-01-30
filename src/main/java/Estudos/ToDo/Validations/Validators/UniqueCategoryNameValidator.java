package Estudos.ToDo.Validations.Validators;

import Estudos.ToDo.Repositories.CategoryRepository;
import Estudos.ToDo.Validations.Annotations.UniqueCategoryName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueCategoryNameValidator
        implements ConstraintValidator<UniqueCategoryName, String> {

    @Autowired
    private CategoryRepository repository;

    public UniqueCategoryNameValidator() {

    }

    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext context) {
        if (value == null || value.isBlank()){
            return true;
        }

        return !repository.existsByCategoryName(value);
    }
}

