import java.util.Scanner;
import java.io.FileReader;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Day_5_Solution {

    private static final String FILE = "Day_5_Input.txt";

    public static void main(String[] args) {
        ArrayList<Line2D.Double> verticalHorizontalList = new ArrayList<Line2D.Double>();
        ArrayList<Line2D.Double> diagonalList = new ArrayList<Line2D.Double>();
        try {
            Scanner sc = new Scanner(new FileReader(FILE));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                line = line.replace(" -> ", ",");
                String[] token = line.split(",");
                Line2D.Double l1 = new Line2D.Double();
                l1.setLine(Double.parseDouble(token[0]), Double.parseDouble(token[1]), Double.parseDouble(token[2]), Double.parseDouble(token[3]));
                if(l1.getX1() == l1.getX2() || l1.getY1() == l1.getY2()){
                    verticalHorizontalList.add(l1);
                }else{
                    diagonalList.add(l1);
                }
            }
        }catch(Exception e){
        }
        int count = 0;
        int y1 = -1, y2 = -1;
        int x1 = -1, x2 = -1;
        for(int i = 0; i < verticalHorizontalList.size(); i++){
            for(int j = i+1; j < verticalHorizontalList.size(); j++){
                if(verticalHorizontalList.get(i).intersectsLine(verticalHorizontalList.get(j))){
                    y1 = -1;
                    y2 = -1;
                    x1 = -1;
                    x2 = -1;
                    if(verticalHorizontalList.get(i).getX1() == verticalHorizontalList.get(j).getX1() && verticalHorizontalList.get(i).getX2() == verticalHorizontalList.get(j).getX2()){ //vertical
                        if(verticalHorizontalList.get(i).getY1() >= verticalHorizontalList.get(j).getY1() && verticalHorizontalList.get(i).getY1() <= verticalHorizontalList.get(j).getY2()){
                            y1 = (int)verticalHorizontalList.get(i).getY1();
                            System.out.println("y1 : " + y1);
                        }else if(verticalHorizontalList.get(j).getY1() >= verticalHorizontalList.get(i).getY1() && verticalHorizontalList.get(j).getY1() <= verticalHorizontalList.get(i).getY2()){
                            y1 = (int)verticalHorizontalList.get(j).getY1();
                            System.out.println("y1 : " + y1);
                        }
                        if(verticalHorizontalList.get(i).getY2() >= verticalHorizontalList.get(j).getY1() && verticalHorizontalList.get(i).getY2() <= verticalHorizontalList.get(j).getY2()){
                            y2 = (int)verticalHorizontalList.get(i).getY2();
                            System.out.println("y2 : " + y2);
                        }else if(verticalHorizontalList.get(j).getY2() >= verticalHorizontalList.get(i).getY1() && verticalHorizontalList.get(j).getY2() <= verticalHorizontalList.get(i).getY2()){
                            y2 = (int)verticalHorizontalList.get(j).getY2();
                            System.out.println("y2 : " + y2);
                        }
                    }else if(verticalHorizontalList.get(i).getY1() == verticalHorizontalList.get(j).getY1() && verticalHorizontalList.get(i).getY2() == verticalHorizontalList.get(j).getY2()){ //horizontal
                        if(verticalHorizontalList.get(i).getX1() >= verticalHorizontalList.get(j).getX1() && verticalHorizontalList.get(i).getX1() <= verticalHorizontalList.get(j).getX2()){
                            x1 = (int)verticalHorizontalList.get(i).getX1();
                            System.out.println("x1 : " + x1);
                        }else if(verticalHorizontalList.get(j).getX1() >= verticalHorizontalList.get(i).getX1() && verticalHorizontalList.get(j).getX1() <= verticalHorizontalList.get(i).getX2()){
                            x1 = (int)verticalHorizontalList.get(j).getX1();
                            System.out.println("x1 : " + x1);
                        }
                        if(verticalHorizontalList.get(i).getX2() >= verticalHorizontalList.get(j).getX1() && verticalHorizontalList.get(i).getX2() <= verticalHorizontalList.get(j).getX2()){
                            x2 = (int)verticalHorizontalList.get(i).getX2();
                            System.out.println("x2 : " + x2);
                        }else if(verticalHorizontalList.get(j).getX2() >= verticalHorizontalList.get(i).getX1() && verticalHorizontalList.get(j).getX2() <= verticalHorizontalList.get(i).getX2()){
                            x2 = (int)verticalHorizontalList.get(j).getX2();
                            System.out.println("x2 : " + x2);
                        }
                    }
                    if(x1 != -1 && x2 != -1){
                        count += Math.abs(x1-x2) + 1;
                    }else if(y1 != -1 && y2 != -1){
                        count += Math.abs(y1-y2) + 1;
                    }else{
                        count++;
                    }
                }
            }
        }
        System.out.println("count: " + count);
    }
}
