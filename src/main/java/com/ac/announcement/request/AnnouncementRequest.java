package com.ac.announcement.request;

import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnnouncementRequest {

    private UUID id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private String advertiserName;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String email;
}
