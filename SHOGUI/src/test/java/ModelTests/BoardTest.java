package ModelTests;

import Model.Board;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    void testConstructorBoard(){
        Board tauler = new Board();
        assertEquals("L", tauler.getPiece(0,0).getName(), "fitxa incorrecte");
        assertEquals("L", tauler.getPiece(8,8).getName(), "fitxa incorrecte");
        assertEquals("N", tauler.getPiece(1,0).getName(), "fitxa incorrecte");
        assertEquals("N", tauler.getPiece(7,0).getName(), "fitxa incorrecte");
        assertEquals("S", tauler.getPiece(2,0).getName(), "fitxa incorrecte");
        assertEquals("S", tauler.getPiece(6,0).getName(), "fitxa incorrecte");
        assertEquals("G", tauler.getPiece(3,0).getName(), "fitxa incorrecte");
        assertEquals("G", tauler.getPiece(5,0).getName(), "fitxa incorrecte");
        assertEquals("K", tauler.getPiece(4,0).getName(), "fitxa incorrecte");
        assertEquals("R", tauler.getPiece(1,1).getName(), "fitxa incorrecte");
        assertEquals("B", tauler.getPiece(7,1).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(0,2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(1,2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(2,2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(3,2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(4,2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(5,2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(6,2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(7,2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(8,2).getName(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(0,0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(1,0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(2,0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(3,0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(4,0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(5,0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(6,0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(7,0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(8,0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(7,1).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(1,1).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(4,2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(8,2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(7,2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(6,2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(5,2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(4,2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(3,2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(2,2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(1,2).isWhite(), "fitxa incorrecte");



        assertEquals("L", tauler.getPiece(0,8).getName(), "fitxa incorrecte");
        assertEquals("L", tauler.getPiece(8,8).getName(), "fitxa incorrecte");
        assertEquals("N", tauler.getPiece(1,8).getName(), "fitxa incorrecte");
        assertEquals("N", tauler.getPiece(7,8).getName(), "fitxa incorrecte");
        assertEquals("S", tauler.getPiece(2,8).getName(), "fitxa incorrecte");
        assertEquals("S", tauler.getPiece(6,8).getName(), "fitxa incorrecte");
        assertEquals("G", tauler.getPiece(3,8).getName(), "fitxa incorrecte");
        assertEquals("G", tauler.getPiece(5,8).getName(), "fitxa incorrecte");
        assertEquals("K", tauler.getPiece(4,8).getName(), "fitxa incorrecte");
        assertEquals("R", tauler.getPiece(1,7).getName(), "fitxa incorrecte");
        assertEquals("B", tauler.getPiece(7,7).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(0,6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(1,6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(2,6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(3,6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(4,6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(5,6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(6,6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(7,6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(8,6).getName(), "fitxa incorrecte");

        assertFalse(tauler.getPiece(0,8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(1,8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(2,8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(3,8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(4,8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(5,8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(6,8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(7,8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(8,8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(7,7).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(1,7).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(4,6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(8,6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(7,6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(6,6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(5,6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(4,6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(3,6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(2,6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(1,6).isWhite(), "fitxa incorrecte");
    }
}
