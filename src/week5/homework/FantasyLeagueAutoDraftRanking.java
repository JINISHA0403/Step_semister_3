package week5.homework;

import java.util.Arrays;

public class FantasyLeagueAutoDraftRanking {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed,
                      double battingAverage, boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Established player rule
        public static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        // Combined matches and fitness rule
        public static boolean isDraftable(int matchesPlayed,
                                          boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        // Rank players by batting average in descending order
        @Override
        public int compareTo(Player other) {
            return Double.compare(
                    other.battingAverage,
                    this.battingAverage
            );
        }
    }

    public static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];
        int count = 0;

        // Check eligibility
        for (int i = 0; i < players.length; i++) {

            Player player = players[i];

            if (Player.isDraftable(player.matchesPlayed)
                    || Player.isDraftable(
                    player.matchesPlayed,
                    player.injured)) {

                draftable[count] = player;
                count++;
            }
        }

        // Create final array
        Player[] finalList = new Player[count];

        for (int i = 0; i < count; i++) {
            finalList[i] = draftable[i];
        }

        // Sort using Comparable
        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result += (i + 1) + ". " + finalList[i].name;

            if (i < finalList.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}