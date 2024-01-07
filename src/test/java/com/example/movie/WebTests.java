package com.example.movie;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        for(MovieEntity movie : MovieGenerator.list()){
            movieRepository.save(movie);
        }
    }

    @Test
    void contextLoadTest() throws Exception {
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
        // Напишите тест, который проверяет корректность работы запроса MovieApiController.create
        assert false;
    }

    @Test
    void findByIdTest() throws Exception {
        // Напишите тест, который проверяет корректность работы запроса MovieApiController.byId
        assert false;
    }

    @Test
    void findById_NotFound_Test() throws Exception {
        // Напишите тест, который проверяет корректность ответа запроса MovieApiController.byId, когда элемент не найдет.
        // запрос должен возвращать 404 статус
        assert false;
    }

    @Test
    void updateTest() throws Exception {
        // Напишите тест, который проверяет корректность работы запроса MovieApiController.edit
        assert false;
    }

    @Test
    void deleteTest() throws Exception {
        // Напишите тест, который проверяет корректность работы запроса MovieApiController.delete
        assert false;
    }

    @Test
    void searchTest() throws Exception {
        // Напишите тест, который проверяет корректность работы запроса MovieApiController.search
        assert false;
    }

    @Test
    void searchExistTest() throws Exception {
        List<MovieEntity> check = new ArrayList<>();
        check.add(new MovieEntity(
                6L,
                "Невидимый Мир",
                "Группа ученых раскрывает существование параллельного мира, где законы физики искажены, и начинают исследование этой невидимой реальности."));


        // Напишите тест, который проверяет корректность работы запроса MovieApiController.search,
        // при заранее созданных данных.
        // PS: код выше удалять не нужно

        assert false;
    }
}
