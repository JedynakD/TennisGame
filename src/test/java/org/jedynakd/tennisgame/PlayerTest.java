package org.jedynakd.tennisgame;

import org.jedynakd.tennisgame.players.Player;
import org.jedynakd.tennisgame.score.ScoreDescription;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player player;

    @Test
    public void shouldReturnZeroWhenPlayerScoredNoPoint() {
        player = new Player();

        assertEquals(0, player.showPoints());
    }

    @Test
    public void shouldReturnOneWhenPlayerScoredOnePoint() {
        player = new Player();
        player.scorePoint();
        assertEquals(1, player.showPoints());
    }

    @Test
    public void shouldReturnNoDescriptionWhenScoreValueIsBiggerThanThree() {
        player = new Player();
        player.scorePoint();
        player.scorePoint();
        player.scorePoint();
        player.scorePoint();
        player.scorePoint();
        assertEquals(ScoreDescription.NODESCRIPTION.toString(), player.showScoreName());
    }

    @Test
    public void shouldReturnLoveWhenScoreValueIsZero() {
        player = new Player();

        assertEquals(ScoreDescription.LOVE.toString(), player.showScoreName());
    }

    @Test
    public void shouldReturnFifteenWhenScoreValueIsOne() {
        player = new Player();
        player.scorePoint();

        assertEquals(ScoreDescription.FIFTEEN.toString(), player.showScoreName());
    }

    @Test
    public void shouldReturnThirtyWhenScoreValueIsTwo() {
        player = new Player();
        player.scorePoint();
        player.scorePoint();

        assertEquals(ScoreDescription.THIRTY.toString(), player.showScoreName());
    }

    @Test
    public void shouldReturnFortyWhenScoreValueIsThree() {
        player = new Player();
        player.scorePoint();
        player.scorePoint();
        player.scorePoint();

        assertEquals(ScoreDescription.FORTY.toString(), player.showScoreName());
    }
}