package org.music_track.music_track.service;

import org.music_track.music_track.repository.trackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class trackService {
    
    @Autowired
    trackRepository repository;
    
}
