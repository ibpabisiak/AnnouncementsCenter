package com.ac.announcement.entity;

import com.ac.announcement.request.AnnouncementRequest;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AnnouncementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    private String advertiserName;
    private String phoneNumber;
    private String email;

    public AnnouncementEntity(AnnouncementRequest announcementRequest) {
        fromRequest(announcementRequest);
    }

    public void fromRequest(AnnouncementRequest announcementRequest) {
        BeanUtils.copyProperties(announcementRequest, this);
    }
}
