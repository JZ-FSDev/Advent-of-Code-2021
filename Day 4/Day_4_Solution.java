import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;

public class Day_4_Solution {

    private static final String FILE = "Day_4_Input.txt";
    private static final int BOARD_SIZE = 5;
    private static ArrayList<Board> boards;
    private static String[] drawNumbers;
    private static Board firstWinningBoard;
    private static Board lastWinningBoard;

    public static void main(String[] args) {
        System.out.println("Part 1 Output: " + partOne() + "  " + "Part 2 Output: " + partTwo());
    }

    /*
        Generates all boards from parsing through input file
    */
    public static void prepParts() {
        boards = new ArrayList<Board>();
        try {
            Scanner sc = new Scanner(new FileReader(FILE));
            drawNumbers = sc.nextLine().split(",");
            int currentBoard = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.equals("")) {
                    boards.add(new Board(BOARD_SIZE));
                    for (int i = 0; i < BOARD_SIZE; i++) {
                        line = sc.nextLine().trim();
                        boards.get(currentBoard).fillRow(i, line.split("\\s+"));
                    }
                    currentBoard++;
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
        Returns the winning score on the board that achieves bingo first.
        The score is the winning number that caused the bingo multiplied by
        all the uncalled numbers on the board.
    */
    public static int partOne() {
        prepParts();
        boolean gameOver = false;
        int drawPos = 0;
        int winningNumber = -1;
        while (!gameOver && drawPos < drawNumbers.length) {
            for (Board b : boards) {
                b.dab(Integer.parseInt(drawNumbers[drawPos]));
                if (!b.isActive()) {
                    firstWinningBoard = b;
                    gameOver = true;
                    winningNumber = Integer.parseInt(drawNumbers[drawPos]);
                    break;
                }
            }
            if (!gameOver) {
                drawPos++;
            }
        }
        return winningNumber * firstWinningBoard.getUncalledTotal();
    }

    /*
        Returns the winning score of the last board that achieves bingo first.
        The score is the winning number that caused the bingo multiplied by
        all the uncalled numbers on the board.
    */
    public static int partTwo() {
        prepParts();
        int drawPos = 0;
        int winningNumber = -1;
        int boardsWon = 0;
        while (boardsWon < boards.size() && drawPos < drawNumbers.length) {
            for (Board b : boards) {
                if (b.isActive()) {
                    b.dab(Integer.parseInt(drawNumbers[drawPos]));
                    if (!b.isActive()) {
                        boardsWon++;
                        if(boardsWon == boards.size()){
                            lastWinningBoard = b;
                            winningNumber = Integer.parseInt(drawNumbers[drawPos]);
                        }
                    }
                }
            }
            if (boardsWon < boards.size()) {
                drawPos++;
            }
        }
        return winningNumber * lastWinningBoard.getUncalledTotal();
    }
}
