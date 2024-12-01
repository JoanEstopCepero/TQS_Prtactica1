package ModelTests.pieces;

import Model.Piece;
import Model.pieces.GoldGeneral;
import Model.pieces.SilverGeneral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldGeneralTest {
    @Test
    void testConstructorGG() {
        GoldGeneral whiteGG = new GoldGeneral(0, 0, true);
        assertEquals("G", whiteGG.getName(), "fitxa incorrecte");
        assertEquals(0, whiteGG.getX(), "x incorrecte");
        assertEquals(0, whiteGG.getY(), "y incorrecte");
        assertTrue(whiteGG.isWhite(), "color incorrecte");

        GoldGeneral blackGG= new GoldGeneral(3, 6, false);
        assertEquals("G", blackGG.getName(), "fitxa incorrecte");
        assertEquals(3, blackGG.getX(), "x incorrecte");
        assertEquals(6, blackGG.getY(), "y incorrecte");
        assertFalse(blackGG.isWhite(), "color incorrecte");



        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        assertThrows(IllegalArgumentException.class, () -> new GoldGeneral(-10, -10, true),
                "El constructor hauria de llemçar excepcio valors molt negatius");

        assertThrows(IllegalArgumentException.class, () -> new GoldGeneral(-1, -1, true),
                "El constructor hauria de llemçar excepcio valors  negatius");

        Piece piece5 = new GoldGeneral(5, 6, true);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = new GoldGeneral(8, 8, true);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        assertThrows(IllegalArgumentException.class, () -> new GoldGeneral(9, 9, true),
                "El constructor hauria de llemçar excepcio valos positius");

        assertThrows(IllegalArgumentException.class, () -> new GoldGeneral(10, 10, true),
                "El constructor hauria de llemçar excepcio valors molt positius");
    }
}
