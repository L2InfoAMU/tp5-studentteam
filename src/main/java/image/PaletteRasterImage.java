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
        super.createRepresentation();
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


    /**
     * set color of color in coordinate (x, y)
     * @param color
     * @param x
     * @param y
     */
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

    /**
     *
     * @param x
     * @param y
     * @return color of point (x, y).
     */
    @Override
    public Color getPixelColor(int x, int y) {
        return palette.get(indexesOfColors[x][y]);
    }

    /**
     * update current matrix with matrix pixels
     * @param pixels
     */
    public void setPixelsColor(Color[][] pixels)
    {
        super.setPixelsColor(pixels);
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

    /**
     * set color color for all pixels
     * @param color
     */
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

    /**
     * set width of matrix
     * @param width
     */
    protected void setWidth(int width)
    {
        super.setWidth(width);
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

    /**
     * set height of matrix
     * @param height
     */
    protected void setHeight(int height)
    {
        super.setHeight(height);
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
