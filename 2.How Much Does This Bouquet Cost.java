import java.util.Scanner;

public class HowMuchDoesThisBouquetCost {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter number of daisies (0 - 230): ");
            int daisiesCount = Integer.parseInt(scanner.nextLine());
            while (daisiesCount < 0 || daisiesCount > 230) {
                System.out.print("Invalid input! Daisies must be between 0 and 230: ");
                daisiesCount = Integer.parseInt(scanner.nextLine());
            }

            System.out.print("Enter number of roses (0 - 150): ");
            int rosesCount = Integer.parseInt(scanner.nextLine());
            while (rosesCount < 0 || rosesCount > 150) {
                System.out.print("Invalid input! Roses must be between 0 and 150: ");
                rosesCount = Integer.parseInt(scanner.nextLine());
            }

            System.out.print("Enter number of lilies (0 - 75): ");
            int liliesCount = Integer.parseInt(scanner.nextLine());
            while (liliesCount < 0 || liliesCount > 75) {
                System.out.print("Invalid input! Lilies must be between 0 and 75: ");
                liliesCount = Integer.parseInt(scanner.nextLine());
            }

            System.out.print("Enter season (words): ");
            String season = scanner.nextLine().toLowerCase();
            while (!("spring".equals(season)) && !("summer".equals(season)) &&
                    !("autumn".equals(season)) && !("fall".equals(season)) && !("winter".equals(season))) {
                System.out.print("Invalid season or bad spelling! Try again - \"Fall\" is also acceptable: ");
                season = scanner.nextLine().toLowerCase();
            }

            System.out.print("Is it holiday - \"Yes\" or \"No\": ");
            String holiday = scanner.nextLine().toLowerCase();
            while (!("Yes".equals(holiday)) && !("yes".equals(holiday)) &&
                    !("No".equals(holiday)) && !("no".equals(holiday))) {
                System.out.print("Wrong answer or bad spelling! The answer must be only \"Yes\" or \"No\". Try again: ");
                holiday = scanner.nextLine().toLowerCase();
            }

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
                System.out.printf("Price of the bouquet: $%.2f", priceOfBouquetPlusArranging);
            } else {
                System.out.printf("Price of the bouquet: $%.2f", priceOfBouquet);
            }

        } catch (Exception ex) {
            System.out.println("Sorry, invalid input!!! Start from the beginning, please! " +
                    "Read the instructions carefully!");
        }

    }
}