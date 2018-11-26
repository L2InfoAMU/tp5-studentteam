package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage {

    List<Color> palette;
    byte[][] indexesOfColors;

    public PaletteRasterImage(Color color, int width, int height)
    {
        super(width, height, color);
        palette = new ArrayList<>();
        palette.add(color);
        indexesOfColors = new byte[width][height];
        for(int i = 0 ; i<width;i++)
        {
            for(int j = 0 ; j < height ; j++)
            {
                indexesOfColors[i][j] = (byte)(palette.indexOf(color));
            }
        }
    }

    public PaletteRasterImage(Color[][] pixels)
    {
        super(pixels);
        palette = new ArrayList<>();
        indexesOfColors = new byte[pixels.length][pixels[1].length];
        createRepresentation();
    }

    public void createRepresentation()
    {
        for(int i = 0 ; i<super.getWidth();i++)
        {
            for(int j = 0 ; j<super.getHeight();j++)
            {
                if(!palette.contains(super.pixels[i][j]))
                {
                    palette.add(super.pixels[i][j]);
                }
                indexesOfColors[i][j] = (byte)palette.indexOf(super.pixels[i][j]);
            }
        }
    }

    @Override
    public void setPixelColor(Color color, int x, int y)
    {
        super.setPixelColor(color, x, y);
        if(!palette.contains(color))
        {
            palette.add(color);
        }
        if(x>=0 && x<indexesOfColors.length && y>=0 && y<indexesOfColors[1].length)
        {
            indexesOfColors[x][y] = (byte)palette.indexOf(color);
        }
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return palette.get(indexesOfColors[x][y]);
    }

    public void setPixelsColor(Color[][] pixels)
    {
        for(int i = 0 ; i<pixels.length && i<indexesOfColors.length;i++)
        {
            for(int j = 0 ; j<pixels[i].length && j < indexesOfColors[i].length;j++)
            {
                if(!palette.contains(pixels[i][j]))
                    palette.add(pixels[i][j]);
                indexesOfColors[i][j] = (byte)palette.indexOf(pixels[i][j]);
            }
        }
    }

    private void setPixelsColor(Color color)
    {
        if(!palette.contains(color))
            palette.add(color);
        for(int i = 0 ; i<indexesOfColors.length ; i++)
        {
            for(int j = 0 ; j<indexesOfColors[i].length;j++)
            {
                indexesOfColors[i][j] = (byte)palette.indexOf(color);
            }
        }
    }

    protected void setWidth(int width)
    {
        byte[][] indexColors = new byte[width][indexesOfColors[1].length];
        for(int i = 0;i<width&&i<indexesOfColors.length;i++)
        {
            for(int j = 0; j<indexesOfColors[i].length;j++)
            {
                indexColors[i][j] = indexesOfColors[i][j];
            }
        }
        this.indexesOfColors = indexColors.clone();
    }

    protected void setHeight(int height)
    {
        byte[][]indexColors = new byte[indexesOfColors.length][height];
        for(int i = 0;i<indexesOfColors.length;i++)
        {
            for(int j = 0; j<height && j<indexesOfColors[i].length;j++)
            {
                indexColors[i][j] = indexesOfColors[i][j];
            }
        }
        this.indexesOfColors = indexColors.clone();
    }
}
