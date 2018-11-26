package image;

import javafx.scene.paint.Color;

public class BruteRasterImage implements Image {

    Color [][] pixels;

    public BruteRasterImage(Color color, int width, int height)
    {
        pixels = new Color[width][height];
        for(int i = 0;i<width;i++)
        {
            for(int j = 0; j<height;j++)
            {
                pixels[i][j] = color;
            }
        }
    }

    public BruteRasterImage(Color [][] colors)
    {
        this.pixels = colors.clone();
    }

    public void createRepresentation()
    {
        for(int i = 0; i<this.pixels.length;i++)
        {
            for(int j = 0;j<this.pixels[i].length;j++)
                System.out.print(this.pixels[i][j]);
            System.out.println(" ");
        }
    }

    public void setPixelColor(Color color, int x, int y)
    {
        pixels[x][y] = color;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return pixels[x][y];
    }

    public void setPixelsColor(Color[][] color)
    {
        this.pixels = color.clone();
    }

    private void setPixelsColor(Color color)
    {
        for(int i = 0; i < pixels.length;i++)
            for(int j = 0 ; j< pixels[i].length;j++)
                pixels[i][j] = color;
    }

    @Override
    public int getWidth() {
        return pixels.length;
    }

    @Override
    public int getHeight() {
        return pixels[1].length;
    }

    protected void setWidth(int width)
    {
        Color[][] colors = new Color[width][this.pixels[1].length];
        for(int i = 0 ; i<width && i<this.pixels.length ; i++)
        {
            for(int j = 0 ; j<this.pixels[i].length;j++)
                colors[i][j] = this.pixels[i][j];
        }

        this.pixels = colors.clone();
    }

    protected void setHeight(int height)
    {
        Color[][] colors = new Color[this.pixels.length][height];
        for(int i = 0 ; i<this.pixels.length;i++)
        {
            for(int j = 0; j<height && j<this.pixels[j].length;j++)
                colors[i][j] = this.pixels[i][j];
        }

        this.pixels = colors.clone();
    }
}
