public enum ScoreDescription {
    LOVE("love"), FIFTEEN("fifteen"), THIRTY("thirty"), FORTY("forty"), ADVANTAGE("advantage"), DEUCE("deuce"), NODESCRIPTION("No description");

    private String scoreName;

    ScoreDescription(String scoreName) {
        this.scoreName = scoreName;
    }

    public String getScoreName() {
        return scoreName;
    }
}
