import java.util.ArrayList;

public class Board {

    private ArrayList<BoardRow> rows;
    private static final Integer NUMBER_OF_ROWS = 8;
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

    private void renderColumns() {
        for ()
    }

    public void render() {
        renderColumns();
        for (BoardRow row : rows) {
            row.render();
            System.out.print("\n");
        }
    }

    public ArrayList<String> getColumns() {
        if (columns == null) {
            columns = new ArrayList<>();
            columns.add("A");
            columns.add("B");
            columns.add("C");
            columns.add("D");
            columns.add("E");
            columns.add("F");
            columns.add("H");
            columns.add("I");
        }
        return columns;
    }
}
