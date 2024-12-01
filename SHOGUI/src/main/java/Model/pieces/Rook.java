package Model.pieces;
import Model.Piece;
public class Rook extends Piece{
    public Rook(int x, int y, boolean isWhite) {
        super("R", x, y, isWhite);
    }
    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board){
        return false;
    }
}
