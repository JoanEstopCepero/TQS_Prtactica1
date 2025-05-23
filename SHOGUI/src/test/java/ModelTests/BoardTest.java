package ModelTests;

import Model.Piece;
import Model.pieces.Pawn;
import Model.pieces.Rook;
import Model.pieces.King;
import Model.Board;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BoardTest {

    @Test
    void testConstructorBoard() {
        Board tauler = new Board();
        assertEquals("L", tauler.getPiece(0, 0).getName(), "fitxa incorrecte");
        assertEquals("L", tauler.getPiece(8, 8).getName(), "fitxa incorrecte");
        assertEquals("N", tauler.getPiece(1, 0).getName(), "fitxa incorrecte");
        assertEquals("N", tauler.getPiece(7, 0).getName(), "fitxa incorrecte");
        assertEquals("S", tauler.getPiece(2, 0).getName(), "fitxa incorrecte");
        assertEquals("S", tauler.getPiece(6, 0).getName(), "fitxa incorrecte");
        assertEquals("G", tauler.getPiece(3, 0).getName(), "fitxa incorrecte");
        assertEquals("G", tauler.getPiece(5, 0).getName(), "fitxa incorrecte");
        assertEquals("K", tauler.getPiece(4, 0).getName(), "fitxa incorrecte");
        assertEquals("R", tauler.getPiece(1, 1).getName(), "fitxa incorrecte");
        assertEquals("B", tauler.getPiece(7, 1).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(0, 2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(1, 2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(2, 2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(3, 2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(4, 2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(5, 2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(6, 2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(7, 2).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(8, 2).getName(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(0, 0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(1, 0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(2, 0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(3, 0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(4, 0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(5, 0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(6, 0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(7, 0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(8, 0).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(7, 1).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(1, 1).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(4, 2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(8, 2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(7, 2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(6, 2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(5, 2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(4, 2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(3, 2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(2, 2).isWhite(), "fitxa incorrecte");
        assertTrue(tauler.getPiece(1, 2).isWhite(), "fitxa incorrecte");


        assertEquals("L", tauler.getPiece(0, 8).getName(), "fitxa incorrecte");
        assertEquals("L", tauler.getPiece(8, 8).getName(), "fitxa incorrecte");
        assertEquals("N", tauler.getPiece(1, 8).getName(), "fitxa incorrecte");
        assertEquals("N", tauler.getPiece(7, 8).getName(), "fitxa incorrecte");
        assertEquals("S", tauler.getPiece(2, 8).getName(), "fitxa incorrecte");
        assertEquals("S", tauler.getPiece(6, 8).getName(), "fitxa incorrecte");
        assertEquals("G", tauler.getPiece(3, 8).getName(), "fitxa incorrecte");
        assertEquals("G", tauler.getPiece(5, 8).getName(), "fitxa incorrecte");
        assertEquals("K", tauler.getPiece(4, 8).getName(), "fitxa incorrecte");
        assertEquals("R", tauler.getPiece(1, 7).getName(), "fitxa incorrecte");
        assertEquals("B", tauler.getPiece(7, 7).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(0, 6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(1, 6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(2, 6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(3, 6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(4, 6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(5, 6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(6, 6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(7, 6).getName(), "fitxa incorrecte");
        assertEquals("P", tauler.getPiece(8, 6).getName(), "fitxa incorrecte");

        assertFalse(tauler.getPiece(0, 8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(1, 8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(2, 8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(3, 8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(4, 8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(5, 8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(6, 8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(7, 8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(8, 8).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(7, 7).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(1, 7).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(4, 6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(8, 6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(7, 6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(6, 6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(5, 6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(4, 6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(3, 6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(2, 6).isWhite(), "fitxa incorrecte");
        assertFalse(tauler.getPiece(1, 6).isWhite(), "fitxa incorrecte");
    }

    @Test
    void testMovePiece() {
        Board tauler = new Board();
        assertTrue(tauler.movePiece(0, 0, 0, 1), "no permet moviment correcte");
        assertTrue(tauler.movePiece(1, 1, 5, 1), "no permet moviment correcte");
        assertTrue(tauler.movePiece(5, 2, 5, 3), "no permet moviment correcte");

        assertFalse(tauler.movePiece(0, 0, 0, 3), "permet moviment incorrecte");
        assertFalse(tauler.movePiece(2, 2, 2, 5), "permet moviment incorrecte");
        assertFalse(tauler.movePiece(7, 0, 6, 2), "permet moviment incorrecte");

        assertTrue(tauler.movePiece(8, 8, 8, 7), "no permet moviment correcte");
        assertTrue(tauler.movePiece(2, 6, 2, 5), "no permet moviment correcte");
        assertTrue(tauler.movePiece(4, 8, 4, 7), "no permet moviment correcte");

        assertFalse(tauler.movePiece(0, 8, 0, 3), "permet moviment incorrecte");
        assertFalse(tauler.movePiece(4, 8, 4, 9), "permet moviment incorrecte");
        assertFalse(tauler.movePiece(7, 7, 5, 5), "permet moviment incorrecte");
    }


    @Test
    void testDisplayBoard() {
        Board tauler = new Board();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tauler.displayBoard();

        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("WL WN WS WG WK WG WS WN WL \n"); // Primera fila con WR (White Rook)
        expectedOutput.append(". WR . . . . . WB . \n");
        expectedOutput.append("WP WP WP WP WP WP WP WP WP \n"); // Torre blanca en (2, 2)
        expectedOutput.append(". . . . . . . . . \n");
        expectedOutput.append(". . . . . . . . . \n");
        expectedOutput.append(". . . . . . . . . \n"); // Peón blanco y torre negra
        expectedOutput.append("BP BP BP BP BP BP BP BP BP \n");
        expectedOutput.append(". BR . . . . . BB . \n");
        expectedOutput.append("BL BN BS BG BK BG BS BN BL \n"); // Torre negra en (8, 8)

        String[] expectedLines = expectedOutput.toString().split("\n");
        String[] actualLines = outContent.toString().split("\n");

        assertEquals(expectedLines.length, actualLines.length, "El número de líneas no coincide");

        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i].trim(), actualLines[i].trim(), "Línea " + (i + 1) + " no coincide");
        }

        System.setOut(System.out);

    }

    @Test
    void testFindKing() {
        Board tauler = new Board();
        assertArrayEquals(new int[]{4, 0}, tauler.findKing(true), "no troba al rei blanc");
        assertArrayEquals(new int[]{4, 8}, tauler.findKing(false), "no troba al rei negre");

        tauler.board[4][0] = null;
        int[] position = tauler.findKing(true);
        assertNull(position);

        tauler.board[4][8] = null;
        int[] position2 = tauler.findKing(false);
        assertNull(position2);
    }

    @Test
    public void testKingInCheck() {
        Board tauler = new Board();
        tauler.cleanBoard();
        Rook whiteRook = new Rook(0, 0, true);
        Rook blackRook = new Rook(8, 8, false);
        King whiteKing = new King(4, 0, true);
        King blackKing = new King(4, 8, false);

        tauler.board[4][0] = whiteKing;
        tauler.board[0][0] = whiteRook;
        tauler.board[4][8] = blackKing;
        tauler.board[8][8] = blackRook;
        assertFalse(tauler.isKingInCheck(true), "detecta hake quan no n'hi ha");
        assertFalse(tauler.isKingInCheck(false), "detecta hake quan no n'hi ha");

        Rook whiteRook2 = new Rook(8, 8, true);
        Rook blackRook2 = new Rook(0, 0, false);
        tauler.board[0][0] = blackRook2;
        tauler.board[8][8] = whiteRook2;
        assertTrue(tauler.isKingInCheck(true), "no detecta hake");
        assertTrue(tauler.isKingInCheck(false), "no detecta hake");
    }


    @Test
    public void testKingInCheckMate() {
        Board tauler = new Board();
        tauler.cleanBoard();
        Rook whiteRook = new Rook(4, 5, true);
        Rook blackRook = new Rook(4, 4, false);
        King whiteKing = new King(4, 0, true);
        King blackKing = new King(4, 8, false);
        Pawn pawn50 = new Pawn(5, 0, true);
        Pawn pawn30 = new Pawn(3, 0, true);
        Pawn pawn51 = new Pawn(5, 1, true);
        Pawn pawn31 = new Pawn(3, 1, true);

        Pawn pawn58 = new Pawn(5, 8, false);
        Pawn pawn38 = new Pawn(3, 8, false);
        Pawn pawn57 = new Pawn(5, 7, false);
        Pawn pawn37 = new Pawn(3, 7, false);


        tauler.board[4][0] = whiteKing;
        tauler.board[4][5] = whiteRook;
        tauler.board[4][8] = blackKing;
        tauler.board[4][4] = blackRook;
        tauler.board[5][0] = pawn50;
        tauler.board[3][0] = pawn30;
        tauler.board[5][8] = pawn58;
        tauler.board[3][8] = pawn38;

        assertFalse(tauler.isKingInCheckmate(true), "detecta hake mate quan no n'hi ha");
        assertFalse(tauler.isKingInCheckmate(false), "detecta hake mate quan no n'hi ha");

        tauler.board[5][1] = pawn51;
        tauler.board[3][1] = pawn31;
        tauler.board[5][7] = pawn57;
        tauler.board[3][7] = pawn37;
        assertTrue(tauler.isKingInCheckmate(true), "no detecta mate hake");
        assertTrue(tauler.isKingInCheckmate(false), "no detecta mate hake");
    }


}
