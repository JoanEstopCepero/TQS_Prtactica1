package ModelTests.pieces;

import Model.Board;
import Model.Piece;
import Model.pieces.GoldGeneral;
import Model.pieces.Pawn;
import Model.pieces.SilverGeneral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldGeneralTest {
    public class MockBoardW extends Board
    {
        private Piece[][] MockBoardW = new Piece[9][9];
        public MockBoardW(){
            initializeBoard();
        }
        public void initializeBoard(){
            MockBoardW[0][0] = new GoldGeneral(0, 0, true);
            MockBoardW[8][8] = new GoldGeneral(8, 8, true);

            MockBoardW[2][4] = new GoldGeneral(2, 4, true);
            MockBoardW[5][4] = new GoldGeneral(5, 4, true);

            MockBoardW[6][5] = new Pawn(6, 5, false);
            MockBoardW[5][5] = new Pawn(5, 5, true);
        }
        public Piece getPiece(int x, int y) {
            return MockBoardW[x][y];
        }
    }
    public class MockBoardB extends Board
    {
        private Piece[][] MockBoardB = new Piece[9][9];
        public MockBoardB(){
            initializeBoard();
        }
        public void initializeBoard(){
            MockBoardB[0][0] = new GoldGeneral(0, 0, false);
            MockBoardB[8][8] = new GoldGeneral(8, 8, false);

            MockBoardB[2][4] = new GoldGeneral(2, 4, false);
            MockBoardB[5][4] = new GoldGeneral(5, 4, false);

            MockBoardB[6][3] = new Pawn(6, 3, true);
            MockBoardB[5][5] = new Pawn(5, 5, false);
        }
        public Piece getPiece(int x, int y) {
            return MockBoardB[x][y];
        }
    }
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

    @Test
    void testIsValidMoveGG(){
        MockBoardW taulell_aux_w = new MockBoardW();
        Piece gg_00 = taulell_aux_w.getPiece(0,0);
        assertFalse(gg_00.isValidMove(-1, -1, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(gg_00.isValidMove(1, -1, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(gg_00.isValidMove(-1, 1, taulell_aux_w.MockBoardW), "es mou fora taulell");

        Piece gg_88 = taulell_aux_w.getPiece(8,8);
        assertFalse(gg_88.isValidMove(8, 9, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(gg_88.isValidMove(9, 9, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(gg_88.isValidMove(7, 9, taulell_aux_w.MockBoardW), "es mou fora taulell");

        Piece gg_24 = taulell_aux_w.getPiece(2,4);
        assertTrue(gg_24.isValidMove(2, 5, taulell_aux_w.MockBoardW), "no permet moviment correcte");
        assertTrue(gg_24.isValidMove(3, 5, taulell_aux_w.MockBoardW), "no permet moviment correcte");
        assertTrue(gg_24.isValidMove(1, 4, taulell_aux_w.MockBoardW), "no permet moviment correcte");
        assertTrue(gg_24.isValidMove(2, 3, taulell_aux_w.MockBoardW), "no permet moviment correcte");
        assertFalse(gg_24.isValidMove(2, 6, taulell_aux_w.MockBoardW), "permet moviments dobles");
        assertFalse(gg_24.isValidMove(0, 4, taulell_aux_w.MockBoardW), "permet moviments dobles");

        Piece gg_54 = taulell_aux_w.getPiece(5,4);
        assertTrue(gg_54.isValidMove(6, 5, taulell_aux_w.MockBoardW), "no permet menjar");
        assertFalse(gg_54.isValidMove(5, 5, taulell_aux_w.MockBoardW), "permet menjar blanques");

        MockBoardB taulell_aux_b = new MockBoardB();
        Piece gg_00B = taulell_aux_b.getPiece(0,0);
        assertFalse(gg_00B.isValidMove(-1, -1, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(gg_00B.isValidMove(1, -1, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(gg_00B.isValidMove(-1, 1, taulell_aux_b.MockBoardB), "es mou fora taulell");

        Piece gg_88B = taulell_aux_b.getPiece(8,8);
        assertFalse(gg_88B.isValidMove(8, 9, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(gg_88B.isValidMove(9, 9, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(gg_88B.isValidMove(7, 9, taulell_aux_b.MockBoardB), "es mou fora taulell");

        Piece gg_24B = taulell_aux_b.getPiece(2,4);
        assertTrue(gg_24B.isValidMove(1, 4, taulell_aux_b.MockBoardB), "no permet moviment correcte");
        assertTrue(gg_24B.isValidMove(2, 5, taulell_aux_b.MockBoardB), "no permet moviment cap abaix");
        assertTrue(gg_24B.isValidMove(1, 3, taulell_aux_b.MockBoardB), "no permet moviment correcte");
        assertFalse(gg_24B.isValidMove(2, 6, taulell_aux_b.MockBoardB), "permet moviments dobles");
        assertFalse(gg_24B.isValidMove(1, 2, taulell_aux_b.MockBoardB), "permet moviments dobles");

        Piece gg_54B = taulell_aux_b.getPiece(5,4);
        assertTrue(gg_54B.isValidMove(6, 3, taulell_aux_b.MockBoardB), "no permet menjar");
        assertFalse(gg_54B.isValidMove(5, 5, taulell_aux_b.MockBoardB), "permet menjar blanques");
    }
}
