package org.music_track.music_track.controller;

import java.util.List;

import org.music_track.music_track.dto.track;
import org.music_track.music_track.service.trackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class trackController {

    @Autowired
    trackService service;


    //To Add Music Track Records
    @PostMapping("/tracks")
    public ResponseEntity<Object> createTrack(@RequestBody track track1) {
        return service.createTrack(track1);
    }

    @PostMapping("/tracks/multiple")
    public ResponseEntity<Object> createMultipleTrack(@RequestBody List<track> tracks){
        return service.createMultipleTrack(tracks);
    }






    //To Fetch the Track Details From the Database
    @GetMapping("/tracks")
    public ResponseEntity<Object> getTrack(){
        return service.getTrack();
    }

    @GetMapping("/tracks/{artist}")
    public ResponseEntity<Object> fetchByArtist(@PathVariable String artist){
        return service.fetchByArtist(artist);
    }
    
    @GetMapping("/tracks/album/{album}")
    public ResponseEntity<Object> fetchByAlbum(@PathVariable String album){
        return service.fetchByAlbum(album);
    }
    



    //To Delete the Track Detail From the Database
    @DeleteMapping("/tracks/{id}")
    public ResponseEntity<Object> deleteTrack(@PathVariable int id){
        return service.deleteTrack(id);
    }



    //To Update a record using Patch Mapping
    @PatchMapping("/tracks/{id}")
    public ResponseEntity<Object> updateTrack(@PathVariable int id, @RequestBody track track2){
        return service.updateTrack(id, track2);
    }

}
