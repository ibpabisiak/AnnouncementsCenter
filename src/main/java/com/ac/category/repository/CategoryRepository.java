package com.ac.category.repository;

import com.ac.category.entity.CategoryEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {

    List<CategoryEntity> findAllByParentId(UUID id);

    CategoryEntity findByUrlPath(String urlPath);

}
