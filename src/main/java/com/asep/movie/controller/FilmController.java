package com.asep.movie.controller;

import com.asep.movie.model.Film;
import com.asep.movie.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FilmController {

    @Autowired
    FilmService filmService;

    @GetMapping("/Movies")
    public List<Film> getAllMovie() {
        return filmService.getAll();
    }
    @PostMapping("/Movies")
    public Object create(@RequestBody Film film) {
        Map<String, Object> result = new HashMap<>();
        Film data = filmService.create(film);
        if(data!=null){
            return data;
        }
        result.put("status","failed");
        return result;
    }
    @PatchMapping("/Movies/{id}")
    public Object update(@PathVariable("id") Integer id, @RequestBody Film film) {
        Map<String,Object> result = new HashMap<>();
        Film res = filmService.update(id, film);
        if(res!=null){
            return res;
        }else {
            result.put("status","failed");
            return result;
        }

    }

    @GetMapping("/Movies/{id}")
    public Object getById(@PathVariable("id") Integer id) {
        Map<String,String> result = new HashMap<>();
        Film data = filmService.getById(id);
        if(data!=null){
            return data;
        }
        result.put("status","failed");
        return result;
    }

    @DeleteMapping("/Movies/{id}")
    public Map<String, String> delete(@PathVariable("id") Integer id){
        Map<String,String> result = new HashMap<>();
        try {
            result.put("status","deleted");
            filmService.delete(id);
        }catch(Exception e) {
            result.put("status","failed");
            return result;
        }
        return result;
    }
}
