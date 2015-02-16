import org.jedynakd.tennisgame.players.Player;
import org.jedynakd.tennisgame.score.ScoreBoard;
import org.jedynakd.tennisgame.score.ScoreDescription;
import org.jedynakd.tennisgame.winner.Winner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScoreBoardTest {
    private Player mockedPlayer1;
    private Player mockedPlayer2;
    private ScoreBoard board;

    @Before
    public void beforeScoreBoardTest() {
        mockedPlayer1 = mock(Player.class);
        mockedPlayer2 = mock(Player.class);
    }

    @Test
    public void thatPlayerShouldWinWhichHasScoreValueMoreThanFourAndHasTwoMorePointsThanOtherPlayer() {
        when(mockedPlayer1.showPoints()).thenReturn(4);
        when(mockedPlayer2.showPoints()).thenReturn(6);
        board = new ScoreBoard(mockedPlayer1, mockedPlayer2);

        assertEquals(Winner.PLAYER2.toString(), board.showScoreBoard());
    }

    @Test
    public void shouldReturnDeuceWhenPlayersHaveEqualScoreValuesAndTheirScoreIsMoreThanThree() {
        when(mockedPlayer1.showPoints()).thenReturn(4);
        when(mockedPlayer2.showPoints()).thenReturn(4);
        board = new ScoreBoard(mockedPlayer1, mockedPlayer2);

        assertEquals(ScoreDescription.DEUCE.getScoreName(), board.showScoreBoard());
    }

    @Test
     public void shouldReturnAdvantageWhenOneOfThePlayersHasOneMorePointThenOtherPlayerAndTheirScoreIsMoreThanThree() {
        when(mockedPlayer1.showPoints()).thenReturn(4);
        when(mockedPlayer2.showPoints()).thenReturn(5);
        board = new ScoreBoard(mockedPlayer1, mockedPlayer2);

        assertEquals(ScoreDescription.ADVANTAGE.getScoreName(), board.showScoreBoard());
    }

    @Test
    public void shouldReturnNoWinnerYetWhenBothPlayersScoresAreLessThanFour() {
        when(mockedPlayer1.showPoints()).thenReturn(1);
        when(mockedPlayer2.showPoints()).thenReturn(1);
        board = new ScoreBoard(mockedPlayer1, mockedPlayer2);

        assertEquals("No winner yet", board.showScoreBoard());
    }
}