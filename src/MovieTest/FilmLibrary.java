package MovieTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FilmLibrary implements IFilmLibrary{
    private final List<IFilm> films;

    public FilmLibrary() {
        this.films = new ArrayList<>();
    }

    @Override
    public void add(IFilm film) {
        IFilm newFilm = new Film();
        newFilm.setTitle(film.getTitle());
        newFilm.setDirector(film.getDirector());
        newFilm.setYear(film.getYear());
        this.films.add(newFilm);
    }

    @Override
    public void remove(String title) {
        this.films.removeIf(film -> Objects.equals(film.getTitle(), title));
    }

    @Override
    public List<List<Object>> listOfFilms() {
        List<List<Object>> listFilms =
                this.films.stream()
                        .map(film -> {
                            List<Object> filmList = new ArrayList<>();
                            filmList.add(film.getTitle());
                            filmList.add(film.getDirector());
                            filmList.add(film.getYear());
                            return filmList;
                        }).toList();

        return listFilms;
    }

    @Override
    public List<List<Object>> searchFilms(String query) {

        List<List<Object>> listFilms = films.stream()
                .filter(film -> film.getTitle().equals(query) || film.getDirector().equals(query))
                .map(film -> {
                    List<Object> filmList = new ArrayList<>();
                    filmList.add(film.getTitle());
                    filmList.add(film.getDirector());
                    filmList.add(film.getYear());
                    return filmList;
                }).collect(Collectors.toList());

        return listFilms;
    }

}
