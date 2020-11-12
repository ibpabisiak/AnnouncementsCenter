package com.ac.announcement.repository;

import com.ac.announcement.entity.AnnouncementEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, UUID> {

}
