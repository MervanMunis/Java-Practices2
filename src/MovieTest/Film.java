package MovieTest;

public class Film implements IFilm{
    private String title;
    private String director;
    private int year;
    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDirector() {
        return this.director;
    }

    @Override
    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }
}
