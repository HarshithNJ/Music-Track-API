package org.music_track.music_track;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(info = @Info(title = "Music Track API", version = "1.0", description = "Music Track API", 
					contact = @Contact(name = "HarshithN J", email = "Harshith.dev2024@outlook,com")))
@SpringBootApplication
public class MusicTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicTrackApplication.class, args);
	}

}
