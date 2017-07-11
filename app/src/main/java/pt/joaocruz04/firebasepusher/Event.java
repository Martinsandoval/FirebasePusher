package pt.joaocruz04.firebasepusher;

/**
 * Created by jcruz on 11.07.17.
 */

public class Event {

    public String id;
    public String type;
    public Author author;

    public Event() {

    }

    public Event(String id, String type, Author author) {
        this.id = id;
        this.type = type;
        this.author = author;
    }


}
