package pt.joaocruz04.firebasepusher;

/**
 * Created by jcruz on 11.07.17.
 */

public class Author {

    public String name;
    public String displayName;

    public Author() {
    }

    public Author(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
