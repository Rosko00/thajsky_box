package sk.proCodeAcademy.thajskyBox;

// Táto trieda reprezentuje bojovníka
public class Fighter {
    private String name;
    private int wins;
    private int losses;
    private int age;

    // Konštruktor triedy
    public Fighter (String name, int age) {
        this.name = name;
        this.age = age;
        this.wins = 0;
        this.losses = 0;
    }

    // Metóda ktorá zvyšuje počet výhier o 1
    public void winFight () {
        wins++;
    }

    // Metóda ktorá zvyšuje počet prehier o 1
    public void loseFight() {
        losses++;
    }

    // Metóda na výpis štatistík bojovníka
    public void printStats () {
        System.out.println("Fighter: " + name);
        System.out.println("Age: " + age);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }

    // Command + N alebo ALT + Insert
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
