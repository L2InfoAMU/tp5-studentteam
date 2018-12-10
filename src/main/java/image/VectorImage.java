package image;

import javafx.scene.paint.Color;

import java.util.List;

public class VectorImage extends RasterImage implements Image{

    public VectorImage(List<Shape> shapes, int width, int height) {
        super(shapes, width, height);
    }

    /**
     * @param x
     * @param y
     * @return pixels color at coordinate (x, y)
     */
    @Override
    public Color getPixelColor(int x, int y) {
        for(Shape shape : shapes)
        {
            if(shape.contains(new Point(x, y)))
            {
                return shape.getColor();
            }
        }

        return Color.WHITE;
    }

}
