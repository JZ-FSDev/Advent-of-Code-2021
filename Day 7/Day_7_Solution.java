import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Day_7_Solution {
    private static final String FILE = "Day_7_Input.txt";

    /*
        Parses through input file to get initial crab positions then finds the most optimal position horizontally to
        orient the crabs to ensure the lowest fuel spent.
    */
    public static void main(String[] args) {
        ArrayList<Integer> pos = new ArrayList<Integer>();

        int lowest = 0, highest = -1;

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
        System.out.println("Lowest Fuel: " + lowestFuel);
    }
}
