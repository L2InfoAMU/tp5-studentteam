package image;

import javafx.scene.paint.Color;

public abstract class RasterImage implements Image{

    Color[][] pixels;
    int width;
    int height;

    public RasterImage(int width, int height, Color color)
    {
        this.width = width;
        this.height = height;
        pixels = new Color[width][height];
        for(int i = 0 ; i<width;i++)
        {
            for(int j = 0 ; j<height;j++)
            {
                pixels[i][j] = color;
            }
        }
    }

    public RasterImage(Color[][] colors)
    {
        util.Matrices.requiresNonNull(colors);
        util.Matrices.requiresNonZeroDimensions(colors);
        util.Matrices.requiresRectangularMatrix(colors);
        this.width = colors.length;
        this.height = colors[0].length;
        this.pixels = colors;
    }

    public abstract void createRepresentation();
    public void setPixelColor(Color color, int x, int y){
        pixels[x][y] = color;
    }
    public abstract Color getPixelColor(int x, int y);
    public abstract void setPixelsColor(Color[][] color);
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    protected abstract void setWidth(int width);
    protected abstract void setHeight(int height);

}
