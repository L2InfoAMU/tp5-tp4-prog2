package image;

import java.awt.*;

import static util.Matrices.requiresNonNull;
import static util.Matrices.requiresNonZeroDimensions;

public class BruteRasterImage implements Image {
    private Color[][] pixels;
    private int width;
    private int height;

    public BruteRasterImage(Color color, int width, int height){
        this.width=width;
        this.height=height;
        this.createRepresentation();
        for(int index=0;index < width;index++){
            for(int j=0;j < height;j++){
                this.pixels[index][j] = color;
            }
        }
    }

    public BruteRasterImage(Color[][] colors){
        this.createRepresentation();
        requiresNonNull(pixels);
        requiresNonNull(colors);
        requiresNonZeroDimensions(pixels);
        requiresNonZeroDimensions(colors);
        for(int index=0;index < width;index++){
            for(int j=0;j < height;j++){
                this.pixels[index][j] = colors[index][j];
            }
        }
    }

    public void createRepresentation(){
        this.pixels= new Color[this.getWidth()][this.getHeight()];
    }

    public Color getPixelColor(int x, int y) {
        return this.pixels[x][y];
    }

    public void setPixelColor(Color color, int x, int y) {
        this.pixels[x][y]=color;
    }

    private void setPixelColor(Color[][] pixels) {
        requiresNonNull(this.pixels);
        requiresNonNull(pixels);
        requiresNonZeroDimensions(this.pixels);
        requiresNonZeroDimensions(pixels);
        for(int index=0;index < width;index++){
            for(int j=0;j < height;j++){
                this.pixels[index][j] = pixels[index][j];
            }
        }
    }

    private void setPixelsColor(Color color){
        requiresNonZeroDimensions(pixels);
        for(int index=0;index < width;index++){
            for(int j=0;j < height;j++){
                this.pixels[index][j] = color;
            }
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    protected void setWidth(int width) {
        this.width=width;
    }

    protected void setHeight(int height) {
        this.height=height;
    }
}
