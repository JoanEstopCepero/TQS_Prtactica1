package Model;

public abstract class Piece{
    //Atributs
    protected String name;
    protected int x, y;
    protected boolean isWhite;

    //Metodes
    public Piece(String name, int x, int y, boolean isWhite) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
    }

    public abstract boolean isValidMove(int newX, int newY, Piece[][] board);

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    //Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public boolean isWhite() {
        return isWhite;
    }

    //Setters
    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
    }
}