package Model.pieces;
import Model.Piece;

public class GoldGeneral extends Piece{
    public GoldGeneral(int x, int y, boolean isWhite){

        super("G", x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        return false;
    }
}
