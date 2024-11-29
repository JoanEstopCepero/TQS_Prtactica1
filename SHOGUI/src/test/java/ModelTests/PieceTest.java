package ModelTests;

import Model.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    void testConstructor() {
        Piece piece = createPiece("TestPiece", 0, 0, true);
        assertEquals("TestPiece", piece.getName(), "nom incorrecte");
        assertEquals(0, piece.getX(), "x incorrecte");
        assertEquals(0, piece.getY(), "y incorrecte");
        assertTrue(piece.isWhite(), "color incorrecte");
    }



    private Piece createPiece(String name, int x, int y, boolean isWhite) {
        return new Piece(name, x, y, isWhite) {
            @Override
            public boolean isValidMove(int newX, int newY, Piece[][] board) {
                return true;
            }
        };
    }
}
