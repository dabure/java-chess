import exceptions.NoPlayerPieceFoundException;
import pieces.*;

import java.util.ArrayList;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;

    private Game() {
        this.board = generateBoard();
        this.player1 = generatePlayer(PlayerNumber.PLAYER_ONE);
        this.player2 = generatePlayer(PlayerNumber.PLAYER_TWO);

        this.placePiecesForNewGame(player1.getPieces(), 0);
        this.placePiecesForNewGame(player2.getPieces(), 6);
    }

    public static Game build() {
        return new Game();
    }

    private ArrayList<Piece> generatePawnPieces() {
        ArrayList<Piece> pieces = new ArrayList<>();
        for (Integer i=0; i<Board.NUMBER_OF_ROWS; i++) {
            pieces.add(new Pawn());
        }
        return pieces;
    }

    private ArrayList<Piece> generateOtherPieces() {
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.add(new Rook());
        pieces.add(new Knight());
        pieces.add(new Bishop());
        pieces.add(new Queen());
        pieces.add(new King());
        pieces.add(new Bishop());
        pieces.add(new Knight());
        pieces.add(new Rook());
        return pieces;
    }


    private ArrayList<Piece> generatePieces(Boolean pawnsFirst) {
        ArrayList<Piece> otherPieces = generateOtherPieces();
        ArrayList<Piece> pawnPieces = generatePawnPieces();
        if (pawnsFirst) {
            pawnPieces.addAll(otherPieces);
            return pawnPieces;
        } else {
            otherPieces.addAll(pawnPieces);
            return otherPieces;
        }
    }

    private Player generatePlayer(PlayerNumber playerNumber) {
        Boolean pawnsFirst = (playerNumber == PlayerNumber.PLAYER_TWO);
        ArrayList<Piece> pieces = generatePieces(pawnsFirst);
        Player player = Player.build();
        player.setPieces(pieces);
        return player;
    }

    private Board generateBoard() {
        return Board.build();
    }

    public void placePiecesForNewGame(ArrayList<Piece> pieces, Integer startRow) {
        Integer rowNumber = startRow, columnNumber = 0;
        Piece piece;

        for (Integer i=0; i<pieces.size(); i++) {
            piece = pieces.get(i);
            board.placePiece(rowNumber, columnNumber, piece);
            if (isLastSquareOfRow(columnNumber)) {
                rowNumber++;
                columnNumber = 0;
            } else {
                columnNumber++;
            }
        }
    }

    private Boolean isLastSquareOfRow(Integer columnNumber) {
        // We take the column number + 1 because we assume that
        // columnNumber is 0-indexed.
        return ((columnNumber+1) % BoardRow.NUMBER_OF_COLUMNS) == 0;
    }

    public String toString() {
        return board.toString();
    }

}
