package com.rjs.movieinfoservice;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MovieInfoRepo {

    public MovieInfo getMovieInfo(String movieId){
        if (movieInfoMap.containsKey(movieId))
            return movieInfoMap.get(movieId);
        else
            throw new ReourceNotFoundException();
    }

    private final java.util.Map<String, MovieInfo> movieInfoMap = Map.of(
        "Jaws",
        new MovieInfo("Jaws", "A man eating shark terrorises seaside resort.")
    );

}
