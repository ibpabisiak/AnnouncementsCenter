package com.ac.category.entity;

import com.ac.category.dto.CategoryDto;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
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

    public CategoryDto toDto() {
        return new CategoryDto(this);
    }

}
