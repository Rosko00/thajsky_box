package sk.proCodeAcademy.thajskyBox;

public class MuayThaiMatch {
    private Fighter fighter1;
    private Fighter fighter2;
    private FightScore score;

    public MuayThaiMatch(Fighter fighter1, Fighter fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.score = new FightScore();
    }

    public void startMatch() {
        int scoreFighter1 = score.calculateScore("kick") + score.calculateScore("elbow");
        int scoreFighter2 = score.calculateScore("punch") + score.calculateScore("kick");

        System.out.println(fighter1.getName() + " score: " + scoreFighter1);
        System.out.println(fighter2.getName() + " score: " + scoreFighter2);

        if (scoreFighter1 > scoreFighter2) {
            System.out.println(fighter1.getName() + " wins!");
        } else if (scoreFighter1 < scoreFighter2) {
            System.out.println(fighter2.getName() + " wins!");
        } else {
            System.out.println("It's a draw!"); // remíza
        }
    }
}