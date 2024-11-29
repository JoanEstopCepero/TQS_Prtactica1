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

    @Test
    void testSetPosition() {
        Piece piece = createPiece("TestPiece", 0, 0, true);
        piece.setPosition(4, 6);
        assertEquals(4, piece.getX(), "setPosition falla en la x");
        assertEquals(6, piece.getY(), "setPosition falla en la y");
    }

    @Test
    void testMove() {
        Piece piece = createPiece("TestPiece", 2, 3, true);
        piece.move(7, 8);
        assertEquals(7, piece.getX(), "move falla en la x");
        assertEquals(8, piece.getY(), "move falla en la y");
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
