package com.example.movie;

import com.example.movie.movie.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostgresApplicationTests {

	@Autowired
	private MovieRepository movieRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void repositoryTest() {
		// Напишите простой тест работы movieRepository.
		// Вам необходимо убедиться, что сохраниение и поиск по id проходят корректно

		assert false;
	}

}
