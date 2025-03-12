package org.music_track.music_track.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class track {

    @Id
    private int id;

    private String title;
    private String artist;
    private String album;
    private int duration;
    
}
