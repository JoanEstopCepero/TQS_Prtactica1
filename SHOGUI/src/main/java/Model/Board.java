package Model;
import java.util.Arrays;
public class Board {
    //Atributs
    private Piece[][] board;

    //Mètodes
    public Board(){
        board = new Piece[8][8];
        initialize_board();
    }
    private void initialize_board(){};
    public Piece getPieceAt(int x, int y){
        return null;
    };
    private void move_piece(int startX, int startY, int endX, int endY){};
    public boolean is_inside_board(int x, int y){
        return false;
    };

    public Piece[][] getBoard() {return board;}
}
