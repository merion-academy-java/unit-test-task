package com.example.movie.movie.dto.request;

import com.example.movie.movie.exception.BadRequestException;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EditMovieRequest {
    private String title;
    private String description;

    public void validate() throws BadRequestException {
        if (title == null || title.isBlank()) throw new BadRequestException();
        if (description == null) throw new BadRequestException();
    }
}
