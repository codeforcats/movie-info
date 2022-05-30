package com.rjs.movieinfoservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MovieInfoRepo mockMovieInfoRepo;

    @Test
    void MovieInfoFound() throws Exception {

        when(mockMovieInfoRepo.getMovieInfo("Good News"))
                .thenReturn(new MovieInfo("Good News", "A good news story."));

        mockMvc.perform(get("/movies/Good News"))
               .andExpect(status().isOk());
    }

    @Test
    void StatusNotFound() throws Exception {

        when(mockMovieInfoRepo.getMovieInfo("Bad News"))
                .thenThrow(new ReourceNotFoundException());

        mockMvc.perform(get("/movies/Bad News"))
                .andExpect(status().isNotFound());
    }
}