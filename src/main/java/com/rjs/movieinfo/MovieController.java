package com.rjs.movieinfo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {
    @Autowired
    private MovieInfoRepo movieInfoRepo;

    @RequestMapping("/{movieId}")
    public MovieInfo getMovieInfo(final @PathVariable String movieId) {
        return movieInfoRepo
                .findMovieInfoByMovieId(movieId)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
