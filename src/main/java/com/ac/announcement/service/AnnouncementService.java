package com.ac.announcement.service;

import com.ac.announcement.entity.AnnouncementEntity;
import com.ac.announcement.repository.AnnouncementRepository;
import com.ac.announcement.request.AnnouncementRequest;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public AnnouncementEntity addNewAnnouncement(AnnouncementRequest announcementRequest) {
        //TODO upload pictures
        log.info("Adding a new announcement into database: Title {}, User email: {}, User name: {}",
            announcementRequest.getTitle(), announcementRequest.getEmail(), announcementRequest.getAdvertiserName());
        return announcementRepository.save(new AnnouncementEntity(announcementRequest));
    }

    public Iterable<AnnouncementEntity> getAll() {
        log.info("Loading all announcements from database.");
        return announcementRepository.findAll();
    }

    public AnnouncementEntity update(AnnouncementRequest announcementRequest) {
        log.info("Loading announcement with following id from database: {}", announcementRequest.getUuid());
        Optional<AnnouncementEntity> announcementEntity = announcementRepository
            .findById(announcementRequest.getUuid());

        if (!announcementEntity.isPresent()) {
            //TODO implement error handling
            log.error("Announcement with following id doesn't exist in database: {}", announcementRequest.getUuid());

            //TODO throw exception instead of return null
            return null;
        }

        log.info("Update announcement with following id: {}", announcementRequest.getUuid());
        announcementEntity.get().fromRequest(announcementRequest);
        return announcementRepository.save(announcementEntity.get());
    }

}
