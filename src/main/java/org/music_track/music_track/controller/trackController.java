package org.music_track.music_track.controller;

import org.music_track.music_track.service.trackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class trackController {

    @Autowired
    trackService service;
    
}
