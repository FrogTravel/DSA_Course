/**
* @author ekaterina
*/
public class Section {
    private Point[] points;

    public Section(){
        points = new Point[2];

    }

    public void add(Point point, int index){
        points[index] = point;
    }

    public void add(Point[] points){
        this.points[0] = points[0];
        this.points[1] = points[1];
    }

    public boolean isFull(){
        return ((points[0] != null) && (points[1] != null));
    }

    public Point get(int i) {
        return points[i];
    }

    @Override
    public boolean equals(Object other){
        if(other == null) return false;
        Section section = (Section) other;
        return (section.get(0).getX() == this.get(0).getX()) && (section.get(0).getY() == this.get(0).getY()) &&
                (section.get(1).getX() == this.get(1).getX()) && (section.get(1).getY() == this.get(1).getY());
    }
}
