package image;

import javafx.scene.paint.Color;

public class Triangle implements Shape {

    Point point;
    int width, height;
    Color color;

    public Triangle (int x, int y, int width, int height, Color color)
    {
        this.point = new Point(x, y);
        this.width = width; this.height = height;
        this.color = color;
    }

    /**
     * @param point
     * @return true if point is contain in triangle, false otherwise
     */
    @Override
    public boolean contains(Point point) {
        Point A = new Point(this.point.x, this.point.y-height);
        Point B = new Point(this.point.x+width, this.point.y);
        double areaTriangle = Math.abs(this.point.x*(A.y-B.y)+A.x*(B.y-this.point.y)+B.x*(this.point.y - A.y));
        double areaOAP = Math.abs(this.point.x * (A.y - point.y)+ A.x*(point.y-this.point.y)+point.x*(this.point.y-A.y));
        double areaOPB = Math.abs(this.point.x * (point.y-B.y)+point.x*(B.y-this.point.y)+B.x*(this.point.y - point.y));
        double areaPAB = Math.abs(point.x*(A.y-B.y) + A.x*(B.y-point.y)+B.x*(point.y-A.y));
        return areaOAP+areaOPB+areaPAB == areaTriangle;
    }

    /**
     * @return triangle color
     */
    @Override
    public Color getColor() {
        return color;
    }
}
