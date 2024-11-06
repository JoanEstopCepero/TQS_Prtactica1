package Model;

import java.util.List;

public class Piece {
    //Atributs
    private Player owner;
    private boolean is_promoted;

    //Mètodes
    public List<Move> getPossibleMoves(Board board, int x, int y){
        return null;
    }
    public void promote(){};

    public Player getOwner() {return owner;}
    public boolean isIs_promoted() {return is_promoted;}
}
