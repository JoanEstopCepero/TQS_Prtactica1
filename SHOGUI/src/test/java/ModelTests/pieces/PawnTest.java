package ModelTests.pieces;

import Model.Piece;
import Model.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PawnTest {
    @Test
    void testConstructorPawn() {
        Pawn whitePawn = new Pawn(0, 0, true);
        assertEquals("P", whitePawn.getName(), "fitxa incorrecte");
        assertEquals(0, whitePawn.getX(), "x incorrecte");
        assertEquals(0, whitePawn.getY(), "y incorrecte");
        assertTrue(whitePawn.isWhite(), "color incorrecte");

        Pawn blackPawn = new Pawn(3, 6, false);
        assertEquals("P", blackPawn.getName(), "fitxa incorrecte");
        assertEquals(3, blackPawn.getX(), "x incorrecte");
        assertEquals(6, blackPawn.getY(), "y incorrecte");
        assertFalse(blackPawn.isWhite(), "color incorrecte");



        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        assertThrows(IllegalArgumentException.class, () -> new Pawn(-10, -10, true),
                "El constructor hauria de llemçar excepcio valors molt negatius");

        assertThrows(IllegalArgumentException.class, () -> new Pawn(-1, -1, true),
                "El constructor hauria de llemçar excepcio valors  negatius");

        Piece piece5 = new Pawn(5, 6, true);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = new Pawn(8, 8, true);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        assertThrows(IllegalArgumentException.class, () -> new Pawn(9, 9, true),
                "El constructor hauria de llemçar excepcio valos positius");

        assertThrows(IllegalArgumentException.class, () -> new Pawn(10, 10, true),
                "El constructor hauria de llemçar excepcio valors molt positius");
    }
}
