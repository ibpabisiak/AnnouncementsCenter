package com.ac.category.controller;

import com.ac.announcement.dto.AnnouncementDto;
import com.ac.category.dto.CategoryDto;
import com.ac.category.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Categories Controller")
@RequestMapping("/category")
@AllArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> add(@Valid @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.add(categoryDto));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/tree")
    public ResponseEntity<List<CategoryDto>> getCategoryTree() {
        return ResponseEntity.ok(categoryService.getCategoryTree(null));
    }

    @GetMapping("/tree/{rootId}")
    public ResponseEntity<List<CategoryDto>> getCategoryTree(@PathVariable UUID rootId) {
        return ResponseEntity.ok(categoryService.getCategoryTree(rootId));
    }

    @GetMapping("/**")
    public ResponseEntity<List<AnnouncementDto>> getAllByCategory(HttpServletRequest request) {
        return ResponseEntity.ok(categoryService.getAnnouncementsByCategory(request));
    }

}
