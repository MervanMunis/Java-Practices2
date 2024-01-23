package MovieTest;

import java.util.List;

public interface IFilmLibrary {

    void add(IFilm film);

    void remove(String title);

    List<List<Object>> listOfFilms();

    List<List<Object>>  searchFilms(String query);


}
