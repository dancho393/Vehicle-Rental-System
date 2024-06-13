import cli.menu.Menu;
import cli.menu.StartMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Menu menu = new StartMenu();
        menu.run(scanner);
    }
}