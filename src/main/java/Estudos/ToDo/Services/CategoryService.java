package Estudos.ToDo.Services;

import Estudos.ToDo.Dtos.CategoryDTOs.CategoryRequestDTO;
import Estudos.ToDo.Dtos.CategoryDTOs.CategoryResponseDTO;
import Estudos.ToDo.Entities.Category;
import Estudos.ToDo.Repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryResponseDTO> getAll(){

        return categoryRepository.findAll()
                .stream()
                .map(category -> new CategoryResponseDTO(
                        category.getId(),
                        category.getCategoryName()
                ))
                .toList();

        //pode ser feito desta forma tbm (mais manual):

        //List<Category> categories = categoryRepository.findAll();
        //List<CategoryResponseDTO> dtos = new ArrayList<>();
        //for (Category category : categories) {
        //  dtos.add(new CategoryResponseDTO){
        //      category.getId(),
        //      category.getCategoryName()
        //  ));
        //}

        //return dtos
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

    public CategoryResponseDTO getById(Long Id){
        Category category = categoryRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));

        return new CategoryResponseDTO(
                category.getId(),
                category.getCategoryName()
        );
    }

    public void delete(Long Id){
        categoryRepository.deleteById(Id);
    }
}
