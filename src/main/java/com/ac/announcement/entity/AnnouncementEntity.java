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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AnnouncementEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private CategoryEntity category;

    private String title;
    private String description;
    private String advertiserName;
    private String phoneNumber;
    private String email;

    @ManyToOne
    private CategoryEntity categoryEntity;

    public AnnouncementEntity(AnnouncementDto announcementDto) {
        fromDto(announcementDto);
    }

    public void fromDto(AnnouncementDto announcementDto) {
        BeanUtils.copyProperties(announcementDto, this);
    }

    public AnnouncementDto toDto() {
        return new AnnouncementDto(this);
    }
}
