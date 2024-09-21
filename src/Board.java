public class Board {
    private char[][] board;

    // Constructor initializes a 3x3 board
    public Board() {
        board = new char[3][3];
        initializeBoard();
    }

    // Method to initialize the board with empty spaces
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Method to print the current board state
    public void printBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to check if a position is available
    public boolean isPositionAvailable(int row, int col) {
        return board[row][col] == '-';
    }

    // Method to place a player's mark on the board
    public void placeMark(int row, int col, char mark) {
        if (isPositionAvailable(row, col)) {
            board[row][col] = mark;
        }
    }

    // Method to check for a winner after every move
    public boolean checkWinner(char mark) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) ||
                    (board[0][i] == mark && board[1][i] == mark && board[2][i] == mark)) {
                return true;
            }
        }
        // Check diagonals
        return (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) ||
                (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark);
    }

    // Method to check if the board is full (i.e., draw)
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
