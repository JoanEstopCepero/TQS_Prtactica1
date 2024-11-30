package ModelTests.pieces;

import Model.Board;
import Model.Piece;
import Model.pieces.King;
import Model.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class KingTest {
    @Test
    void testConstructorKing() {
        King whiteKing = new King(0, 0, true);
        assertEquals("K", whiteKing.getName(), "fitxa incorrecte");
        assertEquals(0, whiteKing.getX(), "x incorrecte");
        assertEquals(0, whiteKing.getY(), "y incorrecte");
        assertTrue(whiteKing.isWhite(), "color incorrecte");

        King blackKing = new King(3, 6, false);
        assertEquals("K", blackKing.getName(), "fitxa incorrecte");
        assertEquals(3, blackKing.getX(), "x incorrecte");
        assertEquals(6, blackKing.getY(), "y incorrecte");
        assertFalse(blackKing.isWhite(), "color incorrecte");



        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        assertThrows(IllegalArgumentException.class, () -> new King(-10, -10, true),
                "El constructor hauria de llemçar excepcio valors molt negatius");

        assertThrows(IllegalArgumentException.class, () -> new King(-1, -1, true),
                "El constructor hauria de llemçar excepcio valors  negatius");

        Piece piece5 = new King(5, 6, true);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = new King(8, 8, true);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        assertThrows(IllegalArgumentException.class, () -> new King(9, 9, true),
                "El constructor hauria de llemçar excepcio valos positius");

        assertThrows(IllegalArgumentException.class, () -> new King(10, 10, true),
                "El constructor hauria de llemçar excepcio valors molt positius");
    }
}
