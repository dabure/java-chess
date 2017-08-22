import pieces.Piece;

import java.util.ArrayList;

public class Board {

    private ArrayList<BoardRow> rows;
    public static final Integer NUMBER_OF_ROWS = 8;
    private ArrayList<String> columns;

    private Board() {
        this.rows = generateRows();
    }

    public static Board build() {
        return new Board();
    }

    private ArrayList<BoardRow> generateRows() {
        Integer rowNumber;
        rows = new ArrayList<>();
        for (rowNumber=0; rowNumber<NUMBER_OF_ROWS; rowNumber++) {
            rows.add(BoardRow.fromRowNumber(rowNumber));
        }
        return rows;
    }

    private String columnsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   ");
        for (String col : getColumns()) {
            stringBuilder.append(col);
            stringBuilder.append("   ");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private String rowsToString() {
        StringBuilder rowsStringBuilder = new StringBuilder();
        for (Integer i=0; i<rows.size(); i++) {
            BoardRow row = rows.get(i);
            rowsStringBuilder.append(String.valueOf(i+1));
            rowsStringBuilder.append(row.toString());
            rowsStringBuilder.append("\n");
        }
        return rowsStringBuilder.toString();
    }

    public String toString() {
        return columnsToString() + rowsToString();
    }

    public ArrayList<String> getColumns() {
        if (columns == null) {
            ArrayList<String> cols = new ArrayList<>();
            cols.add("A");
            cols.add("B");
            cols.add("C");
            cols.add("D");
            cols.add("E");
            cols.add("F");
            cols.add("H");
            cols.add("I");
            this.columns = cols;
        }
        return columns;
    }

    public void placePiece(Integer rowNumber, Integer columnNumber, Piece piece) {
        BoardRow row = rows.get(rowNumber);
        row.placePiece(columnNumber, piece);
    }
}
