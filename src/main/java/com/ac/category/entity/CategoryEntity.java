package com.ac.category.entity;

import com.ac.category.dto.CategoryDto;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private CategoryEntity parent;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String urlName;

    @Column(length = 50, nullable = false, unique = true)
    private String urlPath;

    private String description;

    public CategoryEntity(CategoryDto categoryDto) {
        fromDto(categoryDto);
    }

    public void fromDto(CategoryDto categoryDto) {
        if (categoryDto.getParentDto() != null) {
            parent = categoryDto.getParentDto().toEntity();
        }
        BeanUtils.copyProperties(categoryDto, this);
    }

    public CategoryDto toDto() {
        return new CategoryDto(this);
    }

}
