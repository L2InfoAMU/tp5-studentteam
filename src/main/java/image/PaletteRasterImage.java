package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {

    List<Color> palette;
    byte[][] indexesOfColors;

    public PaletteRasterImage(Color color, int width, int height)
    {
        palette = new ArrayList<>();
        palette.add(color);
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

    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
