import pieces.King;
import pieces.Piece;

import java.util.Scanner;
import exceptions.InvalidInputException;
import exceptions.NoPlayerPieceFoundException;

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
            System.out.print(game.toString());

            // Choose two squares
            chooseSquare();
            chooseSquare();
        }
    }

    private Piece chooseSquare() {
        while (true) {
            System.out.print("Choose a square: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            try {
                SquareInput squareInput = parseSquareInput(input);
            } catch (InvalidInputException error) {
                continue;
            }
        }
    }

    private SquareInput parseSquareInput(String input) throws InvalidInputException {
        String[] splittedInput = input.trim().split("");

        if (splittedInput.length != 2) {
            throw new InvalidInputException();
        }
        return SquareInput.fromColumnAndRow(
            splittedInput[0].trim(), Integer.valueOf(splittedInput[1].trim())
        );
    }

}
