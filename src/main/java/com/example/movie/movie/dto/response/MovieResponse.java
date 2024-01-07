package com.example.movie.movie.dto.response;

import com.example.movie.movie.entity.MovieEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class MovieResponse {

    protected Long id;
    protected String title;
    protected String description;

    public static MovieResponse of(MovieEntity item) {
        return MovieResponse.builder()
                .id(item.getId())
                .title(item.getTitle())
                .description(item.getDescription())
                .build();
    }
}
