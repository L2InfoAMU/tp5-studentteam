package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape {

    Point downLeft;
    int width;
    int height;
    Color color;

    public Rectangle(int x, int y, int width, int height, Color color)
    {
        this.downLeft = new Point(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public boolean contains(Point point) {
        return point.x>=downLeft.x && point.x<downLeft.x+(width-1) &&
                point.y>=downLeft.y && point.y<=downLeft.y+(height-1);
    }

    @Override
    public Color getColor() {
        return color;
    }
}
