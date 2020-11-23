package com.ac.announcement.controller;

import com.ac.announcement.dto.AnnouncementDto;
import com.ac.announcement.service.AnnouncementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Announcements Controller")
@RequestMapping("/announcement")
@AllArgsConstructor
@Slf4j
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @Operation(summary = "Creates a new Announcement")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Created new Announcement",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
        ),
        @ApiResponse(
            responseCode = "409",
            description = "Announcement exist",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Exception.class))
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Unknown error",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
        )
    })
    @PostMapping
    public ResponseEntity<AnnouncementDto> add(@RequestBody AnnouncementDto announcementDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(announcementService.addNewAnnouncement(announcementDto));
    }

    @Operation(summary = "Return all announcements in database")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Return all announcements in database",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Unknown error",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
        )
    })
    @GetMapping
    public ResponseEntity<Iterable<AnnouncementDto>> getAll() {
        return ResponseEntity.ok(announcementService.getAll());
    }

    @Operation(summary = "Return concrete announcement by urlPath")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Return concrete announcement by urlPath",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Announcement not found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Unknown error",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
        )
    })
    @GetMapping("/{urlPath}")
    public ResponseEntity<AnnouncementDto> getAnnouncement(@PathVariable String urlPath) {
        return ResponseEntity.ok(announcementService.getAnnouncement(urlPath));
    }

    @PutMapping
    public ResponseEntity<AnnouncementDto> update(@RequestBody AnnouncementDto announcementDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(announcementService.update(announcementDto));
    }

}
