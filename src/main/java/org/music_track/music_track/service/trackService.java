package org.music_track.music_track.service;

import java.util.HashMap;
import java.util.List;
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

    public ResponseEntity<Object> createTrack(track track1) {
        if(repository.existsByTitle(track1.getTitle())){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Track Already Exists with the Title : "+track1.getTitle());

            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }else{
            repository.save(track1);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Track Created Successfully");
            map.put("Track Details", track1);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> createMultipleTrack(List<track> tracks) {
        for(track track1 : tracks){
            if(repository.existsByTitle(track1.getTitle())){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("error", "Track Already Exists with the Title : "+track1.getTitle());
    
                return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
            }
        }
        repository.saveAll(tracks);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", "Tracks Created Successfully");
        map.put("Tracks Details", tracks);

        return new ResponseEntity<Object>(map, HttpStatus.CREATED);
    }


















    
    public ResponseEntity<Object> getTrack() {
        List<track> tracks = repository.findAll();

        if(tracks.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Tracks Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Tracks Found Successfully");
            map.put("Tracks Details", tracks);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> fetchByArtist(String artist) {
        List<track> tracks = repository.findByArtist(artist);

        if(tracks.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Tracks Found with the Artist : "+artist);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Tracks Found Successfully");
            map.put("Tracks Details", tracks);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }
    
}
