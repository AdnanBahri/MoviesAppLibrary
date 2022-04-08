package com.example.net.movies.flex.school.movies.app.library.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    public static final String API_KEY = "eea817b734ed288ab6730d4787451043";
    public static final String BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w500/";
    private static final Map<Integer,String> GENRES_MAP = new HashMap<>();

    public Map<Integer, String> getAllGenres(){
        GENRES_MAP.put(12,"Adventure");
        GENRES_MAP.put(28,"Action");
        GENRES_MAP.put(16,"Animation");
        GENRES_MAP.put(35,"Comedy");
        GENRES_MAP.put(80,"Crime");
        GENRES_MAP.put(99,"Documentary");
        GENRES_MAP.put(18,"Drama");
        GENRES_MAP.put(10751,"Family");
        GENRES_MAP.put(14,"Fantasy");
        GENRES_MAP.put(36,"History");
        GENRES_MAP.put(27,"Horror");
        GENRES_MAP.put(10402,"Music");
        GENRES_MAP.put(9648,"Mystery");
        GENRES_MAP.put(10749,"Romance");
        GENRES_MAP.put(878,"Science Fiction");
        GENRES_MAP.put(10770,"TV Movie");
        GENRES_MAP.put(53,"Thriller");
        GENRES_MAP.put(10752,"War");
        GENRES_MAP.put(37,"Western");
        return GENRES_MAP;
    }
}