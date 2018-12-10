package image;

import javafx.scene.paint.Color;

public class Circle implements Shape {

    Point centre;
    int rayon;
    Color color;

    public Circle(int x, int y, int rayon, Color color)
    {
        this.centre = new Point(x, y);
        this.rayon = rayon;
        this.color = color;
    }


    /**
     *
     * @param point
     * @return true if point is contain in circle, false otherwise
     */
    @Override
    public boolean contains(Point point) {
        return Math.sqrt(Math.pow(point.x-this.centre.x, 2.0)
                + Math.pow(point.y-this.centre.y,2))<=this.rayon;
    }

    /**
     *
     * @return circle color
     */
    @Override
    public Color getColor() {
        return this.color;
    }
}
