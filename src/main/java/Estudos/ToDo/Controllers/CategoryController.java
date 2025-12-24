package Estudos.ToDo.Controllers;
import Estudos.ToDo.Dtos.CategoryDTOs.CategoryRequestDTO;
import Estudos.ToDo.Dtos.CategoryDTOs.CategoryResponseDTO;
import Estudos.ToDo.Services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> create(
            @Valid @RequestBody CategoryRequestDTO dto
            ){
        CategoryResponseDTO response = categoryService.create(dto);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAll(){
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getById(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(categoryService.getById(id));
    }
}
