package sk.proCodeAcademy.lukostrelba;

import java.util.Scanner;
import java.util.Random;

public class Lukostrelba {
    static final int MAX_LUKOSTRELCOV = 10; // Maximálny počet lukostrelcov
    static final int POCET_KOL = 5; // Počet kôl v súťaži

    static String[] lukostrelci = new String[MAX_LUKOSTRELCOV]; // Pole na uloženie mien lukostrelcov
    static int[][] body = new int[MAX_LUKOSTRELCOV][POCET_KOL]; // Body získané v jednotlivých kolách
    static int pocetLukostrelcov = 0; // Aktuálny počet lukostrelcov

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int volba;

        do {
            System.out.println("\n*** Lukostrelecká súťaž ***");
            System.out.println("1. Pridať lukostrelca");
            System.out.println("2. Spustiť súťaž");
            System.out.println("3. Zobraziť výsledky");
            System.out.println("0. Ukončiť");
            System.out.print("Vyber možnosť: ");
            volba = scanner.nextInt();

            switch (volba) {
                case 1:
                    pridatLukostrelca(scanner);
                    break;
                case 2:
                    spustitSutaz(random);
                    break;
                case 3:
                    zobrazitVysledky();
                    break;
                case 0:
                    System.out.println("Program sa ukončuje...");
                    break;
                default:
                    System.out.println("Neplatná voľba!");
            }
        } while (volba != 0);

        scanner.close();
    }

    static void pridatLukostrelca(Scanner scanner) {
        if (pocetLukostrelcov >= MAX_LUKOSTRELCOV) {
            System.out.println("Nie je možné pridať viac lukostrelcov.");
            return;
        }
        System.out.print("Zadaj meno lukostrelca: ");
        scanner.nextLine(); // Vyčistenie vstupu
        String meno = scanner.nextLine();
        lukostrelci[pocetLukostrelcov] = meno;
        for (int i = 0; i < POCET_KOL; i++) {
            body[pocetLukostrelcov][i] = 0; // Na začiatku majú všetci 0 bodov
        }
        pocetLukostrelcov++;
        System.out.println("Lukostrelec " + meno + " bol pridaný.");
    }

    static void spustitSutaz(Random random) {
        if (pocetLukostrelcov == 0) {
            System.out.println("Žiadni lukostrelci nie sú pridaní.");
            return;
        }

        System.out.println("\nSúťaž sa začína!");
        for (int i = 0; i < pocetLukostrelcov; i++) {
            System.out.println("Lukostrelec: " + lukostrelci[i]);
            for (int kolo = 0; kolo < POCET_KOL; kolo++) {
                int zasah = random.nextInt(11); // Náhodné body od 0 do 10
                body[i][kolo] = zasah;
                System.out.println("  Kolo " + (kolo + 1) + ": " + zasah + " bodov");
            }
        }
        System.out.println("Súťaž bola ukončená!");
    }

    static void zobrazitVysledky() {
        if (pocetLukostrelcov == 0) {
            System.out.println("Žiadni lukostrelci nie sú pridaní.");
            return;
        }

        System.out.println("\n*** Výsledky súťaže ***");
        for (int i = 0; i < pocetLukostrelcov; i++) {
            System.out.println("Lukostrelec: " + lukostrelci[i]);
            int celkoveBody = 0;
            for (int kolo = 0; kolo < POCET_KOL; kolo++) {
                System.out.println("  Kolo " + (kolo + 1) + ": " + body[i][kolo] + " bodov");
                celkoveBody += body[i][kolo];
            }
            System.out.println("  Celkové body: " + celkoveBody);
        }
    }
}
