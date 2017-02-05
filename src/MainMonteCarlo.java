import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by ekaterina on 01.02.17.
 */
public class MainMonteCarlo {


    public static void main(String[] args) {
        double oldArea = 0.0;
        double newArea = 0.0;


        Polygon polygon = new Polygon();//Figure area of what will be counted
        Polygon square = new Polygon();//Square around figure

        readPolygon(polygon);//Read settings of figure from "input.txt"
        generateSquare(square, polygon);//Draw square around it


//        System.out.println("Minimum X: " + polygon.getMinimumX() + " Maximum X: " + polygon.getMaximumX());
//        System.out.println("Minimum Y: " + polygon.getMinimumY() + " Maximum Y: " + polygon.getMaximumY());

        Random random = new Random();

        int numberOfIntersections = 0;
        int insidePoints = 0;
        int totalNumberOfPoints = 0;

        while (true) {
            //Generate new Random point
            Point point = new Point(polygon.getMinimumX() + (polygon.getMaximumX() - polygon.getMinimumX()) * random.nextDouble(),
                    polygon.getMinimumY() + (polygon.getMaximumY() - polygon.getMinimumY()) * random.nextDouble());

            //If that new button is in the Figure then +1 to inside points
            if (isInside(point, polygon)) insidePoints++;
            totalNumberOfPoints++;

            //New area of polygon counted with newly generated point
            newArea = ((float) insidePoints / totalNumberOfPoints) * area(square);

//            System.out.println("New Area: " + newArea);
//            System.out.println("Old Area: " + oldArea);
//            System.out.println("Delta: " + (newArea - oldArea) + " T/F: " + (newArea - oldArea < 0.0001));

            if ((Math.abs(newArea - oldArea) < 0.0001) && (totalNumberOfPoints >= 20))
                break;

            oldArea = newArea;
        }

        System.out.println(newArea);

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new File("output.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        printWriter.write(String.format("%.2f", newArea).replace(",", "."));
        printWriter.close();

    }

    private static void generateSquare(Polygon square, Polygon polygon) {
        square.add(new Point(polygon.getMinimumX(), polygon.getMinimumY()));
        square.add(new Point(polygon.getMinimumX(), polygon.getMaximumY()));
        square.add(new Point(polygon.getMaximumX(), polygon.getMinimumY()));
        square.add(new Point(polygon.getMaximumX(), polygon.getMaximumY()));
    }

    private static void readPolygon(Polygon polygon) {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {

        }


        String[] doubleArray = scanner.nextLine().split(" ");
        for (int i = 0; i < doubleArray.length; i += 2) {
            polygon.add(new Point(Double.valueOf(doubleArray[i]), Double.valueOf(doubleArray[i + 1])));
        }
    }

    private static double area(Polygon rect) {
        double a = rect.getMaximumX() - rect.getMinimumX();
        double b = rect.getMaximumY() - rect.getMinimumY();

        return a * b;
    }

    public static boolean intersects(Section sectionOne, Section sectionTwo) {
        Point a = sectionOne.get(0);
        Point b = sectionOne.get(1);
        Point c = sectionTwo.get(0);
        Point d = sectionTwo.get(1);
        // We describe the section AB as A+(B-A)*u and CD as C+(D-C)*v
        // then we solve A + (B-A)*u = C + (D-C)*v
        // let's use Kramer's rule to solve the task (Ax = B) were x = (u, v)^T
        // build a matrix for the equation
        double[][] A = new double[2][2];
        A[0][0] = b.getX() - a.getX();
        A[1][0] = b.getY() - a.getY();
        A[0][1] = c.getX() - d.getX();
        A[1][1] = c.getY() - d.getY();
        // calculate determinant
        double det0 = A[0][0] * A[1][1] - A[1][0] * A[0][1];
        // substitute columns and calculate determinants
        double detU = (c.getX() - a.getX()) * A[1][1] - (c.getY() - a.getY()) * A[0][1];
        double detV = A[0][0] * (c.getY() - a.getY()) - A[1][0] * (c.getX() - a.getX());
        // calculate the solution
        // even if det0 == 0 (they are parallel) this will return NaN and comparison will fail -> false
        double u = detU / det0;
        double v = detV / det0;
        return u > 0 && u < 1 && v > 0 && v < 1;
    }


    /**
     * Few tests and vote method to know which
     *
     * @param point   that will be checked
     * @param polygon in what point will be checked
     * @return
     */
    private static boolean isInside(Point point, Polygon polygon) {
        int inside = 0;
        int outside = 0;

        Section section = new Section();
        section.add(point, 0);

        //First attempt
        section.add(new Point(polygon.getMinimumX(), polygon.getMinimumY()), 1);

        if (isInside(section, polygon)) inside++;
        else outside++;

        //Second attempt
        section.add(new Point(polygon.getMaximumX(), polygon.getMaximumY()), 1);

        if (isInside(section, polygon)) inside++;
        else outside++;

        //Third attempt
        section.add(new Point(polygon.getMinimumX(), polygon.getMaximumY()), 1);

        if (isInside(section, polygon)) inside++;
        else outside++;

        //Fourth attempt
        section.add(new Point(polygon.getMaximumX(), polygon.getMinimumY()), 1);

        if (isInside(section, polygon)) inside++;
        else outside++;

        //Fifth attempt
        section.add(new Point(polygon.getMinimumX(), polygon.getMinimumY() + (polygon.getMaximumY() - polygon.getMinimumY()) / 2), 1);

        if (isInside(section, polygon)) inside++;
        else outside++;

        //Sixth attempt
        section.add(new Point(polygon.getMinimumX() + (polygon.getMaximumX()-polygon.getMinimumX())/2, polygon.getMinimumY()), 1);

        if (isInside(section, polygon)) inside++;
        else outside++;

        //Fifth attempt
        section.add(new Point(polygon.getMaximumX(), polygon.getMinimumY() + (polygon.getMaximumY() - polygon.getMinimumY()) / 2), 1);

        if (isInside(section, polygon)) inside++;
        else outside++;
//
//        //Sixth attempt
//        section.add(new Point(polygon.getMinimumX() + (polygon.getMaximumX()-polygon.getMinimumX())/2, polygon.getMaximumY()), 1);
//
//        if (isInside(section, polygon)) inside++;
//        else outside++;

        return inside > outside;
    }


    private static boolean isInside(Section section, Polygon polygon) {
        Section first = polygon.getSection();
        Section test = first;

        int numberOfIntersections = 0;

        do {
            if (intersects(test, section)) {
                numberOfIntersections++;
            }
            test = polygon.getSection();
        } while (!first.equals(test));

        return numberOfIntersections % 2 == 0;

    }

}
