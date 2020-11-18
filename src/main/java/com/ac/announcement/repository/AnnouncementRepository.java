package com.ac.announcement.repository;

import com.ac.announcement.entity.AnnouncementEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, UUID> {

    List<AnnouncementEntity> findByCategoryId(UUID categoryId);
}
