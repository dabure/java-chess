import java.util.Scanner;

public class Menu {

    private Game game;

    private Menu() {
        // Main instance of the actual game
        this.game = Game.build();
    }

    public static Menu build() {
        return new Menu();
    }

    public void start() {
        while (true) {
            // Render the game menu
            game.render();

            // Ask for operation
            System.out.print("Choose a square: ");
            Scanner scanner = new Scanner(System.in);
            String square = scanner.next();
            System.out.println("You choose " + square);
        }
    }

}
