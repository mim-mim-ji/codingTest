package nhn;

public class Player {

    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public static Player of(String name) {
        return new Player(name);
    }

}
