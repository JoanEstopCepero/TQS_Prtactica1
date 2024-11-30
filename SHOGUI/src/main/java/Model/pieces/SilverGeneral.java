package Model.pieces;

import Model.Piece;

public class SilverGeneral extends Piece{
    public SilverGeneral(int x, int y, boolean isWhite){
        super("S", x, y, isWhite);
    }
    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        return false;
    }
}
