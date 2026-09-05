package week5.homework;

import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    public static void applyMultipliers(double[] playerScores,
                                        int captainIndex,
                                        int viceCaptainIndex) {

        // Captain gets 2× points
        playerScores[captainIndex] =
                playerScores[captainIndex] * 2;

        // Vice-Captain gets 1.5× points
        playerScores[viceCaptainIndex] =
                playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {

        double[] scores = {40, 55, 30, 62};

        applyMultipliers(scores, 1, 3);

        System.out.println(Arrays.toString(scores));
    }
}
