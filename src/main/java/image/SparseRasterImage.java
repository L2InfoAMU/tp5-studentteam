package image;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class SparseRasterImage extends RasterImage {

    Map<Point, Color> pixelsMap;

    public SparseRasterImage(Color color, int width, int height)
    {
        super(width, height, color);
        pixelsMap = new HashMap<>();
        createRepresentation();
    }

    public SparseRasterImage(Color[][] pixels)
    {
        super(pixels);
        pixelsMap = new HashMap<>();
        createRepresentation();
    }

    /**
     * create representation of this matrix
     */
    @Override
    public void createRepresentation()
    {
        for(int i = 0; i <width;i++)
        {
            for(int j = 0 ; j<height ; j++)
            {
                if(super.pixels[i][j]!=Color.WHITE)
                    pixelsMap.put(new Point(i, j), super.pixels[i][j]);
            }
        }
    }

    /**
     * set color pixels at coordinate (x, y) to color
     * @param color
     * @param x
     * @param y
     */
    @Override
    public void setPixelColor(Color color, int x, int y)
    {
        super.setPixelColor(color, x, y);
        pixelsMap.clear();
        createRepresentation();
    }

    /**
     * @param x
     * @param y
     * @return color of pixels at coordinate (x, y)
     */
    @Override
    public Color getPixelColor(int x, int y)
    {
        return pixelsMap.getOrDefault(new Point(x, y), Color.WHITE);

    }

    /**
     * update pixels matrix with colors matrix
     * @param colors
     */
    @Override
    public void setPixelsColor(Color[][] colors)
    {
        pixelsMap.clear();
        super.pixels = colors;
        createRepresentation();
    }

    /**
     * set Color of all pixels in matrix to color
     * @param color
     */
    private void setPixelsColor(Color color)
    {
        new SparseRasterImage(color, width, height);
    }


}
