import pieces.Piece;

import java.util.ArrayList;

public class Player {

    private ArrayList<Piece> pieces;

    private Player() {
        //this.pieces = generatePieces();
    }

    public static Player build() {
        return new Player();
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
