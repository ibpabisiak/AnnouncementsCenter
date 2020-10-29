package com.ac.category.entity;

import com.ac.category.dto.CategoryDto;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private CategoryEntity categoryEntity;
    private String title;
    private String url;
    private String description;

    public CategoryEntity(CategoryDto categoryDto) {
        fromDto(categoryDto);
    }

    public void fromDto(CategoryDto categoryDto) {
        BeanUtils.copyProperties(categoryDto, this);
    }
}
