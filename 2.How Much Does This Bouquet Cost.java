import java.util.Scanner;

public class HowMuchDoesThisBouquetCost {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //CHECKING FOR INVALID INPUTS
        try {
            System.out.print("Enter number of daisies (0 - 230): ");
            int daisiesCount = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter number of roses (0 - 150): ");
            int rosesCount = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter number of lilies (0 - 75): ");
            int liliesCount = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter season (words): ");
            String season = scanner.nextLine().toLowerCase();
            System.out.print("Is it a holiday?(\"Yes\"\\\"yes\" or \"No\"\\\"no\"): ");
            String holiday = scanner.nextLine().toLowerCase();

        //invalid input for daisies in details
        if (daisiesCount < 0 || daisiesCount > 230) {
            System.out.println("Invalid input for number of daisies! Try again, please! " +
                    "Keep in mind that negative or decimal numbers are not acceptable!");
            System.out.print("Enter number of daisies (0 - 230): ");
            daisiesCount = Integer.parseInt(scanner.nextLine());
        }

        //invalid input for roses in details
        if (rosesCount < 0 || rosesCount > 150) {
            System.out.println("Invalid input for number of roses! Try again, please! " +
                    "Keep in mind that negative or decimal numbers are not acceptable!");
            System.out.print("Enter number of roses (0 - 150): ");
            rosesCount = Integer.parseInt(scanner.nextLine());
        }

        //invalid input for lilies in details
        if (liliesCount < 0 || liliesCount > 75) {
            System.out.println("Invalid input for number of lilies! Try again, please! " +
                    "Keep in mind that negative or decimal numbers are not acceptable!");
            System.out.print("Enter number of lilies (0 - 75): ");
            liliesCount = Integer.parseInt(scanner.nextLine());
        }

        //invalid input for season in details
        if (!("spring".equals(season)) && !("summer".equals(season)) &&
                !("autumn".equals(season)) && !("fall".equals(season)) && !("winter".equals(season))) {
            System.out.println("Invalid word for season or bad spelling! Try again, please! " +
                    "Keep in mind that \"Fall\"\\\"fall\" is also acceptable. First letter could always be both capital or low.");
            System.out.print("Enter season (words): ");
            season = scanner.nextLine().toLowerCase();
        }

        //invalid answer of the holiday reply in details
        if (!("Yes".equals(holiday)) && !("yes".equals(holiday)) &&
                !("No".equals(holiday)) && !("no".equals(holiday))) {
            System.out.println("Wrong word or bad spelling in the holiday reply! Try again, please!");
            System.out.print("Is it a holiday?(\"Yes\"\\\"yes\" or \"No\"\\\"no\"): ");
            holiday = scanner.nextLine().toLowerCase();
        }

        //WHEN ALL INTS ARE VALID THE PROGRAM STARTS
        //prices per a flower in the different seasons
        double pricePerADaisy = 0;
        double pricePerARose = 0;
        double pricePerALily = 0;

        if ("spring".equals(season) || "summer".equals(season)) {
            pricePerADaisy = 4.00;
            pricePerARose = 8.20;
            pricePerALily = 5.00;

        } else {
            pricePerADaisy = 7.50;
            pricePerARose = 9.00;
            pricePerALily = 8.30;
        }

        //holiday prices of the flowers
        if ("yes".equals(holiday)) {
            pricePerADaisy += 0.05 * pricePerADaisy;
            pricePerARose += 0.05 * pricePerARose;
            pricePerALily += 0.05 * pricePerALily;
        }

        //prices of the bouquet without discounts
        double priceOfAllDaisies = pricePerADaisy * daisiesCount;
        double priceOfAllRoses = pricePerARose * rosesCount;
        double priceOfAllLilies = pricePerALily * liliesCount;
        double priceOfBouquet = priceOfAllDaisies + priceOfAllRoses + priceOfAllLilies;

        //discounts
        if (liliesCount > 7 && "spring".equals(season)) {
            priceOfBouquet -= 0.10 * priceOfBouquet;
        }

        if (rosesCount >= 10 && ("winter".equals(season) || "autumn".equals(season) || "fall".equals(season))) {
            priceOfBouquet -= 0.15 * priceOfBouquet;
        }

        if ((daisiesCount + rosesCount + liliesCount) > 20) {
            priceOfBouquet -= 0.20 * priceOfBouquet;
        }

        //price of bouquet plus $2 for arranging
        double priceOfBouquetPlusArranging = priceOfBouquet + 2;

        if (priceOfBouquet > 0) {
            System.out.printf("$%.2f", priceOfBouquetPlusArranging);
        } else {
            System.out.printf("$%.2f", priceOfBouquet);
        }

        } catch (Exception ex) {
            System.out.println("Sorry, invalid input!!! Start from the beginning, please! " +
                    "Read the instructions carefully!");
        }

    }
}