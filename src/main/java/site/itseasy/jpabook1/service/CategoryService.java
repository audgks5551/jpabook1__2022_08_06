package site.itseasy.jpabook1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.itseasy.jpabook1.domain.Category;
import site.itseasy.jpabook1.dto.CategoryDto;
import site.itseasy.jpabook1.repository.CategoryRepository;

import java.util.List;

import static site.itseasy.jpabook1.mapper.CategoryMapper.categoryMapper;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDto findCategory(Long id) {
        Category category = categoryRepository.findOne(id);

        return categoryMapper.toDto(category);
    }

    @Transactional
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toListDto(categories);
    }
}
