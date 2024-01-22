package MovieTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public List<IFilm> listOfFilms() {
        return this.films;
    }

    @Override
    public List<IFilm> searchFilms(String query) {
        List<IFilm> selectedFilms = new ArrayList<>();
        for (IFilm film : films) {
            if (film.getTitle().equals(query) || film.getDirector().equals(query)) {
                selectedFilms.add(film);
            }
        }
        return selectedFilms;
    }

}
