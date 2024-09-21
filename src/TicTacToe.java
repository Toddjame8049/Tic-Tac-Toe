import java.util.Scanner;

public class TicTacToe {
    private Board board;
    private char currentPlayer;

    // Constructor initializes the game
    public TicTacToe() {
        board = new Board();
        currentPlayer = 'X'; // X always starts the game
    }

    // Main method to start the game
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }

    // Method to handle the game loop
    public void playGame() {
        boolean isGameRunning = true;
        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (isGameRunning) {
            board.printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row [1-3] and column [1-3]): ");
            int row = scanner.nextInt() - 1;  // Adjust for zero-based index
            int col = scanner.nextInt() - 1;

            if (board.isPositionAvailable(row, col)) {
                board.placeMark(row, col, currentPlayer);

                // Check if the current player has won
                if (board.checkWinner(currentPlayer)) {
                    board.printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    isGameRunning = false;
                }
                // Check if the game is a draw
                else if (board.isBoardFull()) {
                    board.printBoard();
                    System.out.println("The game is a draw!");
                    isGameRunning = false;
                }
                // Switch player and continue the game
                else {
                    switchPlayer();
                }
            } else {
                System.out.println("This position is already taken. Try again.");
            }
        }

        // Ask if the player wants to replay or exit
        System.out.println("Would you like to play again? (yes/no)");
        String response = scanner.next().toLowerCase();
        if (response.equals("yes")) {
            // Reset the game
            board.initializeBoard();
            currentPlayer = 'X';  // X always starts the game
            playGame();  // Start a new game
        } else {
            System.out.println("Thanks for playing!");
        }
        scanner.close();  // Move this line outside of the if-else block
    }

    // Switch between players
    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}

