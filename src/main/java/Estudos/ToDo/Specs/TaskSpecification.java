package Estudos.ToDo.Specs;

import Estudos.ToDo.Entities.Task;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class TaskSpecification {

    public static Specification<Task> taskNameContains(String taskName) {
        return (root, query, cb) ->
                taskName == null
                    ? null
                    : cb.like(
                            cb.lower(root.get("taskName")),
                            "%" + taskName.toLowerCase() + "%"
                    );
    }

    public static Specification<Task> expirationBefore(LocalDate date) {
        return (root, query, cb) ->
                date == null
                    ? null
                    : cb.lessThanOrEqualTo(root.get("expirationDate"), date);
    }

    public static Specification<Task> hasCategory(Long categoryId) {
        return (root, query, cb) ->
                categoryId == null
                    ? null
                    : cb.equal(root.get("category").get("id"), categoryId);
    }
}
