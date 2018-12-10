package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape {

    Point upperLeft;
    int width;
    int height;
    Color color;

    public Rectangle(int x, int y, int width, int height, Color color)
    {
        this.upperLeft = new Point(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     *
     * @param point
     * @return true if point is contain in rectangle, false otherwise
     */
    @Override
    public boolean contains(Point point) {
        return point.x>=upperLeft.x && point.x<=upperLeft.x+(width-1) &&
                point.y>=upperLeft.y && point.y<=upperLeft.y+(height-1);
    }

    /**
     *
     * @return rectangle color
     */
    @Override
    public Color getColor() {
        return color;
    }
}
