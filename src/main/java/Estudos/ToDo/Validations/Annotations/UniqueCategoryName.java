package Estudos.ToDo.Validations.Annotations;

import Estudos.ToDo.Validations.Validators.UniqueCategoryNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented //Para fins de documentação
@Constraint(validatedBy = UniqueCategoryNameValidator.class) //Diz qual a classe que realmente valida essa notation, no caso é o validator
@Target(ElementType.FIELD) //POde ser utilizada somente em atributos
@Retention(RetentionPolicy.RUNTIME)// É aplicada em runtime
public @interface UniqueCategoryName {

    String message() default "Categoria já existe";

    Class<?>[] groups() default {};// Define qual grupo pode utilizar da nottation, por exemplo
    //Talvez você queira fazer a validação para post, mas não para update, então voce pode definir o group que a
    // nottation pertence

    Class<? extends Payload>[] payload() default {};
    // Definde como voce pode manipular os payloads para fins de log, manipulação de exceptions, entre outros.

    // Ambas as classes comentadas não são obrigatórias

}
