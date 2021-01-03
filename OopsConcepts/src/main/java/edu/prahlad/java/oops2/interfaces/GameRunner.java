package edu.prahlad.java.oops2.interfaces;

public class GameRunner {
    public static void main(String[] args) {

        GamingConsole[] gamingConsole = {new MarioGame(), new ChessGame()};

        for(GamingConsole game: gamingConsole) {
            game.up();
            game.down();
            game.left();
            game.right();
        }

    }
}
