package Model.pieces;
import Model.Piece;

public class Bishop extends Piece {
    public Bishop(int x, int y, boolean isWhite) {
        super("B", x, y, isWhite);
    }
    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board){
        return false;
    }
}
