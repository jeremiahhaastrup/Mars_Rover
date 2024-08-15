package input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CompassParser {
    public void compassInput() {
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter The Instructions For The Rover.");
                System.out.println("R: Spin Right at 90 degrees.");
                System.out.println("L: Spin Left at 90 degrees.");
                System.out.println("M: Move Forward by One Grid Point");
                String enteredInstruction = scanner.nextLine();
                for (char index : enteredInstruction.toCharArray()) {
                    switch(index) {
                        case 'R':
                            System.out.println("Spin to the Right");
                            break;
                        case 'L':
                            System.out.println("Spin to the Left");
                            break;
                        case 'M': System.out.println("Move One Grid Point");
                            break;
                        default:
                            System.out.println("Incorrect Format Houston. Try again");
                    }
                }
                scanner.close();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect Format Houston. Try Again" + e);
            }
        }
    }
}
