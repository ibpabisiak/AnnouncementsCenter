package com.ac.announcement.service;

import com.ac.announcement.request.AddAnnouncementRequest;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementService {

    public void addNewAnnouncement(AddAnnouncementRequest addAnnouncementRequest) {
        //TODO
        System.err.println("lombok test: " + addAnnouncementRequest.getTitle());
        System.err.println("lombok test: " + addAnnouncementRequest.getDescription());
        System.err.println("lombok test: " + addAnnouncementRequest.getPhoneNumber());
        System.err.println("lombok test: " + addAnnouncementRequest.getTitle());
    }

}
