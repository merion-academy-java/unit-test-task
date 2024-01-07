package com.example.movie.movie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String title;
    protected String description;

    public MovieEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public MovieEntity(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
