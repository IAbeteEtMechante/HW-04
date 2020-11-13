package space.harbour.java.hw4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
// import java.lang.ClassNotFoundException;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;


public class Movies implements Jsonable {
    String title;
    Integer year;
    String released;
    Integer runtime;
    String[] genres;
    Director director;
    Writer[] writers;
    Actor[] actors;
    String plot;
    String[] languages;
    String[] countries;
    String awards;
    String poster;
    Rating[] ratings;


    public static class Director implements Jsonable {
        String name;

        @Override
        public String toString() {
            return "Director{"
                    + "name='" + name + '\''
                    + '}';
        }

        @Override
        public JsonObject toJsonObject() {
            return Json.createObjectBuilder()
                    .add("Name", name)
                    .build();
        }

        @Override
        public String toJsonString() {
            return this.toJsonObject().toString();
        }

        

    }

    public static class Writer implements Jsonable {
        String name;
        String type;

        @Override
        public String toString() {
            return "Writer{"
                    + "name='" + name + '\''
                    + ", type=" + type
                    + '}';
        }

        @Override
        public JsonObject toJsonObject() {
            return Json.createObjectBuilder()
                    .add("Name", name)
                    .add("Type", type)
                    .build();
        }

        @Override
        public String toJsonString() {
            return this.toJsonObject().toString();
        }
    }

    public static class Actor implements Jsonable {
        String name;
        String as;

        @Override
        public String toString() {
            return "Actor{"
                    + "name='" + name + '\''
                    + ", as='" + as + '\''
                    + '}';
        }

        @Override
        public JsonObject toJsonObject() {
            return Json.createObjectBuilder()
                    .add("Name", name)
                    .add("As", as)
                    .build();
        }

        @Override
        public String toJsonString() {
            return this.toJsonObject().toString();
        }
    }

    public static class Rating implements Jsonable {
        String source;
        String value;
        int votes;

        @Override
        public String toString() {
            return "Rating{"
                    + "source='" + source + '\''
                    + ", value='" + value + '\''
                    + ", votes='" + votes + '\''
                    + '}';
        }

        @Override
        public JsonObject toJsonObject() {
            return Json.createObjectBuilder()
                    .add("Source", source)
                    .add("Value", value)
                    .add("Votes", votes)
                    .build();
        }

        @Override
        public String toJsonString() {
            return this.toJsonObject().toString();
        }
    }

    @Override
    public JsonObject toJsonObject() {
        JsonArrayBuilder genresBuilder = Json.createArrayBuilder();
        for (String genre : genres) {
            genresBuilder.add(genre);
        }

        JsonArrayBuilder writersBuilder = Json.createArrayBuilder();
        for (Writer writer : writers) {
            writersBuilder.add(writer.toJsonObject());
        }

        JsonArrayBuilder actorsBuilder = Json.createArrayBuilder();
        for (Actor actor : actors) {
            actorsBuilder.add(actor.toJsonObject());
        }

        JsonArrayBuilder languagesBuilder = Json.createArrayBuilder();
        for (String language : languages) {
            languagesBuilder.add(language);
        }

        JsonArrayBuilder countriesBuilder = Json.createArrayBuilder();
        for (String country : countries) {
            countriesBuilder.add(country);
        }

        JsonArrayBuilder ratingsBuilder = Json.createArrayBuilder();
        for (Rating rating : ratings) {
            ratingsBuilder.add(rating.toJsonObject());
        }
        return Json.createObjectBuilder()
                .add("Title", title)
                .add("Year", year)
                .add("Released", released)
                .add("Runtime", runtime)
                .add("Genres", genresBuilder.build())
                .add("Director", director.toJsonObject())
                .add("Writers", writersBuilder.build())
                .add("Actors", actorsBuilder.build())
                .add("Plot", plot)
                .add("Languages", languagesBuilder.build())
                .add("Countries", countriesBuilder.build())
                .add("Awards", awards)
                .add("Poster", poster)
                .add("Ratings", ratingsBuilder.build())
                .build();
    }

    @Override
    public String toJsonString() {
        return this.toJsonObject().toString();
    }

    public static void writeJsonToFile(JsonObject jsonObj, String fileName) throws IOException {
        fileName += "./src/main/java/space/harbour/java/hw4/";
        FileOutputStream fout = new FileOutputStream(fileName);
        // BufferedOutputStream bout = new BufferedOutputStream(fout);
        JsonWriter jout = Json.createWriter(fout);
        jout.writeObject(jsonObj);
        jout.close();
        // jout.flush();

    }




    public static JsonObject readJsonFromFile(String fileName) 
                            throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(fileName);
        BufferedInputStream bin = new BufferedInputStream(fin);
        JsonReader jin = Json.createReader(bin);
        return jin.readObject();
    }

    public static void main(String[] args) {


    }

}
