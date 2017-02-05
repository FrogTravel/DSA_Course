

/**
 * Created by ekaterina on 01.02.17.
 */
public class Polygon {
    private ArrayList<Point> points;
    int currentIndex;

    public Polygon() {
        points = new ArrayList<>();
    }

    public Section getSection() {
        Section section = new Section();
        if (currentIndex + 1 < points.size()) {
            section.add(points.get(currentIndex), 0);
            section.add(points.get(currentIndex + 1), 1);
            currentIndex++;
        } else {
            section.add(points.get(currentIndex), 0);
            section.add(points.get(0), 1);
            currentIndex = 0;
        }
        return section;
    }

    public void add(Point point) {
        points.add(point);
    }

    public double[] getAllX() {
        double[] number = new double[points.size()];
        for (int i = 0; i < points.size(); i++) {
            number[i] = points.get(i).getX();
        }
        return number;
    }

    public double getMinimumX() {
        double xmin = points.get(0).getX();

        for (int i = 0; i < points.size(); i++) {

            if (points.get(i).getX() < xmin) {
                xmin = points.get(i).getX();
            }
        }

        return xmin;
    }

    public double getMaximumX() {
        double xmax = points.get(0).getX();

        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).getX() > xmax) {
                xmax = points.get(i).getX();
            }
        }

        return xmax;
    }

    public double getMinimumY() {
        double ymin = points.get(0).getY();

        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).getY() < ymin) {
                ymin = points.get(i).getY();
            }
        }

        return ymin;
    }

    public double getMaximumY() {
        double ymax = points.get(0).getY();

        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).getY() > ymax) {
                ymax = points.get(i).getY();
            }
        }

        return ymax;
    }

}
