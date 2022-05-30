package com.rjs.movieinfoservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
    void movieFound() throws Exception {

        when(mockMovieInfoRepo.getMovieInfo("Good News"))
                .thenReturn(new MovieInfo("Good News", "A good news story."));

        mockMvc.perform(get("/movies/Good News"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"movieId\":\"Good News\",\"description\":\"A good news story.\"}"));;
    }

    @Test
    void movieNotFound() throws Exception {

        when(mockMovieInfoRepo.getMovieInfo("Bad News"))
                .thenThrow(new ResourceNotFoundException());

        mockMvc.perform(get("/movies/Bad News"))
                .andExpect(status().isNotFound());
    }

}