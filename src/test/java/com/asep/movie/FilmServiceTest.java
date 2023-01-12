package com.asep.movie;

import com.asep.movie.model.Film;
import com.asep.movie.repository.FilmRepository;
import com.asep.movie.service.FilmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class FilmServiceTest {

    @Autowired
    private  FilmService filmService;

    @MockBean
    private FilmRepository filmRepository;

    @Test
    @DisplayName("Test findAll")
    void testFindAll() {
        // Setup our mock repository
        Film widget1 = new Film(2, "Widget Name");
        Film widget2 = new Film(3, "Widget 2 Name");
        doReturn(Arrays.asList(widget1, widget2)).when(filmRepository).findAll();

        // Execute the service call
        List<Film> widgets = filmService.getAll();

        // Assert the response
        Assertions.assertEquals(2, widgets.size(), "findAll should return 2 widgets");
    }
    @Test
    @DisplayName("Test save film")
    void testSave() {
        // Setup our mock repository
        Film widget = new Film(2, "Widget Name");
        doReturn(widget).when(filmRepository).save(any());

        // Execute the service call
        Film returnedWidget = filmService.create(widget);

        // Assert the response
        Assertions.assertNotNull(returnedWidget, "The saved widget should not be null");
        Assertions.assertEquals(2, returnedWidget.id, "The version should be incremented");
    }


    @Test
    @DisplayName("Test findById Success")
    void testFindById() {
        // Setup our mock repository
        Film widget = new Film(2, "Widget Name");
        doReturn(Optional.of(widget)).when(filmRepository).findById(2);

        // Execute the service call
        Film returnedWidget = filmService.getById(2);

        // Assert the response
        Assertions.assertTrue(returnedWidget!=null, "Widget was not found");
        Assertions.assertSame(returnedWidget, widget, "The widget returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(filmRepository).findById(2);

        // Execute the service call
        Film returnedWidget = filmService.getById(2);

        // Assert the response
        Assertions.assertFalse(returnedWidget!=null, "Widget should not be found");
    }


}
