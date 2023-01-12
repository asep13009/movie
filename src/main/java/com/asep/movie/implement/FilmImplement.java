package com.asep.movie.implement;

import com.asep.movie.model.Film;
import com.asep.movie.repository.FilmRepository;
import com.asep.movie.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class FilmImplement implements FilmService {

    @Autowired
    FilmRepository filmRepository;
    @Override
    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film getById(Integer id) {
        Optional<Film> data = filmRepository.findById(id);
        if(data.isPresent()){
            return data.get();
        }
        return null;

    }

    @Override
    public Film create(Film film) {
        Optional<Film> data =filmRepository.findById(film.id);
        if(data.isEmpty()){
            film.setCreatedAt(new Date());
            return filmRepository.save(film);
        }
        return null;

    }

    @Override
    public Film update(Integer id, Film film) {
        if(filmRepository.findById(id).isPresent()){
            film.setId(id);
            film.setUpdatedAt(new Date());
            return filmRepository.save(film);
        }
        return  null;

    }

    @Override
    public void delete(Integer id) {
        Film film = filmRepository.findById(id).get();
        filmRepository.delete(film);
    }
}
