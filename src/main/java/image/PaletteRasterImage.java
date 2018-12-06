package image;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import static util.Matrices.requiresNonNull;
import static util.Matrices.requiresNonZeroDimensions;


public class PaletteRasterImage extends RasterImage {
    private List<Color> palette;
    private int[][] indexOfColor ;

    public PaletteRasterImage(Color color, int width, int height){
        this.width=width;
        this.height=height;
        this.createRepresentation();
        for(int x = 0 ; x < width ; x++){
            for(int y = 0 ; y < height ; y++){
                this.setPixelColor(color,x,y);
            }
        }
    }

    public PaletteRasterImage(Color[][] pixels){

        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        this.width = pixels.length ;
        this.height = pixels[0].length ;
        this.createRepresentation();
        for(int x = 0 ; x < width ; x++){
            for(int y = 0 ; y < height ; y++){
                this.setPixelColor(pixels[x][y],x,y) ;
            }
        }


    }

    public void createRepresentation(){
        indexOfColor = new int[width][height];
        palette= new ArrayList<Color>();
    }

    public void setPixelColor(Color color, int x, int y){
        if (!palette.contains(color)){
            palette.add(color);
        }
        indexOfColor[x][y]=palette.indexOf(color);
    }
    public Color getPixelColor(int x, int y){
        return this.palette.get(indexOfColor[x][y]);
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

}
