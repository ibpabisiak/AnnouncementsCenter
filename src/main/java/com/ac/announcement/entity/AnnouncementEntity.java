package com.ac.announcement.entity;

import com.ac.announcement.dto.AnnouncementDto;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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


    private String title;
    private String description;
    private String advertiserName;
    private String phoneNumber;
    private String email;

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
