package org.jedynakd.tennisgame.score;

import org.jedynakd.tennisgame.players.Player;
import org.jedynakd.tennisgame.winner.Winner;

public class ScoreBoard {
    private Player player1;
    private Player player2;

    public ScoreBoard(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        if (player1.getPoints() > 3 || player2.getPoints() > 3) {
            if (player1.getPoints() >= player2.getPoints() + 2) {
                return Winner.PLAYER1.toString();
            } else if (player2.getPoints() >= player1.getPoints() + 2) {
                return Winner.PLAYER2.toString();
            } else if (player1.getPoints() + 1 == player2.getPoints() || player2.getPoints() + 1 == player1.getPoints()) {
                return ScoreDescription.ADVANTAGE.toString();
            } else
                return ScoreDescription.DEUCE.toString();
        } else {
            return Winner.NOWINNER.toString();
        }
    }

}
