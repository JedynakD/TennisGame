package org.jedynakd.tennisgame.winner;

public enum Winner {
    PLAYER1("Player1 wins"), PLAYER2("Player2 wins"),NOWINNER("No winner yet");

    private String winner;

    Winner(String winner) {
        this.winner = winner;
    }

    public String toString() {
        return winner;
    }
}
