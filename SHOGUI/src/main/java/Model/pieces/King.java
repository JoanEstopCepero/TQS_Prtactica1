package Model.pieces;
import Model.Piece;

public class King extends Piece{
    public King(int x, int y, boolean isWhite) {
        super("K", x, y, isWhite);
    }
    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board){
        boolean valid_move = false;
        if((newX >= 0 && newX < 9)&&(newY >= 0 && newY < 9))
        {
            int dx = Math.abs(newX - x);
            int dy = Math.abs(newY - y);
            Piece targetPiece = board[newX][newY];
            if((dx <= 1 && dy <= 1) && (targetPiece == null || targetPiece.isWhite() != this.isWhite))
            {
                valid_move = true;
            }
        }
        return valid_move;
    }

}
