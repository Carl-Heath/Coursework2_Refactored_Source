// GameBoard.java
public class GameBoard {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private char[][] board;

    public GameBoard() {
        board = new char[ROWS][COLUMNS];
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'r') {
                    System.out.print("| r ");
                } else if (board[i][j] == 'y') {
                    System.out.print("| y ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    public boolean placeCounter(char player, int position) {
        if (position < 1 || position > COLUMNS) {
            return false;
        }

        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][position - 1] == '\u0000') {
                board[i][position - 1] = player;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(char player) {
        return checkHorizontalWin(player) || 
               checkVerticalWin(player) || 
               checkDiagonalWin(player);
    }

    private boolean checkHorizontalWin(char player) {
        for (int row = 0; row < board.length; row++) {
            int count = 0;
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == player) {
                    count++;
                    if (count == 4) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkVerticalWin(char player) {
        for (int col = 0; col < board[0].length; col++) {
            int count = 0;
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] == player) {
                    count++;
                    if (count == 4) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalWin(char player) {
        // Check diagonal wins (both ascending and descending diagonals)
        // This is a simplified version and can be expanded
        for (int row = 0; row < board.length - 3; row++) {
            for (int col = 0; col < board[0].length - 3; col++) {
                // Check descending diagonal
                if (board[row][col] == player &&
                    board[row+1][col+1] == player &&
                    board[row+2][col+2] == player &&
                    board[row+3][col+3] == player) {
                    return true;
                }

                // Check ascending diagonal
                if (board[row+3][col] == player &&
                    board[row+2][col+1] == player &&
                    board[row+1][col+2] == player &&
                    board[row][col+3] == player) {
                    return true;
                }
            }
        }
        return false;
    }
}
