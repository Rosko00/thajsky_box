package sk.proCodeAcademy.thajskyBox;

import java.util.ArrayList;

public class MatchHistory {
    private ArrayList<String> matchResults;

    public MatchHistory() {
        matchResults = new ArrayList<>();
    }

    public void addMatchResult(String result) {
        matchResults.add(result);
    }

    public void printMatchHistory() {
        for (String result : matchResults) {
            System.out.println(result);
        }
    }
}