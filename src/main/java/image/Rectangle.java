package image;

import javafx.scene.paint.Color;

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

    @Override
    public boolean contains(Point point) {
        return point.x>=upperLeft.x && point.x<width &&
                point.y>=upperLeft.y-height-1 && point.y<height;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
