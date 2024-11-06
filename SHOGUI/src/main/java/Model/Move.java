package Model;

public class Move {
    //Atributs
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece piece;
    private Piece captured_piece;

    //Metodes
    public Move(int startX, int startY, int endX, int endY, Piece piece){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.piece = piece;
        this.captured_piece = null;
    }

    public int getStartX() {return startX;}
    public int getStartY() {return startY;}
    public int getEndX() {return endX;}
    public int getEndY() {return endY;}
    public Piece getPiece() {return piece;}
    public Piece getCaptured_piece() {return captured_piece;}

}
