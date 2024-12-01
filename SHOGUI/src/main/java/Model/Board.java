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

    }
    public boolean movePiece(int x, int y, int newX, int newY) {return false;}
    private boolean dintreLimits(int x, int y) {return false;}


    //Getters
    public Piece getPiece(int x, int y) {
        return board[x][y];
    }


}
