package image;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

import static util.Matrices.requiresNonNull;
import static util.Matrices.requiresNonZeroDimensions;

public class SparseRasterImage extends RasterImage {
    private Map<Point, Color> pixelMap;
    private Point[][] pixels;

    public SparseRasterImage(Color color,int width, int height) {
        super(width, height);
        this.createRepresentation();
        for(int x = 0; x < getWidth(); x++){
            for(int y = 0;y < getHeight();y++){
                this.setPixelColor(color,x,y);
            }
        }
    }

    public SparseRasterImage(Color[][] pixels){
        super(pixels.length,pixels[0].length);
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        this.createRepresentation();
        for(int x = 0; x < getWidth(); x++){
            for(int y = 0;y < getHeight();y++){
                this.setPixelColor(pixels[x][y],x,y);
            }
        }
    }

    @Override
    public void createRepresentation() {
        pixels= new Point[getWidth()][getHeight()];
        pixelMap = new HashMap<Point,Color>();
    }

    public void setPixelColor(Color color, int x, int y){
        pixels[x][y] = new Point(x,y);
        pixelMap.put(pixels[x][y],color);
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return pixelMap.get(pixels[x][y]);
    }

    private void setPixelsColor(Color[][] pixels){
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        for(int x = 0; x < getWidth(); x++){
            for(int y = 0;y < getHeight();y++){
                this.setPixelColor(pixels[x][y],x,y);
            }
        }
    }

    private void setPixelsColor(Color color){
        for(int x = 0; x < getWidth(); x++){
            for(int y = 0;y < getHeight();y++){
                this.setPixelColor(color,x,y);
            }
        }
    }
}
