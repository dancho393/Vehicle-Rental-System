package cli.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StartMenu implements Menu{
    public StartMenu(){
    }


    @Override
    public void run(Scanner scanner) {
        System.out.println("Welcome to the vehicle Rental System");
        boolean isRunning = true;
        while(isRunning){
            System.out.println("Please select an option:");
            System.out.println("1. Print All Vehicles");
            System.out.println("2. Rent A Vehicle");
            System.out.println("3. Exit");
            try {
                int option = scanner.nextInt();
                switch (option){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        isRunning = false;
                        break;
                    default:
                        printInvalidInput();
                        break;
                }
            }catch (InputMismatchException e){
                printInvalidInput();
            }
        }
    }
    private void printInvalidInput(){
        System.out.println("Please enter a valid option!");
    }
}
