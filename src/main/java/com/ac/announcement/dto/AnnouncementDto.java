package com.ac.announcement.dto;

import com.ac.announcement.entity.AnnouncementEntity;
import com.ac.category.dto.CategoryDto;
import java.util.UUID;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class AnnouncementDto {

    @Id
    private UUID id;
    @NotEmpty
    private UUID categoryId;

    private CategoryDto categoryDto;
    private String title;
    private String urlTitle;
    private String urlPath;
    private String description;
    private String ownerName;
    private String phoneNumber;
    private String email;

    public AnnouncementDto(AnnouncementEntity announcementEntity) {
        fromEntity(announcementEntity);
    }

    public void fromEntity(AnnouncementEntity announcementEntity) {
        BeanUtils.copyProperties(announcementEntity, this);
    }

    public AnnouncementEntity toEntity() {
        return new AnnouncementEntity(this);
    }
}
