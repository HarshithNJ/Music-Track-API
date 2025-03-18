package org.music_track.music_track.controller;

import java.util.List;

import org.music_track.music_track.dto.track;
import org.music_track.music_track.service.trackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class trackController {

    @Autowired
    trackService service;


    //To Add Music Track Records
    @Operation(summary = "Add Music Track Record", description = "Add a Music Track Record")
    @ApiResponse(responseCode = "201", description = "Track Created Successfully")
    @ApiResponse(responseCode = "400", description = "Track Already Exists with the Title")
    @PostMapping("/tracks")
    public ResponseEntity<Object> createTrack(@RequestBody track track1) {
        return service.createTrack(track1);
    }

    @Operation(summary = "Add Multiple Music Track Records", description = "Add Multiple Music Track Records")
    @ApiResponse(responseCode = "201", description = "Tracks Created Successfully")
    @ApiResponse(responseCode = "400", description = "Track Already Exists with the Title")
    @PostMapping("/tracks/multiple")
    public ResponseEntity<Object> createMultipleTrack(@RequestBody List<track> tracks){
        return service.createMultipleTrack(tracks);
    }






    //To Fetch the Track Details From the Database
    @Operation(summary = "Get All Music Track Records", description = "Get All Music Track Records")
    @ApiResponse(responseCode = "302", description = "Tracks Found Successfully")
    @ApiResponse(responseCode = "404", description = "No Tracks Found")
    @GetMapping("/tracks")
    public ResponseEntity<Object> getTrack(){
        return service.getTrack();
    }

    @Operation(summary = "Get Music Track Records by Artist", description = "Get Music Track Records by Artist")
    @ApiResponse(responseCode = "302", description = "Tracks Found Successfully")
    @ApiResponse(responseCode = "404", description = "No Tracks Found")
    @GetMapping("/tracks/{artist}")
    public ResponseEntity<Object> fetchByArtist(@PathVariable String artist){
        return service.fetchByArtist(artist);
    }
    
    @Operation(summary = "Get Music Track Records by Album", description = "Get Music Track Records by Album")
    @ApiResponse(responseCode = "302", description = "Tracks Found Successfully")
    @ApiResponse(responseCode = "404", description = "No Tracks Found")
    @GetMapping("/tracks/album/{album}")
    public ResponseEntity<Object> fetchByAlbum(@PathVariable String album){
        return service.fetchByAlbum(album);
    }
    



    //To Delete the Track Detail From the Database
    @Operation(summary = "Delete a Music Track Record", description = "Delete a Music Track Record")
    @ApiResponse(responseCode = "200", description = "Track Deleted Successfully")
    @ApiResponse(responseCode = "404", description = "No Track Found with the ID")
    @DeleteMapping("/tracks/{id}")
    public ResponseEntity<Object> deleteTrack(@PathVariable int id){
        return service.deleteTrack(id);
    }



    //To Update a record using Patch Mapping
    @Operation(summary = "Update a Music Track Record", description = "Update a Music Track Record")
    @ApiResponse(responseCode = "200", description = "Track Updated Successfully")
    @ApiResponse(responseCode = "404", description = "No Track Found with the ID")
    @PatchMapping("/tracks/{id}")
    public ResponseEntity<Object> updateTrack(@PathVariable int id, @RequestBody track track2){
        return service.updateTrack(id, track2);
    }

}
