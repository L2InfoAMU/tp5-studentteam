package image;

import javafx.scene.paint.Color;

public class BruteRasterImage extends RasterImage {

    Color [][] pixels;

    public BruteRasterImage(Color color, int width, int height)
    {
        super(width, height, color);

    }

    public BruteRasterImage(Color [][] colors)
    {
        super(colors);
    }

    private void setPixelsColor(Color color)
    {
        for(int i = 0; i < width;i++)
            for(int j = 0 ; j< height;j++)
                pixels[i][j] = color;
    }



}
