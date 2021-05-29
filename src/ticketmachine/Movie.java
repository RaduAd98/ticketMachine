/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketmachine;

/**
 *
 * @author Radu
 */
public class Movie {

    String id;
    String code;
    String title;
    String day;
    String hour;
    String genres;

    //Constructor with only five variables
    public Movie(String id, String code, String title, String day, String hour) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.day = day;
        this.hour = hour;
    }

    //Constructor with only three variables
    public Movie(String code, String title, String genres) {
        this.code = code;
        this.title = title;
        this.genres = genres;
    }

    //Constructor with only two variables
    public Movie(String day, String hour) {
        this.day = day;
        this.hour = hour;
    }

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    //toString Method
    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", code=" + code + ", title=" + title + ", day=" + day + ", hour=" + hour + ", genres=" + genres + '}';
    }
}
