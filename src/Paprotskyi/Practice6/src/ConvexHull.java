import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class ConvexHull {

    // public static String testFile="test.txt";
    // public static String testFile="input6.txt";
    // public static String testFile="input40.txt";
    // public static String testFile="input8.txt";
    // public static String testFile="input50.txt";
    // public static String testFile="input56.txt";
    // public static String testFile="input100.txt";
    //public static String testFile="input400.txt";
     public static String testFile="rs1423.txt";
    // public static String testFile="grid6x6.txt";
    // public static String testFile="horizontal100.txt";



    public static Point2D[] points;

    public static void main(String[] args) throws FileNotFoundException {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(testFile));
        System.setIn(in);
        int n = StdIn.readInt();
        points = new Point2D[n];

        double min=Integer.MAX_VALUE,minI=0;

        int i=0;
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            int y = StdIn.readInt();
            points[i++] = new Point2D(x, y);
            points[i-1].draw();
            if(points[i-1].getY()<min){
                min=points[i-1].getY();
                minI=i-1;
            }
            System.out.println(points[i-1].toString());
        }

        Point2D tmp = points[(int) minI];
        points[(int)minI]=points[0];
        points[0]=tmp;

        PointCheck pc = new PointCheck(points);

        for (i = 0; i < n; i++)
          points[i].draw();

        for (Point2D p : pc.hull())
            p.draw();


        Point2D prev = null;
        for (Point2D p : pc.hull()) {
            if (prev != null) prev.drawTo(p);
            prev = p;
        }

        for (Point2D p : pc.hull()) {
            prev.drawTo(p);
            break;
        }
    }
}
