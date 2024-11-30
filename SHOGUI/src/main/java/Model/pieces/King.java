package Model.pieces;
import Model.Piece;

public class King extends Piece{
    public King(int x, int y, boolean isWhite) {
        super("K", x, y, isWhite);
    }
    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board){
        return false;
    }

}
