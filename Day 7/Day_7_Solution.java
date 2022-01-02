import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;

public class Day_7_Solution {

    private static final String FILE = "Day_7_Input.txt";
    private static int lowest = 0, highest = -1;
    private static ArrayList<Integer> pos = new ArrayList<Integer>();

    /*
        Parses through input file to get initial crab positions then finds the most optimal position horizontally to
        orient the crabs to ensure the lowest fuel spent for each of the parts.
    */
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new FileReader(FILE));
            String line = sc.nextLine();
            sc = new Scanner(line);
            sc.useDelimiter(",");
            while (sc.hasNextInt()) {
                int token = sc.nextInt();
                if(token < lowest){
                    lowest = token;
                }else if(token > highest){
                    highest = token;
                }
                pos.add(token);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Lowest Fuel Part One: " + partOne() + "  Lowest Fuel Part Two: " + partTwo());
    }

    /*
        Returns the lowest fuel realative to each horizontal position consuming only one fuel
    */
    public static int partOne(){
        int lowestFuel = Integer.MAX_VALUE;
        for(int i = lowest; i < highest; i++){
            int fuel = 0;
            for(int j = 0; j < pos.size(); j++){
                fuel += Math.abs(pos.get(j)-i);
            }
            if(fuel < lowestFuel){
                lowestFuel = fuel;
            }
        }
        return lowestFuel;
    }

    /*
        Returns the lowest fuel realative to each horizontal position consuming one fuel more than the previous
    */
    public static int partTwo(){
        int lowestFuel = Integer.MAX_VALUE;
        for(int i = lowest; i < highest; i++){
            int fuel = 0;
            for(int j = 0; j < pos.size(); j++){
                int difference = (Math.abs(pos.get(j)-i));
                for(int k = 1; k <= difference; k++){
                    fuel += k;
                }
            }
            if(fuel < lowestFuel){
                lowestFuel = fuel;
            }
        }
        return lowestFuel;
    }
}
