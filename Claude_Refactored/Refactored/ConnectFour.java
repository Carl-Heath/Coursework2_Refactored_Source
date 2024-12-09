// ConnectFour.java
public class ConnectFour {
    private GameBoard board;
    private GameInput input;
    private Player[] players;
    private int currentPlayerIndex;

    public ConnectFour() {
        board = new GameBoard();
        input = new GameInput();
        players = new Player[]{
            new Player("Player 1 (Red)", 'r'),
            new Player("Player 2 (Yellow)", 'y')
        };
        currentPlayerIndex = 0;
    }

    public void playGame() {
        printGameInstructions();
        board.printBoard();

        while (true) {
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println(currentPlayer.getName() + "'s turn");

            try {
                int column = input.getColumnInput();
                
                if (board.placeCounter(currentPlayer.getSymbol(), column)) {
                    board.printBoard();

                    if (board.checkWin(currentPlayer.getSymbol())) {
                        System.out.println(currentPlayer.getName() + " Wins!!!");
                        break;
                    }

                    // Switch players
                    currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
                } else {
                    System.out.println("Column is full. Try another column.");
                }
            } catch (IOException e) {
                System.out.println("Error reading input. Please try again.");
            }
        }
    }

    private void printGameInstructions() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players: Red and Yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play, type the number of the column (1-7) to drop your counter");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println();
    }

    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        game.playGame();
    }
}
