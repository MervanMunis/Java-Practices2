package MovieTest;

import java.util.List;

public interface IFilmLibrary {

    void add(IFilm film);

    void remove(String title);

    List<IFilm> listOfFilms();

    List<IFilm> searchFilms(String query);


}
