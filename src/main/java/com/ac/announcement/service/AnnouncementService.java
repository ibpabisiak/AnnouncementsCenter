package com.ac.announcement.service;

import com.ac.announcement.entity.AnnouncementEntity;
import com.ac.announcement.repository.AnnouncementRepository;
import com.ac.announcement.request.AddAnnouncementRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public AnnouncementEntity addNewAnnouncement(AddAnnouncementRequest addAnnouncementRequest) {
        AnnouncementEntity announcementEntity = new AnnouncementEntity();
        announcementEntity.setTitle(addAnnouncementRequest.getTitle());
        announcementEntity.setAdvertiserName(addAnnouncementRequest.getAdvertiserName());
        announcementEntity.setDescription(addAnnouncementRequest.getDescription());
        announcementEntity.setEmail(addAnnouncementRequest.getEmail());
        return announcementRepository.save(announcementEntity);
    }

    public Iterable<AnnouncementEntity> getAll() {
        return announcementRepository.findAll();
    }

}
