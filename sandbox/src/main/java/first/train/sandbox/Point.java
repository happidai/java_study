package first.train.sandbox;

import static jdk.nashorn.internal.objects.NativeMath.sqrt;


public class Point {

    public double x;
    public double y;


    public Point(double x, double y) {
        this.x = x;
        this.y = y;

    }

    public double distance(Point p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);

    }

}