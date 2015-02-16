package org.jedynakd.tennisgame.players;

import org.jedynakd.tennisgame.score.ScoreDescription;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private int points;
    private Map<Integer, ScoreDescription> scoreRecord = new HashMap<>();

    public Player() {
        scoreRecord.put(0, ScoreDescription.LOVE);
        scoreRecord.put(1, ScoreDescription.FIFTEEN);
        scoreRecord.put(2, ScoreDescription.THIRTY);
        scoreRecord.put(3, ScoreDescription.FORTY);
    }

    public int showPoints() {
        return points;
    }

    public void scorePoint() {
        points = points + 1;
    }

    public String showScoreName() {
        if (points < 4) {
            return scoreRecord.get(points).getScoreName();
        } else {
            return ScoreDescription.NODESCRIPTION.getScoreName();
        }
    }
}
