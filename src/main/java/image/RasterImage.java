package image;

import javafx.scene.paint.Color;

import java.util.List;

public abstract class RasterImage implements Image{

    Color[][] pixels;
    List<Shape> shapes;
    int width;
    int height;
    Color color;

    public RasterImage(List<Shape> shapes, int width, int height)
    {
        this.shapes = shapes;
        this.width = width;
        this.height = height;
        boolean test = false;
        pixels = new Color[width][height];
        for(int x = 0 ; x<width ; x++)
        {
            for(int y = 0 ; y<height ; y++)
            {
                for(Shape shape : shapes)
                {
                    if(shape.contains(new Point(x, y))) {
                        pixels[x][y] = shape.getColor();
                        test = true;
                    }
                }
                if(!test) {
                    pixels[x][y] = Color.WHITE;
                    test = false;
                }
            }
        }
    }

    public RasterImage(int width, int height, Color color)
    {
        this.width = width;
        this.height = height;
        this.color = color;
        pixels = new Color[width][height];
        createRepresentation();
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

    public void createRepresentation()
    {
        for(int i = 0 ; i<width;i++)
        {
            for(int j = 0 ; j<height;j++)
            {
                pixels[i][j] = color;
            }
        }
    }
    public void setPixelColor(Color color, int x, int y){
        pixels[x][y] = color;
    }
    public Color getPixelColor(int x, int y)
    {
        return pixels[x][y];
    }
    public void setPixelsColor(Color[][] color)
    {
        this.pixels = color;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    protected void setWidth(int width)
    {
        Color[][] colors = new Color[width][this.height];
        for(int i = 0 ; i<width && i<this.width ; i++)
        {
            for(int j = 0 ; j<this.height;j++)
                colors[i][j] = this.pixels[i][j];
        }

        this.pixels = colors;
    }
    protected void setHeight(int height)
    {
        Color[][] colors = new Color[this.width][height];
        for(int i = 0 ; i<this.width;i++)
        {
            for(int j = 0; j<height && j<this.height;j++)
                colors[i][j] = this.pixels[i][j];
        }

        this.pixels = colors;
    }

}
