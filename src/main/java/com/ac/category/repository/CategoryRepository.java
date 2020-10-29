package com.ac.category.repository;

import com.ac.category.entity.CategoryEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, UUID> {

}
