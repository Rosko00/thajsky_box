package sk.proCodeAcademy.skola;

import java.util.Scanner;

public class Main {
    static final int MAX_STUDENTOV = 100; // Maximálny počet študentov
    static String[] studenti = new String[MAX_STUDENTOV]; // Pole na uloženie mien študentov
    static String[] predmety = {"Matematika", "Angličtina", "Informatika"}; // Predmety
    static int[][] znamky = new int[MAX_STUDENTOV][predmety.length]; // Známky študentov na predmetoch
    static int[][] dochadzka = new int[MAX_STUDENTOV][predmety.length]; // Dochádzka (počet hodín)

    static int pocetStudentov = 0; // Aktuálny počet študentov

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int volba;

        do {
            System.out.println("\n*** Školský systém ***");
            System.out.println("1. Pridať študenta");
            System.out.println("2. Zobraziť študentov");
            System.out.println("3. Pridať známku");
            System.out.println("4. Evidovať dochádzku");
            System.out.println("5. Zobraziť známky a dochádzku");
            System.out.println("0. Ukončiť");
            System.out.print("Vyber možnosť: ");
            volba = scanner.nextInt();

            switch (volba) {
                case 1:
                    pridatStudenta(scanner);
                    break;
                case 2:
                    zobrazitStudentov();
                    break;
                case 3:
                    pridatZnamku(scanner);
                    break;
                case 4:
                    evidovatDochadzku(scanner);
                    break;
                case 5:
                    zobrazitZnamkyDochadzku();
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

    static void pridatStudenta(Scanner scanner) {
        if (pocetStudentov >= MAX_STUDENTOV) {
            System.out.println("Nie je možné pridať viac študentov.");
            return;
        }
        System.out.print("Zadaj meno študenta: ");
        scanner.nextLine(); // Vyčistenie vstupu
        String meno = scanner.nextLine();
        studenti[pocetStudentov] = meno;
        for (int i = 0; i < predmety.length; i++) {
            znamky[pocetStudentov][i] = -1; // Známka -1 znamená, že ešte nebola pridaná
            dochadzka[pocetStudentov][i] = 0; // Dochádzka začína na 0
        }
        pocetStudentov++;
        System.out.println("Študent " + meno + " bol pridaný.");
    }

    static void zobrazitStudentov() {
        if (pocetStudentov == 0) {
            System.out.println("Žiadni študenti neboli pridaní.");
            return;
        }
        System.out.println("\nZoznam študentov:");
        for (int i = 0; i < pocetStudentov; i++) {
            System.out.println((i + 1) + ". " + studenti[i]);
        }
    }

    static void pridatZnamku(Scanner scanner) {
        zobrazitStudentov();
        System.out.print("Zadaj číslo študenta: ");
        int cisloStudenta = scanner.nextInt() - 1;

        if (cisloStudenta < 0 || cisloStudenta >= pocetStudentov) {
            System.out.println("Neplatné číslo študenta.");
            return;
        }

        System.out.println("Dostupné predmety:");
        for (int i = 0; i < predmety.length; i++) {
            System.out.println((i + 1) + ". " + predmety[i]);
        }
        System.out.print("Vyber predmet: ");
        int cisloPredmetu = scanner.nextInt() - 1;

        if (cisloPredmetu < 0 || cisloPredmetu >= predmety.length) {
            System.out.println("Neplatný predmet.");
            return;
        }

        System.out.print("Zadaj známku (1-5): ");
        int znamka = scanner.nextInt();
        if (znamka < 1 || znamka > 5) {
            System.out.println("Neplatná známka.");
            return;
        }

        znamky[cisloStudenta][cisloPredmetu] = znamka;
        System.out.println("Známka bola pridaná.");
    }

    static void evidovatDochadzku(Scanner scanner) {
        zobrazitStudentov();
        System.out.print("Zadaj číslo študenta: ");
        int cisloStudenta = scanner.nextInt() - 1;

        if (cisloStudenta < 0 || cisloStudenta >= pocetStudentov) {
            System.out.println("Neplatné číslo študenta.");
            return;
        }

        System.out.println("Dostupné predmety:");
        for (int i = 0; i < predmety.length; i++) {
            System.out.println((i + 1) + ". " + predmety[i]);
        }
        System.out.print("Vyber predmet: ");
        int cisloPredmetu = scanner.nextInt() - 1;

        if (cisloPredmetu < 0 || cisloPredmetu >= predmety.length) {
            System.out.println("Neplatný predmet.");
            return;
        }

        System.out.print("Zadaj počet hodín na dochádzku: ");
        int hodiny = scanner.nextInt();
        if (hodiny < 0) {
            System.out.println("Neplatný počet hodín.");
            return;
        }

        dochadzka[cisloStudenta][cisloPredmetu] += hodiny;
        System.out.println("Dochádzka bola aktualizovaná.");
    }

    static void zobrazitZnamkyDochadzku() {
        if (pocetStudentov == 0) {
            System.out.println("Žiadni študenti neboli pridaní.");
            return;
        }

        System.out.println("\nZnámky a dochádzka študentov:");
        for (int i = 0; i < pocetStudentov; i++) {
            System.out.println("Študent: " + studenti[i]);
            for (int j = 0; j < predmety.length; j++) {
                String znamka = (znamky[i][j] == -1) ? "nepridaná" : String.valueOf(znamky[i][j]);
                System.out.println("  Predmet: " + predmety[j] + ", Známka: " + znamka + ", Dochádzka: " + dochadzka[i][j] + " hod.");
            }
        }
    }
}
