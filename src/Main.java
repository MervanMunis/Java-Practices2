import MovieTest.Film;
import MovieTest.FilmLibrary;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Average Calculator To calculate the average UNCOMMENT the code below.
//        if (AverageCalculator.calculateAverage() > 60)
//            System.out.println("Passed");
//        else
//            System.out.println("Failed");

//        To calculate the BODY MASS INDEX UNCOMMENT the code below.
//        System.out.println(CalculateBMI.bodyMassIndex());

//        MineSweeper mineSweeper = new MineSweeper(4,4);
//        mineSweeper.run();

//        Game game = new Game();
//        game.start();

        FilmLibrary filmLibrary = new FilmLibrary();
        Film film = new Film();

        film.setTitle("Herry Poter");
        film.setDirector("Jhon");
        film.setYear(2000);
        filmLibrary.add(film);

        film.setTitle("Poter");
        film.setDirector("michler");
        film.setYear(2003);
        filmLibrary.add(film);

        film.setTitle("Herry");
        film.setDirector("simon");
        film.setYear(2010);

        filmLibrary.add(film);

        List<List<Object>> allFilms = new ArrayList<>();
        for (int i=0; i<filmLibrary.listOfFilms().size(); i++) {
            List<Object> filmList = new ArrayList<>();
            filmList.add(filmLibrary.listOfFilms().get(i).getTitle());
            filmList.add(filmLibrary.listOfFilms().get(i).getDirector());
            filmList.add(filmLibrary.listOfFilms().get(i).getYear());
            allFilms.add(filmList);
        }

        System.out.println(allFilms);

        System.out.println();
        filmLibrary.remove("Poter");

        List<List<Object>> allFilms1 = new ArrayList<>();
        for (int i=0; i<filmLibrary.listOfFilms().size(); i++) {
            List<Object> filmList = new ArrayList<>();
            filmList.add(filmLibrary.listOfFilms().get(i).getTitle());
            filmList.add(filmLibrary.listOfFilms().get(i).getDirector());
            filmList.add(filmLibrary.listOfFilms().get(i).getYear());
            allFilms1.add(filmList);
        }
        System.out.println(allFilms1);

        System.out.println();

        List<List<Object>> allFilms2 = new ArrayList<>();
        for (int i=0; i<filmLibrary.searchFilms("Herry").size(); i++) {
            List<Object> filmList = new ArrayList<>();
            filmList.add(filmLibrary.searchFilms("Herry").get(i).getTitle());
            filmList.add(filmLibrary.searchFilms("Herry").get(i).getDirector());
            filmList.add(filmLibrary.searchFilms("Herry").get(i).getYear());
            allFilms2.add(filmList);
        }
        System.out.println(allFilms2);
    }
}
