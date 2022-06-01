package com.rjs.movieinfoservice;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class MovieInfoRepo {

    public Optional<MovieInfo> findMovieInfoByMovieId(String movieId){
        return Optional.ofNullable(movieInfoMap.get(movieId));
    }

    private final java.util.Map<String, MovieInfo> movieInfoMap = Map.of(
        "Jaws",
        new MovieInfo("Jaws", "A man eating shark terrorises seaside resort.")
    );

}
