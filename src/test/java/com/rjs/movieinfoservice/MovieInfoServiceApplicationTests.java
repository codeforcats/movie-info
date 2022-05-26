package com.rjs.movieinfoservice;

import com.rjs.movieinfoservice.model.MovieInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieInfoServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldReturnHardCodedMovieInfo(){
		MovieInfo movieInfo = restTemplate.getForObject("http://localhost:" + port + "/movies/1",
				MovieInfo.class);

		MovieInfo expectedMovieInfo = new MovieInfo(
				"Jaws",
				"A man eating shark terrorises seaside resort.");

		assertThat(movieInfo).isEqualTo(expectedMovieInfo);
	}
}
