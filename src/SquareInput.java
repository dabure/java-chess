public class SquareInput {

    private String column;
    private Integer row;

    private SquareInput(String column, Integer row) {
        this.column = column;
        this.row = row;
    }

    public static SquareInput fromColumnAndRow(String column, Integer row) {
        return new SquareInput(column, row);
    }

}