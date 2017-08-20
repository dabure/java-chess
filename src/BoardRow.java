import java.util.ArrayList;

public class BoardRow {

    private static final Integer NUMBER_OF_COLUMNS = 8;
    private ArrayList<BoardSquare> boardSquares;

    private BoardRow(Integer rowNumber) {
        this.boardSquares = generateSquares(rowNumber);
    }

    public static BoardRow fromRowNumber(Integer rowNumber) {
        return new BoardRow(rowNumber);
    }

    private ArrayList<BoardSquare> generateSquares(Integer rowNumber) {
        ArrayList<BoardSquare> squares = new ArrayList<>();
        for (Integer columnNumber = 0; columnNumber < NUMBER_OF_COLUMNS; columnNumber++) {
            Color color = getSquareColorFromRowAndColumn(rowNumber, columnNumber);
            squares.add(BoardSquare.fromColor(color));
        }
        return squares;
    }

    private static Color getSquareColorFromRowAndColumn(Integer row, Integer column) {
        Boolean isEven = Utility.isEven(row + column);
        if (isEven) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    public void render() {
        for (Integer i=0; i<boardSquares.size(); i++) {
            System.out.print(" ");
            System.out.print("[ ]");
        }
    }
}
