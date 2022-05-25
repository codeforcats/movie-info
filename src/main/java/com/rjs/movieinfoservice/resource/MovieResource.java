package com.rjs.movieinfoservice.resource;

import com.rjs.movieinfoservice.model.MovieInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @RequestMapping("/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable int movieId){
        return new MovieInfo(1, "Jaws");
    }
}
