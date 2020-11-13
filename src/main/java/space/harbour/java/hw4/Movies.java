package space.harbour.java.hw4;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;


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
            return null;
        }

        @Override
        public JsonObject toJsonObject() {
            return null;
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
            return null;
        }

        @Override
        public JsonObject toJsonObject() {
            return null;
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
            return null;
        }

        @Override
        public JsonObject toJsonObject() {
            return null;
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
            return null;
        }

        @Override
        public JsonObject toJsonObject() {
            return null;
        }

        @Override
        public String toJsonString() {
            return this.toJsonObject().toString();
        }
    }

    @Override
    public JsonObject toJsonObject() {
        return null;
    }

    @Override
    public String toJsonString() {
        return this.toJsonObject().toString();
    }

}
