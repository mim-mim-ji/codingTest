package nhn;

public class Main {

    public static void main(String[] args) {
        try {
            Player[] players = new Player[] {
                Player.of("테스트1"),
                Player.of("테스트2")
            };

            Game game = new Game(players);
            game.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
