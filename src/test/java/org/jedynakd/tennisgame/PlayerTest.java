package org.jedynakd.tennisgame;

import org.jedynakd.tennisgame.players.Player;
import org.jedynakd.tennisgame.score.ScoreDescription;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private Player player;
    
    @Before
    public void setUp(){
        player = new Player();
    }
    
    @Test
    public void shouldReturnZeroWhenPlayerScoredNoPoint() {
        assertEquals(0, player.getPoints());
    }

    @Test
    public void shouldReturnOneWhenPlayerScoredOnePoint() {
        player.scorePoint();
        assertEquals(1, player.getPoints());
    }

    @Test
    public void shouldReturnNoDescriptionWhenScoreValueIsBiggerThanThree() {
        for (int i = 0; i < 5; i++) {
            player.scorePoint();
        }

        assertEquals(ScoreDescription.NODESCRIPTION.toString(), player.getScoreName());
    }

    @Test
    public void shouldReturnLoveWhenScoreValueIsZero() {
        assertEquals(ScoreDescription.LOVE.toString(), player.getScoreName());
    }

    @Test
    public void shouldReturnFifteenWhenScoreValueIsOne() {
        player.scorePoint();

        assertEquals(ScoreDescription.FIFTEEN.toString(), player.getScoreName());
    }

    @Test
    public void shouldReturnThirtyWhenScoreValueIsTwo() {
        player.scorePoint();
        player.scorePoint();

        assertEquals(ScoreDescription.THIRTY.toString(), player.getScoreName());
    }

    @Test
    public void shouldReturnFortyWhenScoreValueIsThree() {
        player.scorePoint();
        player.scorePoint();
        player.scorePoint();

        assertEquals(ScoreDescription.FORTY.toString(), player.getScoreName());
    }
}
