using System;

namespace HowMuchDoesThisBouquetCost
{
    class HowMuchDoesThisBouquetCost
    {
        static void Main(string[] args)
        {
            try
            {
                Console.Write("Enter number of daisies (0 - 230): ");
                int daisiesCount = int.Parse(Console.ReadLine());
                Console.Write("Enter number of roses (0 - 150): ");
                int rosesCount = int.Parse(Console.ReadLine());
                Console.Write("Enter number of lilies (0 - 75): ");
                int liliesCount = int.Parse(Console.ReadLine());
                Console.Write("Enter season (words): ");
                String season = Console.ReadLine().ToLower();
                Console.Write("Is it a holiday?(\"Yes\"\\\"yes\" or \"No\"\\\"no\"): ");
                String holiday = Console.ReadLine().ToLower();

                //CHACKING FOR INVALID INPUTS
                //invalid input for daisies
                if (daisiesCount < 0 || daisiesCount > 230)
                {
                    Console.WriteLine("Invalid input for number of daisies! Try again, please! " +
                            "Keep in mind that negative or decimal numbers are not acceptable!");
                    Console.Write("Enter number of daisies (0 - 230): ");
                    daisiesCount = int.Parse(Console.ReadLine());
                }

                //invalid input for roses
                if (rosesCount < 0 || rosesCount > 150)
                {
                    Console.WriteLine("Invalid input for number of roses! Try again, please! " +
                            "Keep in mind that negative or decimal numbers are not acceptable!");
                    Console.Write("Enter number of roses (0 - 150): ");
                    rosesCount = int.Parse(Console.ReadLine());
                }

                //invalid input for lilies
                if (liliesCount < 0 || liliesCount > 75)
                {
                    Console.WriteLine("Invalid input for number of lilies! Try again, please! " +
                            "Keep in mind that negative or decimal numbers are not acceptable!");
                    Console.Write("Enter number of lilies (0 - 75): ");
                    liliesCount = int.Parse(Console.ReadLine());
                }

                //invalid input for season
                if (!("spring".Equals(season)) && !("summer".Equals(season)) &&
                        !("autumn".Equals(season)) && !("fall".Equals(season)) && !("winter".Equals(season)))
                {
                    Console.WriteLine("Invalid word for season or bad spelling! Try again, please! " +
                            "Keep in mind that \"Fall\"\\\"fall\" is also acceptable. First letter could always be both capital or low.");
                    Console.Write("Enter season (words): ");
                    season = Console.ReadLine().ToLower();
                }

                //invalid answer of the holiday reply
                if (!("Yes".Equals(holiday)) && !("yes".Equals(holiday)) &&
                        !("No".Equals(holiday)) && !("no".Equals(holiday)))
                {
                    Console.WriteLine("Wrong word or bad spelling in the holiday reply! Try again, please!");
                    Console.Write("Is it a holiday?(\"Yes\"\\\"yes\" or \"No\"\\\"no\"): ");
                    holiday = Console.ReadLine().ToLower();
                }

                //WHEN ALL INTS ARE VALID THE PROGRAM STARTS
                //prices per a flower in the different seasons
                double pricePerADaisy = 0;
                double pricePerARose = 0;
                double pricePerALily = 0;

                if ("spring".Equals(season) || "summer".Equals(season))
                {
                    pricePerADaisy = 4.00;
                    pricePerARose = 8.20;
                    pricePerALily = 5.00;

                }
                else
                {
                    pricePerADaisy = 7.50;
                    pricePerARose = 9.00;
                    pricePerALily = 8.30;
                }

                //holiday prices of the flowers
                if ("yes".Equals(holiday))
                {
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
                if (liliesCount > 7 && "spring".Equals(season))
                {
                    priceOfBouquet -= 0.10 * priceOfBouquet;
                }

                if (rosesCount >= 10 && ("winter".Equals(season) || "autumn".Equals(season) || "fall".Equals(season)))
                {
                    priceOfBouquet -= 0.15 * priceOfBouquet;
                }

                if ((daisiesCount + rosesCount + liliesCount) > 20)
                {
                    priceOfBouquet -= 0.20 * priceOfBouquet;
                }

                //price of bouquet plus $2 for arranging
                double priceOfBouquetPlusArranging = priceOfBouquet + 2;

                if (priceOfBouquet > 0)
                {
                    Console.WriteLine($"${priceOfBouquetPlusArranging:F2}");
                }
                else
                {
                    Console.WriteLine($"${priceOfBouquet:F2}");
                }

            }
            catch
            {
                Console.WriteLine("Sorry, invalid input!!! Start from the beginning, please! " +
                        "Read the instructions carefully!");
            }

        }
    }
}