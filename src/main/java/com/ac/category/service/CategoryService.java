package com.ac.category.service;

import com.ac.category.dto.CategoryDto;
import com.ac.category.entity.CategoryEntity;
import com.ac.category.repository.CategoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryDto add(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = new CategoryEntity(categoryDto);
        return categoryRepository.save(categoryEntity).toDto();
    }

    public List<CategoryDto> getAll() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
            .map(CategoryDto::new).collect(Collectors.toList());
    }

}
