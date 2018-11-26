package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {

    List<Color> palette;
    Color[][] pixels;
    byte[][] indexesOfColors;

    public PaletteRasterImage(Color color, int width, int height)
    {
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
        palette = new ArrayList<>();
        this.pixels = pixels;
        indexesOfColors = new byte[pixels.length][pixels[1].length];
        createRepresentation();
    }

    public void createRepresentation()
    {
        for(int i = 0 ; i<pixels.length;i++)
        {
            for(int j = 0 ; j<pixels[i].length;j++)
            {
                if(!palette.contains(pixels[i][j]))
                {
                    palette.add(pixels[i][j]);
                }
                indexesOfColors[i][j] = (byte)palette.indexOf(pixels[i][j]);
            }
        }
    }

    public void setPixelColor(Color color, int x, int y)
    {
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

    @Override
    public int getWidth() {
        return indexesOfColors.length;
    }

    @Override
    public int getHeight() {
        return indexesOfColors[1].length;
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
