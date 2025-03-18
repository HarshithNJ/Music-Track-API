package org.music_track.music_track.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public ResponseEntity<Object> fetchByAlbum(String album) {
        List<track> tracks = repository.findByAlbum(album);

        if(tracks.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "The Album named " +album+" does not exist");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Tracks Found Successfully");
            map.put("Track Details", tracks);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }










    public ResponseEntity<Object> deleteTrack(int id) {
        Optional<track> track = repository.findById(id);

        if(track.isPresent()){
            repository.deleteById(id);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Track Deleted Successfully");
            map.put("Track Details", track.get());

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Track Found with the ID : "+id);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }













    

    public ResponseEntity<Object> updateTrack(int id, track track2) {
        Optional<track> track = repository.findById(id);

        if(track.isPresent()){
            track t = track.get();

            if(track2.getTitle() != null)
                t.setTitle(track2.getTitle());
            if(track2.getArtist() != null)
                t.setArtist(track2.getArtist());
            if(track2.getAlbum() != null)
                t.setAlbum(track2.getAlbum());
            if(track2.getDuration() != 0)
                t.setDuration(track2.getDuration());

            repository.save(t);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Track Updated successfully");
            map.put("track Details", t);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Track Details Not Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }
    
}
