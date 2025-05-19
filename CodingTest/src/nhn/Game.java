package nhn;

import java.util.Scanner;

public class Game implements Runnable {

    private final Player[] players;

    public Game(Player[] players) {
        this.players = players;
    }

    @Override
    public void run() {
        try {
            playGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playGame() {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt(); //몇번 실행할건지 입력

        while (input-- > 0) {

        }
    }

}
