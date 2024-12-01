package Model;
import Model.pieces.*;

public class Board{
    //Atributs
    private Piece[][] board = new Piece[9][9];

    //Metodes
    public Board() {
        initializeBoard();
    }
    private void initializeBoard() {
        // --- Inicialización de las piezas ---
        board[0][0] = new Lance(0, 0, true);
        board[1][0] = new Knight(1, 0, true);
        board[2][0] = new SilverGeneral(2, 0, true);
        board[3][0] = new GoldGeneral(3, 0, true);
        board[4][0] = new King(4, 0, true);
        board[5][0] = new GoldGeneral(5, 0, true);
        board[6][0] = new SilverGeneral(6, 0, true);
        board[7][0] = new Knight(7, 0, true);
        board[8][0] = new Lance(8, 0, true);

        board[1][1] = new Rook(1, 1, true);
        board[7][1] = new Bishop(7, 1, true);

        for (int i = 0; i < 9; i++) {
            board[i][2] = new Pawn(i, 2, true);
        }

        board[1][7] = new Rook(1, 7, false);
        board[7][7] = new Bishop(7, 7, false);

        board[0][8] = new Lance(0, 8, false);
        board[1][8] = new Knight(1, 8, false);
        board[2][8] = new SilverGeneral(2, 8, false);
        board[3][8] = new GoldGeneral(3, 8, false);
        board[4][8] = new King(4, 8, false);
        board[5][8] = new GoldGeneral(5, 8, false);
        board[6][8] = new SilverGeneral(6, 8, false);
        board[7][8] = new Knight(7, 8, false);
        board[8][8] = new Lance(8, 8, false);

        for (int i = 0; i < 9; i++) {
            board[i][6] = new Pawn(i, 6, false);
        }
    }
    public boolean movePiece(int x, int y, int newX, int newY) {return false;}
    private boolean dintreLimits(int x, int y) {return false;}


    //Getters
    public Piece getPiece(int x, int y) {
        return board[x][y];
    }


}
