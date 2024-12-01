package Model.pieces;
import Model.Piece;
public class Lance extends Piece{
    public Lance(int x, int y, boolean isWhite) {
        super("L", x, y, isWhite);
    }
    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board){
        if((newX >= 0 && newX < 9)&&(newY >= 0 && newY < 9)) //verificar posicion nueva dentro tablero
        {
            int dx = newX - x;
            int dy = newY - y;

            if (dx != 0) {
                return false; // Movimiento solo en la misma columna
            }

            int direction = isWhite ? 1 : -1; // Dirección de movimiento
            if (dy * direction <= 0) {
                return false; // Solo puede avanzar
            }

            // Verificar que el camino esté libre
            int step = direction > 0 ? 1 : -1;
            for (int i = y + step; i != newY; i += step) {
                if (board[x][i] != null) {
                    return false;
                }
            }

            // Verificar destino
            Piece targetPiece = board[newX][newY];
            return targetPiece == null || targetPiece.isWhite() != this.isWhite;
        }
        return false;
    }
}
