package org.music_track.music_track.controller;

import java.util.List;

import org.music_track.music_track.dto.track;
import org.music_track.music_track.service.trackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class trackController {

    @Autowired
    trackService service;

    @PostMapping("/tracks")
    public ResponseEntity<Object> createTrack(@RequestBody track track1) {
        return service.createTrack(track1);
    }

    @PostMapping("/tracks/multiple")
    public ResponseEntity<Object> createMultipleTrack(@RequestBody List<track> tracks){
        return service.createMultipleTrack(tracks);
    }
    
}
