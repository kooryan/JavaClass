package company.Arrays_and_Java_Built_in_Lists.LinkedLists.LinkedLists_Challenge;

public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() { // printing out the contents of the actual class/object
        return this.title + ": " + this.duration;
    }
}
