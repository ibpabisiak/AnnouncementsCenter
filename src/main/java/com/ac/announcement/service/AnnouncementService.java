package com.ac.announcement.service;

import com.ac.announcement.entity.AnnouncementEntity;
import com.ac.announcement.repository.AnnouncementRepository;
import com.ac.announcement.request.AnnouncementRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public AnnouncementEntity addNewAnnouncement(AnnouncementRequest announcementRequest) {
        return announcementRepository.save(new AnnouncementEntity(announcementRequest));
    }

    public Iterable<AnnouncementEntity> getAll() {
        return announcementRepository.findAll();
    }

}
