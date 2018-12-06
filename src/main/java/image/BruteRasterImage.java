package image;
import javafx.scene.paint.Color;

import static util.Matrices.requiresNonNull;
import static util.Matrices.requiresNonZeroDimensions;

public class BruteRasterImage extends RasterImage {
    private Color[][] pixels ;

    public BruteRasterImage(Color color, int width, int height){
        this.width = width ;
        this.height = height ;
        this.createRepresentation();
        for(int x = 0 ;x < width ; x++){
            for(int y = 0 ; y < height ; y++ ){
                setPixelColor(color,x,y);
            }
        }
    }

    public BruteRasterImage(Color[][] colors){
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        pixels = colors.clone();
        this.width = colors.length ;
        this.height = colors[0].length ;


    }

    public void createRepresentation(){
        pixels = new Color[width][height];

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
        this.width = pixels.length ;
        this.height = pixels[0].length ;
    }

}