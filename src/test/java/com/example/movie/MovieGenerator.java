package com.example.movie;

import com.example.movie.movie.entity.MovieEntity;

import java.util.ArrayList;
import java.util.List;

public class MovieGenerator {
    public static List<MovieEntity> list() {
        List<MovieEntity> movies = new ArrayList<>();
        movies.add(new MovieEntity(1L,"Загадочные Сумерки", "В городе, погруженном в вечные сумерки, раскрывается тайна, связанная с загадочными фигурами, владеющими временем."));
        movies.add(new MovieEntity(2L,"Эхо Времени", "Группа исследователей путешествует через временные порталы, сталкиваясь с неожиданными вызовами и тайнами прошлого и будущего."));
        movies.add(new MovieEntity(3L,"Лабиринт Лжи", "В зачарованном лабиринте скрываются тайны и иллюзии, ведущие героев к неизведанным уровням их собственной сущности."));
        movies.add(new MovieEntity(4L,"Гиперборея: Путеводная Звезда", "Под предводительством загадочной звезды герои отправляются в увлекательное путешествие по древнему континенту Гипербореи, раскрывая ее древние тайны."));
        movies.add(new MovieEntity(5L,"Аномалия Снов", "Герои сталкиваются с загадочными явлениями в мире снов, где реальность и фантазия переплетаются, создавая поразительные приключения."));
        movies.add(new MovieEntity(6L,"Невидимый Мир", "Группа ученых раскрывает существование параллельного мира, где законы физики искажены, и начинают исследование этой невидимой реальности."));
        movies.add(new MovieEntity(7L,"Воскрешение Сферы", "Секретная организация исследует таинственную сферу, обладающую уникальными способностями, способными изменить ход истории."));
        movies.add(new MovieEntity(8L,"Танцующие Скрижали", "Магический балет, в котором танцоры становятся исполнителями древних заклинаний, пробуждая силы, спящие в глубинах времени."));
        movies.add(new MovieEntity(9L,"Аквариум Душ", "Под водой скрыты тайны, и герои погружаются в глубины океана, чтобы обнаружить аквариум, хранящий души погибших."));
        movies.add(new MovieEntity(10L,"Шифр Астралов", "В космическом астрале раскрывается шифр, ведущий к загадочному миру, где реальность переплетается с магией."));
        movies.add(new MovieEntity(11L,"Метеоритные Откровения", "Падение метеоритов на Землю открывает новые возможности и вызывает каскад загадок, сталкивающих героев с невероятными событиями."));
        movies.add(new MovieEntity(12L,"Магия Кристалла", "В поисках последнего магического кристалла герои отправляются в опасное путешествие, где каждый шаг определяет будущее."));
        return movies;
    }
}
