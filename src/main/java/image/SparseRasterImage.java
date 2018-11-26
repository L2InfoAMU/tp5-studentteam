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

    public void createRepresentation()
    {
        for(int i = 0; i <width;i++)
        {
            for(int j = 0 ; j<height ; j++)
            {
                pixelsMap.put(new Point(i, j), super.pixels[i][j]);
            }
        }
    }


}
