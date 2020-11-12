package com.ac.announcement.service;

import com.ac.announcement.dto.AnnouncementDto;
import com.ac.announcement.entity.AnnouncementEntity;
import com.ac.announcement.repository.AnnouncementRepository;
import com.ac.exception.ResourceNotFoundException;
import com.ac.exception.message.ExceptionMessage;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    public AnnouncementDto addNewAnnouncement(AnnouncementDto announcementDto) {
        //TODO upload pictures
        log.info("Adding a new announcement into database: Title {}, User email: {}, User name: {}",
            announcementDto.getTitle(), announcementDto.getEmail(), announcementDto.getAdvertiserName());
        return announcementRepository.save(new AnnouncementEntity(announcementDto)).toDto();
    }

    public List<AnnouncementDto> getAll() {
        log.info("Loading all announcements from database.");

        return StreamSupport.stream(announcementRepository.findAll().spliterator(), false)
            .map(AnnouncementDto::new)
            .collect(Collectors.toList());
    }

    public AnnouncementDto update(AnnouncementDto announcementDto) {
        log.info("Loading announcement with following id from database: {}", announcementDto.getId());
        Optional<AnnouncementEntity> announcementEntity = announcementRepository.findById(announcementDto.getId());

        if (!announcementEntity.isPresent()) {
            throw new ResourceNotFoundException(
                ExceptionMessage.RESOURCE_NOT_FOUND.formatWithId(announcementDto.getId()));
        }

        log.info("Update announcement with following id: {}", announcementDto.getId());
        announcementEntity.get().fromDto(announcementDto);
        return announcementRepository.save(announcementEntity.get()).toDto();
    }

}
