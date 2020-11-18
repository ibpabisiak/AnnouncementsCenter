package com.ac.category.dto;

import com.ac.category.entity.CategoryEntity;
import java.util.List;
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
    private UUID parentId;
    private CategoryDto parentDto;
    private List<CategoryDto> categoryDtos;
    @NotEmpty
    private String title;
    @NotEmpty
    private String url;
    private String description;

    public CategoryDto(CategoryEntity categoryEntity) {
        fromDto(categoryEntity);
    }

    public void fromDto(CategoryEntity categoryEntity) {
        if (categoryEntity.getParent() != null) {
            parentDto = new CategoryDto(categoryEntity.getParent());
            parentId = parentDto.getId();
        }

        BeanUtils.copyProperties(categoryEntity, this);
    }

    public CategoryEntity toEntity() {
        return new CategoryEntity(this);
    }
}
