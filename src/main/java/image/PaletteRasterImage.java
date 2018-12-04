package image;

import java.awt.*;

import static util.Matrices.requiresNonNull;
import static util.Matrices.requiresNonZeroDimensions;

public class PaletteRasterImage implements Image{
    private int width;
    private int height;
    Color[] colors = {Color.red , Color.blue , Color.white} ;
    int[][] pixels ;

    public PaletteRasterImage(Color color, int width, int height){
        int colorNumber = 0 ;
        for(int index = 0 ; index < 3 ; index++){
            if (color == colors[index])
                colorNumber = index ;

        }

        for(int x = 0 ; x < width ; x++){
            for(int y = 0 ; y < height ; y++){
                pixels[x][y] = colorNumber ;
            }
        }
    }

    public PaletteRasterImage(Color[][] pixels){

        this.width = pixels.length ;
        this.height = pixels[0].length ;
        for(int x = 0 ; x < width ; x++){
            for(int y = 0 ; y < height ; y++){
                this.setPixelColor(pixels[x][y],x,y) ;
            }
        }


    }

    public void createRepresentation(){
        pixels = new int[width][height];
    }

    public void setPixelColor(Color color, int x, int y){
        for(int index=0;index < 3;index++) {
            if (color == colors[index])
                pixels[x][y] = index;
        }

    }
    public Color getPixelColor(int x, int y){

            for(int index = 0 ; index < 3 ; index ++){
                if(pixels[x][y] == index) {
                    return colors[index];
                }
            }
            throw new ArithmeticException("/ aucune couleur");

    }

    private void setPixelsColor(Color[][] pixels) {
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        for(int x = 0 ; x < width ; x++){
            for(int y = 0 ; y < height ; y++){
                this.setPixelColor(pixels[x][y],x,y);
            }
        }

    }
    private void setPixelsColor(Color color){
        for(int x = 0 ; x < width ; x++){
            for(int y = 0 ; y < height ; y++){
                this.setPixelColor(color,x,y);
            }
        }
    }
    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    protected void setWidth(int width){
        this.width=width;
    }

    protected void setHeight(int height){
        this.height=height;
    }
}
