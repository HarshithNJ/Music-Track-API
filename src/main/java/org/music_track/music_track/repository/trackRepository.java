package org.music_track.music_track.repository;

import java.util.List;

import org.music_track.music_track.dto.track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface trackRepository extends JpaRepository<track, Integer>{

    boolean existsByTitle(String title);

    List<track> findByArtist(String artist);

    List<track> findByAlbum(String album);

}
