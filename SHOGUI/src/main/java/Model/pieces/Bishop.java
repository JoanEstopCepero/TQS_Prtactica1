package Model.pieces;
import Model.Piece;

public class Bishop extends Piece {
    public Bishop(int x, int y, boolean isWhite) {
        super("B", x, y, isWhite);
    }
    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board){
        if((newX >= 0 && newX < 9)&&(newY >= 0 && newY < 9))
        {
            int dx = Math.abs(newX - x);
            int dy = Math.abs(newY - y);

            if (dx != dy) {
                return false; // Solo se mueve en diagonal
            }

            int stepX = (newX - x) / dx;
            int stepY = (newY - y) / dy;

            // Verificar que el camino esté libre
            for (int i = 1; i < dx; i++) {
                if (board[x + i * stepX][y + i * stepY] != null) {
                    return false;
                }
            }

            return true;
        }
            return false;
    }
}
