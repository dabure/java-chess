import pieces.Piece;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BoardRow {

    public static final Integer NUMBER_OF_COLUMNS = 8;
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

    public String toString() {
        //boardSquares.stream()
                //.map(BoardSquare::getPiece().name)
                //.collect(Collectors.joining(", ")); // "John, Anna, Paul"
        //String.join("", );
        BoardSquare square;
        StringBuilder rowStringBuilder = new StringBuilder();
        for (Integer i=0; i<boardSquares.size(); i++) {
            square = boardSquares.get(i);
            rowStringBuilder.append(" ");
            rowStringBuilder.append(square.toString());
        }
        return rowStringBuilder.toString();
    }

    public void placePiece(Integer columnNumber, Piece piece) {
        BoardSquare square = boardSquares.get(columnNumber);
        square.setPiece(piece);
    }
}
