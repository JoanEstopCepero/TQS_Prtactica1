package Model.pieces;
import Model.Piece;

public class GoldGeneral extends Piece{
    public GoldGeneral(int x, int y, boolean isWhite){

        super("G", x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        if((newX >= 0 && newX < 9)&&(newY >= 0 && newY < 9))
        {
            int dx = newX - x;
            int dy = newY - y;

            if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
                return false; // Movimiento limitado a una casilla
            }

            // Prohibir movimientos en las diagonales traseras
            if ((isWhite && dx == -1 && dy == -1) || (!isWhite && dx == 1 && dy == 1)) {
                return false;
            }
            if ((isWhite && dx == 1 && dy == -1) || (!isWhite && dx == -1 && dy == 1)) {
                return false;
            }

            // No puede moverse a una casilla ocupada por una pieza del mismo color
            Piece targetPiece = board[newX][newY];
            return targetPiece == null || targetPiece.isWhite() != this.isWhite;
        }
        return false;
    }
}
