package Model.pieces;
import Model.Piece;
public class Rook extends Piece{
    public Rook(int x, int y, boolean isWhite) {
        super("R", x, y, isWhite);
    }
    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board){
        if((newX >= 0 && newX < 9)&&(newY >= 0 && newY < 9)) //verificar posicion nueva dentro tablero
        {
            if (x != newX && y != newY) {
                return false; // Solo se mueve en línea recta
            }

            int stepX = Integer.compare(newX, x);
            int stepY = Integer.compare(newY, y);

            // Verificar que el camino esté libre
            int currX = x + stepX;
            int currY = y + stepY;
            while (currX != newX || currY != newY) {
                if (board[currX][currY] != null) {
                    return false;
                }
                currX += stepX;
                currY += stepY;
            }
            // Verificar destino
            Piece targetPiece = board[newX][newY];
            return targetPiece == null || targetPiece.isWhite() != this.isWhite;
        }
        return false;
    }
}
