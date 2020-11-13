package space.harbour.java.hw4;

public class Movies {
    String title;
    Integer year;
    String released;
    Integer runtime;
    String[] genres;
    Director director;
    Writer[] writer;

    public static class Director {
        String name;
    }

    public static class Writer {
        String name;
        String type;
    }

}
