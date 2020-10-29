package com.ac.category.dto;

import com.ac.category.entity.CategoryEntity;
import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

    private UUID id;
    private CategoryEntity categoryEntity;
    @NotEmpty
    private String title;
    @NotEmpty
    private String url;
    private String description;

    public CategoryDto(CategoryEntity categoryEntity) {
        fromDto(categoryEntity);
    }

    public void fromDto(CategoryEntity categoryEntity) {
        BeanUtils.copyProperties(categoryEntity, this);
    }
}
