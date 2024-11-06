package Model;

import java.util.List;

public class Player {
    //Atributs
    private String name;
    private List<Piece> capturedPieces;

    //Mètodes
    public String getName() {return name;}
    public List<Piece> getCapturedPieces() {return capturedPieces;}
}
