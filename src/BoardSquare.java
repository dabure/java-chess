import pieces.Piece;

public class BoardSquare {

    private Color color;
    private Piece piece = null;

    private BoardSquare(Color color) {
        this.color = color;
    }

    public static BoardSquare fromColor(Color color) {
        return new BoardSquare(color);
    }

    public Boolean hasPiece() {
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Color getColor() {
        return color;
    }
}
