package image;
import javafx.scene.paint.Color;

import static util.Matrices.requiresNonNull;
import static util.Matrices.requiresNonZeroDimensions;

public class BruteRasterImage extends RasterImage {
    private Color[][] pixels ;

    public BruteRasterImage(Color color, int width, int height){
        super(width,height);
        this.createRepresentation();
        for(int x = 0 ;x < width ; x++){
            for(int y = 0 ; y < height ; y++ ){
                setPixelColor(color,x,y);
            }
        }
    }

    public BruteRasterImage(Color[][] colors){
        super(colors.length,colors[0].length);
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        pixels = colors.clone();
    }

    public void createRepresentation(){
        pixels = new Color[getWidth()][getHeight()];

    }

    public void setPixelColor(Color color, int x, int y){
        pixels[x][y] = color ;
    }

    public Color getPixelColor(int x, int y){
        return pixels[x][y];
    }

    private void setPixelsColor(Color[][] pixels){
        requiresNonNull(this.pixels);
        requiresNonNull(pixels);
        requiresNonZeroDimensions(this.pixels);
        requiresNonZeroDimensions(pixels);
        this.pixels = pixels ;
        setWidth(pixels.length);
        setHeight(pixels[0].length);
    }

}