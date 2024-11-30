package Model.pieces;

import Model.Piece;

public class Pawn extends Piece {
    public Pawn(int x, int y, boolean isWhite){
        super("P", x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, Piece[][] board) {
        int direction = isWhite ? 1 : -1;

        boolean valid_move = false;
        if((newX >= 0 && newX < 9)&&(newY >= 0 && newY < 9))
        {
            Piece targetPiece = board[newX][newY];
            if ((newX == x && newY == y + direction) && (targetPiece == null || targetPiece.isWhite() != this.isWhite))
            {
                valid_move = true;
            }
        }
        return valid_move;
    }
}