package com.ac.announcement.entity;

import com.ac.announcement.dto.AnnouncementDto;
import com.ac.category.entity.CategoryEntity;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

@Entity
@Data
@NoArgsConstructor
public class AnnouncementEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private CategoryEntity categoryEntity;

    private String title;
    private String urlTitle;
    private String urlPath;
    private String description;
    private String ownerName;
    private String phoneNumber;
    private String email;

    public AnnouncementEntity(AnnouncementDto announcementDto) {
        fromDto(announcementDto);
    }

    public void fromDto(AnnouncementDto announcementDto) {
        if (announcementDto.getCategoryDto() != null) {
            categoryEntity = new CategoryEntity(announcementDto.getCategoryDto());
        }

        BeanUtils.copyProperties(announcementDto, this);
    }

    public AnnouncementDto toDto() {
        return new AnnouncementDto(this);
    }
}
