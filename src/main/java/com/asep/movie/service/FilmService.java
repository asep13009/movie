package com.asep.movie.service;

import com.asep.movie.model.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {

    public  abstract List<Film> getAll();
    public  abstract  Film getById(Integer id);
    public  abstract Film create(Film film);
    public  abstract Film update (Integer id, Film film);
    public  abstract void delete (Integer id);
}
