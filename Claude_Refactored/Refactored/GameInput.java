// GameInput.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameInput {
    private BufferedReader reader;

    public GameInput() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getColumnInput() throws IOException {
        while (true) {
            try {
                System.out.print("Enter column (1-7): ");
                String input = reader.readLine();
                int column = Integer.parseInt(input);
                if (column >= 1 && column <= 7) {
                    return column;
                } else {
                    System.out.println("Invalid column. Please choose between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}