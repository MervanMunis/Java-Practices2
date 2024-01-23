import MovieTest.Film;
import MovieTest.FilmLibrary;
import MovieTest.IFilm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        Film newFilm = new Film();

        newFilm.setTitle("Demon Slayer");
        newFilm.setDirector("Mervan Munis");
        newFilm.setYear(2000);
        filmLibrary.add(newFilm);

        newFilm.setTitle("Naruto");
        newFilm.setDirector("Hira Munis");
        newFilm.setYear(2003);
        filmLibrary.add(newFilm);

        newFilm.setTitle("Ippo");
        newFilm.setDirector("Sina Munis");
        newFilm.setYear(2010);

        filmLibrary.add(newFilm);

        System.out.println(filmLibrary.listOfFilms());

        System.out.println();
        filmLibrary.remove("Naruto");


        System.out.println(filmLibrary.listOfFilms());

        System.out.println();

        System.out.println(filmLibrary.searchFilms("Ippo"));
    }
}
