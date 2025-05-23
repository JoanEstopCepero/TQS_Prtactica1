package Model.pieces;

import Model.Piece;

public class Knight extends Piece {
    public Knight(int x, int y, boolean isWhite) {
        super("N", x, y, isWhite);
    }
    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        if ((newX >= 0 && newX < 9) && (newY >= 0 && newY < 9))
        {
            int dx = Math.abs(newX - x);
            int dy = newY - y;

            int direction = isWhite ? 1 : -1; // Blancos suben, negros bajan

            if (dx == 1 && dy == 2 * direction) {
                Piece targetPiece = board[newX][newY];
                return targetPiece == null || targetPiece.isWhite() != this.isWhite;
            }
        }
        return false;
    }
}
