package Model.pieces;

import Model.Piece;

public class SilverGeneral extends Piece{
    public SilverGeneral(int x, int y, boolean isWhite){
        super("S", x, y, isWhite);
    }
    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        if((newX >= 0 && newX < 9)&&(newY >= 0 && newY < 9)) //verificar posicion nueva dentro tablero
        {
            int dx = newX - x;
            int dy = newY - y;

            if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
                return false; // Movimiento limitado a una casilla
            }

            // Prohibir movimientos directamente hacia los lados o hacia atrás
            if (dy == 0 || (isWhite && dy == -1 && dx == 0) || (!isWhite && dy == 1 && dx == 0)) {
                return false;
            }

            // No puede moverse a una casilla ocupada por una pieza del mismo color
            Piece targetPiece = board[newX][newY];
            return targetPiece == null || targetPiece.isWhite() != this.isWhite;
        }
        return false;
    }
}
