package com.ac.announcement.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddAnnouncementRequest {

    private String title;
    private String description;
    private int price;
    private String phoneNumber;
    private String advertiserName;
}
