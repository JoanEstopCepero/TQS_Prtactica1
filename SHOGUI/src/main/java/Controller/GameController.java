package Controller;

import Model.Board;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {
    private final Board board;

    public GameController(Board board) {
        this.board = board != null ? board : new Board();
    }

    public GameController() {
        this.board = new Board();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean isWhiteTurn = true;

        while (!board.isGameOver()) {
            board.displayBoard();
            System.out.println((isWhiteTurn ? "White" : "Black") + "'s turn.");
            System.out.print("Enter move (format: x y newX newY) or 'exit' to quit: ");

            String input = scanner.nextLine().trim();

            // Si la entrada es "exit", salimos del bucle y terminamos el juego
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the game...");
                break;
            }

            try {
                // Intentamos leer los números para el movimiento
                String[] parts = input.split(" ");
                if (parts.length != 4) {
                    System.out.println("Invalid input format, please enter 4 numbers.");
                    continue;
                }

                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                int newX = Integer.parseInt(parts[2]);
                int newY = Integer.parseInt(parts[3]);

                // Verificar si la pieza seleccionada es válida
                if (board.getPiece(x, y) != null && board.getPiece(x, y).isWhite() == isWhiteTurn) {
                    if (board.movePiece(x, y, newX, newY)) {
                        boolean opponentInCheck = board.isKingInCheck(!isWhiteTurn);
                        if (opponentInCheck) {
                            System.out.println((isWhiteTurn ? "Black" : "White") + " king is in check!");
                        }
                        board.checkGameOver();
                        if (null == board.findKing(!isWhiteTurn)) {
                            board.gameOver = true;
                        }
                        isWhiteTurn = !isWhiteTurn;
                    } else {
                        System.out.println("Invalid move, try again.");
                    }
                } else {
                    System.out.println("Invalid piece selection, try again.");
                }
            } catch (NumberFormatException e) {
                // Si ocurre una excepción al convertir los números, mostramos un mensaje de error
                System.out.println("Invalid input, please enter valid numbers.");
            }
        }
        System.out.println("Game over. Thanks for playing!");
    }


}
