package first.train.sandbox;

import static jdk.nashorn.internal.objects.NativeMath.sqrt;

public class Point {

    public double x;
    public double y;


    public Point(double xpoint, double ypoint) {
        this.x = xpoint;
        this.y = ypoint;

    }

    public static double distance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx*dx + dy*dy);

    }


}
