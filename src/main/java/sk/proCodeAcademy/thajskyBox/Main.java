package sk.proCodeAcademy.thajskyBox;

public class Main {
    public static void main(String[] args) {

        // Vytvoríme objekt bojovníka s menom a vekom
        Fighter fighter1 = new Fighter("Monika Chochlíková", 29);

        // Pridanie výhru
        fighter1.winFight();

        // Pridaj prehru
        fighter1.loseFight();

        // Štatistika bojovníka
        fighter1.printStats();

        // Trieda FightScore
        FightScore score = new FightScore();
        int scoreForKick = score.calculateScore("kick");
        System.out.println("Score for kick: " + scoreForKick);

        Fighter fighter2 = new Fighter("Kickboxer King", 30);
        MuayThaiMatch match = new MuayThaiMatch(fighter1, fighter2);
        match.startMatch();

        StaminaCalculator staminaCalc = new StaminaCalculator();
        int rounds = staminaCalc.calculateRounds(45); // Výdrž bojovníka 45
        System.out.println("Bojovník zvládne " + rounds + " kôl.");

        MatchHistory history = new MatchHistory();
        history.addMatchResult("Monika Chochlíková won against Kickboxer King");
        history.addMatchResult("Monika Chochlíková won against Boxer Joe");
        history.printMatchHistory();
    }
}
