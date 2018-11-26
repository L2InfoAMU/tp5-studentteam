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

    public void createRepresentation()
    {
        for(int i = 0; i<this.pixels.length;i++)
        {
            for(int j = 0;j<this.pixels[i].length;j++)
                System.out.print(this.pixels[i][j]);
            System.out.println(" ");
        }
    }


    @Override
    public Color getPixelColor(int x, int y) {
        return super.pixels[x][y];
    }

    public void setPixelsColor(Color[][] color)
    {
        super.pixels = color;
    }

    private void setPixelsColor(Color color)
    {
        for(int i = 0; i < width;i++)
            for(int j = 0 ; j< height;j++)
                pixels[i][j] = color;
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
