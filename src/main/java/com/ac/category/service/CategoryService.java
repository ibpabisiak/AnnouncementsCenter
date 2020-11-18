package com.ac.category.service;

import com.ac.announcement.dto.AnnouncementDto;
import com.ac.announcement.service.AnnouncementService;
import com.ac.category.dto.CategoryDto;
import com.ac.category.entity.CategoryEntity;
import com.ac.category.repository.CategoryRepository;
import com.ac.exception.ResourceNotFoundException;
import com.ac.exception.message.ExceptionMessage;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final AnnouncementService announcementService;

    public CategoryDto add(CategoryDto categoryDto) {
        if (categoryDto.getParentId() != null) {
            CategoryEntity parentEntity = categoryRepository.findById(categoryDto.getParentId())
                .orElseThrow(() -> new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage()));
            categoryDto.setParentDto(parentEntity.toDto());
        }

        return categoryRepository.save(new CategoryEntity(categoryDto)).toDto();
    }

    public List<CategoryDto> getAll() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
            .map(CategoryDto::new).collect(Collectors.toList());
    }

    public List<CategoryDto> getCategoryTree(UUID rootId) {
        List<CategoryDto> result = categoryRepository.findAllByParentId(rootId).stream().map(CategoryDto::new).collect(
            Collectors.toList());

        for (CategoryDto categoryDto : result) {
            List<CategoryDto> childrenDtos = categoryRepository.findAllByParentId(categoryDto.getId()).stream()
                .map(CategoryDto::new).collect(Collectors.toList());
            categoryDto.setChildrenDtos(childrenDtos);
        }

        return result;
    }

    public List<AnnouncementDto> getAnnouncementsByCategory(HttpServletRequest request) {
        String urlPath = extractCategoryUrlPath(request);
        CategoryEntity categoryEntity = Optional.ofNullable(categoryRepository.findByUrlPath(urlPath)).orElseThrow(
            () -> new ResourceNotFoundException(
                ExceptionMessage.BAD_CATEGORY_URL.formatWithId(request.getRequestURI())));
        return announcementService.getAnnouncementsByCategory(categoryEntity.getId());
    }

    private String extractCategoryUrlPath(HttpServletRequest request) {
        String categoryRestMapping = "/category/";
        return request.getRequestURI().split(request.getContextPath() + categoryRestMapping)[1];
    }
}
