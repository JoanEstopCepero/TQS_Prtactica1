package Model.pieces;

import Model.Piece;

public class Knight extends Piece {
    public Knight(int x, int y, boolean isWhite) {
        super("N", x, y, isWhite);
    }
    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board){
        return false;
    }
}
