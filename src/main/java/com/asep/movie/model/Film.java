package com.asep.movie.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String title;
    public String description;
    public int rating;
    public String image;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    public Date createdAt;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    public Date updatedAt;

    public Film(int id, String title) {
        this.id=id;
        this.title=title;
    }
}
