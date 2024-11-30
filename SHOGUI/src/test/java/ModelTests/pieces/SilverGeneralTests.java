package ModelTests.pieces;

import Model.Board;
import Model.Piece;
import Model.pieces.SilverGeneral;
import Model.pieces.King;
import Model.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SilverGeneralTests {
    @Test
    void testConstructorKing() {
        SilverGeneral whiteSG = new SilverGeneral(0, 0, true);
        assertEquals("S", whiteSG.getName(), "fitxa incorrecte");
        assertEquals(0, whiteSG.getX(), "x incorrecte");
        assertEquals(0, whiteSG.getY(), "y incorrecte");
        assertTrue(whiteSG.isWhite(), "color incorrecte");

        SilverGeneral blackSG= new SilverGeneral(3, 6, false);
        assertEquals("S", blackSG.getName(), "fitxa incorrecte");
        assertEquals(3, blackSG.getX(), "x incorrecte");
        assertEquals(6, blackSG.getY(), "y incorrecte");
        assertFalse(blackSG.isWhite(), "color incorrecte");



        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        assertThrows(IllegalArgumentException.class, () -> new SilverGeneral(-10, -10, true),
                "El constructor hauria de llemçar excepcio valors molt negatius");

        assertThrows(IllegalArgumentException.class, () -> new SilverGeneral(-1, -1, true),
                "El constructor hauria de llemçar excepcio valors  negatius");

        Piece piece5 = new SilverGeneral(5, 6, true);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = new SilverGeneral(8, 8, true);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        assertThrows(IllegalArgumentException.class, () -> new SilverGeneral(9, 9, true),
                "El constructor hauria de llemçar excepcio valos positius");

        assertThrows(IllegalArgumentException.class, () -> new SilverGeneral(10, 10, true),
                "El constructor hauria de llemçar excepcio valors molt positius");
    }
}
