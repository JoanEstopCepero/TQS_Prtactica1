package ModelTests;

import Model.Piece;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    void testConstructor() {
        Piece piece = createPiece("TestPiece", 0, 0, true);
        assertEquals("TestPiece", piece.getName(), "nom incorrecte");
        assertEquals(0, piece.getX(), "x incorrecte");
        assertEquals(0, piece.getY(), "y incorrecte");
        assertTrue(piece.isWhite(), "color incorrecte");

        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        assertThrows(IllegalArgumentException.class, () -> createPiece("TestPiece", -10, -10, true),
                "El constructor hauria de llemçar excepcio valors molt negatius");

        assertThrows(IllegalArgumentException.class, () -> createPiece("TestPiece", -1, -1, true),
                "El constructor hauria de llemçar excepcio valors  negatius");

        Piece piece5 = createPiece("TestPiece", 5, 6, true);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = createPiece("TestPiece", 8, 8, true);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        assertThrows(IllegalArgumentException.class, () -> createPiece("TestPiece", 9, 9, true),
                "El constructor hauria de llemçar excepcio valos positius");

        assertThrows(IllegalArgumentException.class, () -> createPiece("TestPiece", 10, 10, true),
                "El constructor hauria de llemçar excepcio valors molt positius");
    }

    @Test
    void testSetPosition() {
        Piece piece = createPiece("TestPiece", 0, 0, true);
        piece.setPosition(4, 6);
        assertEquals(4, piece.getX(), "setPosition falla en la x");
        assertEquals(6, piece.getY(), "setPosition falla en la y");

        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        Piece piece_10 = createPiece("TestPiece", 0, 0, true);
        assertThrows(IllegalArgumentException.class, () -> piece_10.setPosition(-10, -10),
                "setPosition permet valors molt negatius");

        Piece piece_1 = createPiece("TestPiece", 0, 0, true);
        assertThrows(IllegalArgumentException.class, () -> piece_1.setPosition(-1, -1),
                "setPosition permet valors negatius");

        Piece piece5 = createPiece("TestPiece", 0, 0, true);
        piece5.setPosition(5, 6);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = createPiece("TestPiece", 0, 0, true);
        piece8.setPosition(8, 8);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        Piece piece9 = createPiece("TestPiece", 0, 0, true);
        assertThrows(IllegalArgumentException.class, () -> piece9.setPosition(9, 9),
                "setPosition permet valors grans");

        Piece piece100 = createPiece("TestPiece", 0, 0, true);
        assertThrows(IllegalArgumentException.class, () -> piece100.setPosition(100, 100),
                "setPosition permet valors molt grans");
    }

    @Test
    void testMove() {
        Piece piece = createPiece("TestPiece", 2, 3, true);
        piece.move(7, 8);
        assertEquals(7, piece.getX(), "move falla en la x");
        assertEquals(8, piece.getY(), "move falla en la y");

        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        Piece piece_10 = createPiece("TestPiece", 0, 0, true);
        assertThrows(IllegalArgumentException.class, () -> piece_10.move(-10, -10),
                "move permet valors molt negatius");

        Piece piece_1 = createPiece("TestPiece", 0, 0, true);
        assertThrows(IllegalArgumentException.class, () -> piece_1.move(-1, -1),
                "move permet valors negatius");

        Piece piece5 = createPiece("TestPiece", 0, 0, true);
        piece5.move(5, 6);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = createPiece("TestPiece", 0, 0, true);
        piece8.move(8, 8);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        Piece piece9 = createPiece("TestPiece", 0, 0, true);
        assertThrows(IllegalArgumentException.class, () -> piece9.move(9, 9),
                "move permet valors positius");

        Piece piece100 = createPiece("TestPiece", 0, 0, true);
        assertThrows(IllegalArgumentException.class, () -> piece100.move(100, 100),
                "move permet valors molt positius");
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
