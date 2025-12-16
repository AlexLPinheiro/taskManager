package Estudos.ToDo.Services;

import Estudos.ToDo.Dtos.CategoryRequestDTO;
import Estudos.ToDo.Dtos.CategoryResponseDTO;
import Estudos.ToDo.Entities.Category;
import Estudos.ToDo.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public CategoryResponseDTO create(CategoryRequestDTO dto){
        Category category = new Category();
        category.setCategoryName(dto.categoryName());

        Category saved = categoryRepository.save(category);

        return new CategoryResponseDTO(
                saved.getId(),
                saved.getCategoryName()
        );
    }

    public Optional<Category> getById(Long Id){
        return categoryRepository.findById(Id);
    }

    public void delete(Long Id){
        categoryRepository.deleteById(Id);
    }
}
