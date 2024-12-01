package Model.pieces;
import Model.Piece
public class Lance extends Piece{
    public Lance(int x, int y, boolean isWhite) {
        super("L", x, y, isWhite);
    }
    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board){
        return false;
    }
}
