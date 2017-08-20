import pieces.Piece;

import java.util.ArrayList;

public class Game {

    private Board board;
    private ArrayList<Piece> piecesPlayer1;
    private ArrayList<Piece> piecesPlayer2;

    private Game() {
        this.board = generateBoard();
    }

    public static Game build() {
        return new Game();
    }

    private Board generateBoard() {
        return Board.build();
    }

    public void movePiece() {

    }

    public void render() {
        board.render();
    }

}
