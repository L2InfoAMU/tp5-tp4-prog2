package image;

import javafx.scene.paint.Color;

import java.util.Collections;
import java.util.List;

public class VectorImage implements Image{

    List<Shape> shapes;
    Color pixels[][];
    int width;
    int height;

    VectorImage(List<Shape> shapes, int width, int height){
        this.width = width;
        this.height = height;
        Collections.copy(this.shapes,shapes);
        for(int index = 0;index < shapes.size();index++){
            for(int x = 0;x < width;x++){
                for(int y = 0;y < height;y++){
                    if(shapes.get(index).contains(new Point(x,y))){
                        pixels[x][y] = shapes.get(index).getColor();
                    }
                }
            }
        }

    }

    @Override
    public Color getPixelColor(int x, int y) {
        return pixels[x][y];
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
