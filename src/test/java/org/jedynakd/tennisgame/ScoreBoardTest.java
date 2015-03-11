package org.jedynakd.tennisgame;

import org.jedynakd.tennisgame.players.Player;
import org.jedynakd.tennisgame.score.ScoreBoard;
import org.jedynakd.tennisgame.score.ScoreDescription;
import org.jedynakd.tennisgame.winner.Winner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScoreBoardTest {
    @Mock private Player mockedPlayer1;
    @Mock private Player mockedPlayer2;
    private ScoreBoard board;

    @Test
    public void thatPlayerShouldWinWhichHasScoreValueMoreThanFourAndHasTwoMorePointsThanOtherPlayer() {
        when(mockedPlayer1.getPoints()).thenReturn(4);
        when(mockedPlayer2.getPoints()).thenReturn(6);
        board = new ScoreBoard(mockedPlayer1, mockedPlayer2);

        assertEquals(Winner.PLAYER2.toString(), board.getScore());
    }

    @Test
    public void shouldReturnDeuceWhenPlayersHaveEqualScoreValuesAndTheirScoreIsMoreThanThree() {
        when(mockedPlayer1.getPoints()).thenReturn(4);
        when(mockedPlayer2.getPoints()).thenReturn(4);
        board = new ScoreBoard(mockedPlayer1, mockedPlayer2);

        assertEquals(ScoreDescription.DEUCE.toString(), board.getScore());
    }

    @Test
    public void shouldReturnAdvantageWhenOneOfThePlayersHasOneMorePointThenOtherPlayerAndTheirScoreIsMoreThanThree() {
        when(mockedPlayer1.getPoints()).thenReturn(4);
        when(mockedPlayer2.getPoints()).thenReturn(5);
        board = new ScoreBoard(mockedPlayer1, mockedPlayer2);

        assertEquals(ScoreDescription.ADVANTAGE.toString(), board.getScore());
    }

    @Test
    public void shouldReturnNoWinnerYetWhenBothPlayersScoresAreLessThanFour() {
        when(mockedPlayer1.getPoints()).thenReturn(1);
        when(mockedPlayer2.getPoints()).thenReturn(1);
        board = new ScoreBoard(mockedPlayer1, mockedPlayer2);

        assertEquals(Winner.NOWINNER.toString(), board.getScore());
    }
}