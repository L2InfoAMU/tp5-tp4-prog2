package image;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Rectangle extends Shape {
    private int x;
    private int y;
    Color pixels[][];

    Rectangle(int x, int y, int width, int height, Color color){
        int width1 = x+width;
        int height1 = x+height;
        for(int i = x;i < width1;i++){
            for(int j = x;j < height1;j++){
                pixels[i][j] = color;
            }
        }
    }

    public boolean contains(Point point){
        return true;
    }

    public Color getColor(){
        return null;
    }
}
