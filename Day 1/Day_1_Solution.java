import java.util.Scanner;
import java.io.FileReader;

public class Day_1_Solution {

    private static final String FILE = "Day_1_Input.txt";

    public static void main(String[] args) {
        System.out.println("Part 1 Output: " + partOne() + "  " + "Part 2 Output: " + partTwo());
    }

    /*
        Compares the next int to the previously read int and if it is larger, increments a counter to keep track of
        how many times it occurs in the entire input file.
    */
    public static int partOne(){
        int num = 0;
        try {
            Scanner sc = new Scanner(new FileReader(FILE));
            int prev = sc.nextInt(), current = 0;
            while (sc.hasNextInt()) {
                current = sc.nextInt();
                if (current > prev) {
                    num++;
                }
                prev = current;
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return num;
    }


    /*
        Compares the the sum of three consecutive ints with the next sum of three consecutive ints and if it is larger, 
        increments a counter to keep track of how many times it occurs in the entire input file.
    */
    public static int partTwo(){
        int num = 0;
        try {
            Scanner sc = new Scanner(new FileReader(FILE));
            int trio[] = new int[3];
            trio[0] = sc.nextInt();
            trio[1] = sc.nextInt();
            trio[2] = sc.nextInt();
            while (sc.hasNextInt()) {
                int next = sc.nextInt();
                int currentTrio = trio[0] + trio[1] + trio[2];
                int nextTrio = currentTrio - trio[0] + next;
                if(currentTrio < nextTrio){
                    num++;
                }
                trio[0] = trio[1];
                trio[1] = trio[2];
                trio[2] = next;
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return num;
    }
}
