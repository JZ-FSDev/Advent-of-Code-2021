import java.util.Scanner;
import java.io.FileReader;

public class Day_2_Solution {

    private static final String FILE = "Day_2_Input.txt";

    public static void main(String[] args) {
        System.out.println("Part 1 Output: " + partOne() + "  " + "Part 2 Output: " + partTwo());
    }

    /*
        Returns the horizontal distance multilied by the vertical distance travelled
    */
    public static int partOne() {
        int horizontal = 0, vertical = 0;
        try {
            Scanner sc = new Scanner(new FileReader(FILE));
            String direction = "";
            int value = 0;
            while (sc.hasNextLine()) {
                direction = sc.next();
                value = Integer.parseInt(sc.next());
                if (direction.equals("forward")) {
                    horizontal += value;
                } else if (direction.equals("up")) {
                    vertical -= value;
                } else {
                    vertical += value;
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return horizontal * vertical;
    }

    /*
        Returns aim value based off the influence of vertical and horizontal distance travelled
    */
    public static int partTwo() {
        int horizontal = 0, vertical = 0, aim = 0;
        try {
            Scanner sc = new Scanner(new FileReader(FILE));
            String direction = "";
            int value = 0;
            while (sc.hasNextLine()) {
                direction = sc.next();
                value = Integer.parseInt(sc.next());
                if (direction.equals("forward")) {
                    horizontal += value;
                    vertical += aim * value;
                } else if (direction.equals("up")) {
                    aim -= value;
                } else {
                    aim += value;
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return horizontal * vertical;
    }
}
