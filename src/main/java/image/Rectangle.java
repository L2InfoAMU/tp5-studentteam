package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape {

    Point downLeft;
    List<Point> point;
    int width;
    int height;
    Color color;

    public Rectangle(int x, int y, int width, int height, Color color)
    {
        this.downLeft = new Point(x, y);
        point = new ArrayList<>();
        for(int i = downLeft.x ; i<=downLeft.x+width-1;i++)
        {
            for(int j = downLeft.y-(height-1);j<=downLeft.y;j++)
                point.add(new Point(i, j));
        }
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
