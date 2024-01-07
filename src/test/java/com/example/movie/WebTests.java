package com.example.movie;

import com.example.movie.movie.dto.request.CreateMovieRequest;
import com.example.movie.movie.dto.request.EditMovieRequest;
import com.example.movie.movie.dto.response.MovieResponse;
import com.example.movie.movie.entity.MovieEntity;
import com.example.movie.movie.repository.MovieRepository;
import com.example.movie.movie.routes.MovieRoutes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class WebTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MovieRepository movieRepository;


    @BeforeEach
    public void config() {
        // Возможно тут нужно сгенерировать много кино
        for(MovieEntity movie : MovieGenerator.list()){
            movieRepository.save(movie);
        }
    }

    @Test
    void contextLoad() throws Exception {
        MovieEntity movie = MovieEntity.builder()
                .title("1")
                .description("1")
                .build();

        movie = movieRepository.save(movie);

        mockMvc.perform(get(MovieRoutes.BY_ID, movie.getId().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())

                .andExpect(status().isOk());
    }

    @Test
    void createTest() throws Exception {
        CreateMovieRequest request = CreateMovieRequest.builder()
                .title("createTest")
                .description("createTest")
                .build();

        mockMvc.perform(
                        post(MovieRoutes.CREATE)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andDo(print())
                .andExpect(content().string(containsString("createTest")));
    }

    @Test
    void findByIdTest() throws Exception {
        MovieEntity movie = MovieEntity.builder()
                .title("findById")
                .description("findById")
                .build();

        movieRepository.save(movie);

        mockMvc.perform(get(MovieRoutes.BY_ID, movie.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("findById")));
    }

    @Test
    void findById_NotFound_Test() throws Exception {
        mockMvc.perform(get(MovieRoutes.BY_ID, 100000)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void updateTest() throws Exception {
        MovieEntity movie = MovieEntity.builder()
                .title("q")
                .description("q")
                .build();
        movieRepository.save(movie);

        EditMovieRequest request = EditMovieRequest.builder()
                .title("updateTest")
                .description("updateTest")
                .build();

        mockMvc.perform(put(MovieRoutes.EDIT, movie.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        ).andDo(print()).andExpect(content().string(containsString("updateTest")));
    }

    @Test
    void deleteTest() throws Exception {
        MovieEntity movie = MovieEntity.builder()
                .title("updateTest")
                .description("updateTest")
                .build();

        movie = movieRepository.save(movie);

        mockMvc.perform(
                delete(MovieRoutes.BY_ID, movie.getId())
        ).andDo(print()).andExpect(status().isOk());

        assert movieRepository.findById(movie.getId()).isEmpty();
    }

    @Test
    void searchTest() throws Exception {
        List<MovieResponse> result = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            MovieEntity movie = MovieEntity.builder()
                    .title("title_" + i)
                    .description("description_" + i)
                    .build();

            movie = movieRepository.save(movie);
            result.add(MovieResponse.of(movie));
        }

        mockMvc.perform(get(MovieRoutes.SEARCH)
                        .param("size", "1000")
                        .param("query", "title_")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(result)));

    }

    @Test
    void searchExistTest() throws Exception {
        List<MovieEntity> check = new ArrayList<>();
        check.add(new MovieEntity(
                6L,
                "Невидимый Мир",
                "Группа ученых раскрывает существование параллельного мира, где законы физики искажены, и начинают исследование этой невидимой реальности."));
        mockMvc.perform(get(MovieRoutes.SEARCH)
                        .param("size", "1000")
                        .param("query", "Невидимый Мир")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(check)));

    }
}
