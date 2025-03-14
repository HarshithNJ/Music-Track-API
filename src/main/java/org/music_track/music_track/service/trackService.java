package org.music_track.music_track.service;

import java.util.HashMap;
import java.util.Map;

import org.music_track.music_track.dto.track;
import org.music_track.music_track.repository.trackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class trackService {
    
    @Autowired
    trackRepository repository;

    public ResponseEntity<Object> createTrack(track track) {
        if(repository.existsByTitle(track.getTitle())){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Track Already Exists with the Title" + track.getTitle());

            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }else{
            repository.save(track);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Track Created Successfully");
            map.put("Track Details", track);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }
    
}
