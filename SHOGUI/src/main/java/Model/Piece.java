package Model;

public abstract class Piece {
    //Atributs
    protected String name;
    protected int x, y;
    protected boolean isWhite;

    //Metodes
    public Piece(String name, int x, int y, boolean isWhite) {
        this.name = name;
        if (x >= 0 && x < 9) {
            this.x = x;
        } else {
            throw new IllegalArgumentException("Invalid x position: " + x);
        }
        if (y >= 0 && y < 9) {
            this.y = y;
        } else {
            throw new IllegalArgumentException("Invalid y position: " + y);
        }
        this.isWhite = isWhite;
    }

    public abstract boolean isValidMove(int newX, int newY, Piece[][] board);

    public void move(int newX, int newY) {
        if (newX >= 0 && newX < 9) {
            this.x = newX;
        } else {
            throw new IllegalArgumentException("Invalid x position_move: " + x);
        }
        if (newY >= 0 && newY < 9) {
            this.y = newY;
        } else {
            throw new IllegalArgumentException("Invalid y position_move: " + y);
        }
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
        if (newX >= 0 && newX < 9) {
            x = newX;
        } else {
            throw new IllegalArgumentException("Invalid x position_set: " + x);
        }
        if (newY >= 0 && newY < 9) {
            y = newY;
        } else {
            throw new IllegalArgumentException("Invalid y position_set: " + y);
        }
    }
}