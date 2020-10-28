package com.ac.announcement.repository;

import com.ac.announcement.entity.AnnouncementEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface AnnouncementRepository extends CrudRepository<AnnouncementEntity, UUID> {

}
