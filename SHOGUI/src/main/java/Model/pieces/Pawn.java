package Model.pieces;

import Model.Piece;

public class Pawn extends Piece {
    public Pawn(String name, int x, int y, boolean isWhite){
        super(name, x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        return false;
    }
}