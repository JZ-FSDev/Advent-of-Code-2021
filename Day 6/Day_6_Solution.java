import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;

public class Day_6_Solution {

    private static final String FILE = "Day_6_Input.txt";
    private static final int DAYS = 256;

    /*
        Parses through input file to get initial fish population data then applies exponential growth
        based on DAYS constant to determine the final population after that many days have passed
    */
    public static void main(String[] args) {
        ArrayList<Fish> fish = new ArrayList<Fish>();
        for (int i = 0; i < 9; i++) {
            fish.add(new Fish());
        }

        int one = 0, two = 0, three = 0, four = 0, five = 0;
        try {
            Scanner sc = new Scanner(new FileReader(FILE));
            String line = sc.nextLine();
            sc = new Scanner(line);
            sc.useDelimiter(",");
            while (sc.hasNextInt()) {
                int temp = sc.nextInt();
                if (temp == 1) {
                    one++;
                } else if (temp == 2) {
                    two++;
                } else if (temp == 3) {
                    three++;
                } else if (temp == 4) {
                    four++;
                } else if (temp == 5) {
                    five++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        fish.get(1).setPopulation(one);
        fish.get(2).setPopulation(two);
        fish.get(3).setPopulation(three);
        fish.get(4).setPopulation(four);
        fish.get(5).setPopulation(five);


        for (int i = 0; i < DAYS; i++) {
            long holder = fish.get(0).getPopulation();
            for (int j = 0; j < fish.size()-1; j++) {
                fish.get(j).setPopulation(fish.get(j+1).getPopulation());
            }
            fish.get(6).increasePopulation(holder); 
            fish.get(fish.size()-1).setPopulation(0);
            fish.get(fish.size()-1).increasePopulation(holder);
        }

        long count = 0;
        for(Fish f: fish){
            count += f.getPopulation();
        }
        System.out.println("Total Population: " + count);
    }
}
