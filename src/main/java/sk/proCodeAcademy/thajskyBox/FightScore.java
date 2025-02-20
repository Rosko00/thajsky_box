package sk.proCodeAcademy.thajskyBox;

public class FightScore {
    public int calculateScore (String technique) {
        switch (technique.toLowerCase()) {
            case "punch":
                return 10;
            case "kick":
                return 15;
            case "elbow":
                return 20;
            default:
                return 0; // neidentifikovaná technika
        }
    }
}
