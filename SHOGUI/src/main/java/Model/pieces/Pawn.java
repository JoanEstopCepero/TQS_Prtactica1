package Model.pieces;

import Model.Piece;

public class Pawn extends Piece {
    public Pawn(int x, int y, boolean isWhite){
        super("P", x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        return false;
    }
}