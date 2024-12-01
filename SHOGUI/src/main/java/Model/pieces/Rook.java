package Model.pieces;
import Model.Piece;
public class Rook extends Piece{
    public Rook(int x, int y, boolean isWhite) {
        super("R", x, y, isWhite);
    }
    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board){
        if((newX >= 0 && newX < 9)&&(newY >= 0 && newY < 9))
        {
            return true;
        }
        return false;
    }
}
