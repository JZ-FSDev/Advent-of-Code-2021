import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;

public class Day_3_Solution {

    private static final String FILE = "Day_3_Input.txt";
    private static final int NUMBER_LENGTH = 12;

    public static void main(String[] args) {
        System.out.println("Part 1 Output: " + partOne() + "  " + "Part 2 Output: " + partTwo());
    }

    /*
     * Multiplies the bit number acquired by finding the most (gamma) and least
     * (epsilon) single bit from the left most digit
     * and repeating leftwards until a full length bit number is achieved. This
     * number is then converted into decimal before being multiplied together.
     */
    public static int partOne() {
        String gammaRate = "", epsilonRate = "";
        int[] zeroes = new int[NUMBER_LENGTH], ones = new int[NUMBER_LENGTH];
        try {
            Scanner sc = new Scanner(new FileReader(FILE));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if (Character.getNumericValue(line.charAt(i)) == 0) {
                        zeroes[i]++;
                    } else {
                        ones[i]++;
                    }
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (zeroes[i] > ones[i]) {
                gammaRate += "0";
                epsilonRate += "1";
            } else {
                gammaRate += "1";
                epsilonRate += "0";
            }
        }
        return Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2);
    }

    /*
     * Does the same thing from the first part of the question except the most
     * common and least common bits of each digit of each number is removed as each
     * digit is processed if the criteria is not met for each rating.
     */
    public static int partTwo() {
        ArrayList<String> oxygenRating = new ArrayList<String>(), carbonRating = new ArrayList<String>();
        int[] zeroes = new int[NUMBER_LENGTH], ones = new int[NUMBER_LENGTH];
        try {
            Scanner sc = new Scanner(new FileReader(FILE));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                oxygenRating.add(line);
                carbonRating.add(line);
                for (int i = 0; i < NUMBER_LENGTH; i++) {
                    if (Character.getNumericValue(line.charAt(i)) == 0) {
                        zeroes[i]++;
                    } else {
                        ones[i]++;
                    }
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (int j = 0; j < NUMBER_LENGTH; j++) {
            int oxygenOne = 0, oxygenZero = 0;
            int carbonOne = 0, carbonZero = 0;
            for (int i = 0; i < oxygenRating.size(); i++) {
                if (Character.getNumericValue(oxygenRating.get(i).charAt(j)) == 0) {
                    oxygenZero++;
                } else {
                    oxygenOne++;
                }
            }
            for (int i = 0; i < carbonRating.size(); i++) {
                if (Character.getNumericValue(carbonRating.get(i).charAt(j)) == 0) {
                    carbonZero++;
                } else {
                    carbonOne++;
                }
            }
            for (int k = 0; k < oxygenRating.size(); k++) {
                if (oxygenRating.size() > 1 && oxygenZero > oxygenOne
                        && Character.getNumericValue(oxygenRating.get(k).charAt(j)) == 1) {
                    oxygenRating.remove(k--);
                } else if (oxygenRating.size() > 1 && (oxygenZero == oxygenOne || oxygenZero < oxygenOne)
                        && Character.getNumericValue(oxygenRating.get(k).charAt(j)) == 0) {
                    oxygenRating.remove(k--);
                }
            }
            for (int k = 0; k < carbonRating.size(); k++) {
                if (carbonRating.size() > 1 && carbonOne < carbonZero
                        && Character.getNumericValue(carbonRating.get(k).charAt(j)) == 0) {
                    carbonRating.remove(k--);
                } else if (carbonRating.size() > 1 && (carbonZero == carbonOne || carbonOne > carbonZero)
                        && Character.getNumericValue(carbonRating.get(k).charAt(j)) == 1) {
                    carbonRating.remove(k--);
                }
            }

        }
        return Integer.parseInt(oxygenRating.get(0), 2) * Integer.parseInt(carbonRating.get(0), 2);
    }
}
