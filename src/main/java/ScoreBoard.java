public class ScoreBoard {
    private Player player1;
    private Player player2;

    public ScoreBoard(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String showScoreBoard() {
        if (player1.showPoints() > 3 || player2.showPoints() > 3) {
            if (player1.showPoints() >= player2.showPoints() + 2) {
                return Winner.PLAYER1.toString();
            } else if (player2.showPoints() >= player1.showPoints() + 2) {
                return Winner.PLAYER2.toString();
            } else if (player1.showPoints() + 1 == player2.showPoints() || player2.showPoints() + 1 == player1.showPoints()) {
                return ScoreDescription.ADVANTAGE.getScoreName();
            } else
                return ScoreDescription.DEUCE.getScoreName();
        } else {
            return Winner.NOWINNER.toString();
        }
    }

}
