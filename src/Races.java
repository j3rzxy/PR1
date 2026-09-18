import java.util.Scanner;

public class Races extends RaceCars {
    public static void setCars() {
        RaceCars car1 = new RaceCars();
        RaceCars car2 = new RaceCars();
        RaceCars car3 = new RaceCars();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter car name N1: ");
        car1.name = in.nextLine();
        car1.speed = readValidSpeed(in, "N1");

        System.out.print("Enter car name N2: ");
        car2.name = in.nextLine();
        car2.speed = readValidSpeed(in, "N2");

        System.out.print("Enter car name N3: ");
        car3.name = in.nextLine();
        car3.speed = readValidSpeed(in, "N3");

        in.close();

        determineWinner(car1, car2, car3);
    }

    private static int readValidSpeed(Scanner in, String carNumber) {
        int speed;
        while (true) {
            System.out.print("Enter speed car " + carNumber + " (1-250): ");
            speed = in.nextInt();
            in.nextLine();

            if (speedCheck(speed)) {
                return speed;
            }

            System.out.println("Invalid speed. Please enter a value strictly between 0 and 250.");
        }
    }

    public static boolean speedCheck(int speed) {
        return speed > 0 && speed < 250;
    }

    public static void determineWinner(RaceCars c1, RaceCars c2, RaceCars c3) {
        RaceCars winner = c1;

        if (c2.speed > winner.speed) {
            winner = c2;
        }
        if (c3.speed > winner.speed) {
            winner = c3;
        }

        System.out.println("\n=== RACE RESULTS ===");
        System.out.println("The winner is: " + winner.name + " with a speed of " + winner.speed + " km/h!");
    }
}