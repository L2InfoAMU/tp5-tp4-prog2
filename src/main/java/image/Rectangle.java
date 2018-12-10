package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape{
    private int x;
    private int y;
    private int width;
    private int height;
    Color pixels[][];

    Rectangle(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        setWidth(width);
        setHeight(height);
        pixels = new Color[getWidth()][getHeight()];
        for(int wdtRec = 0;wdtRec < getWidth();wdtRec++){
            for(int hgtRec = 0;hgtRec < getHeight();hgtRec++){
                pixels[wdtRec][hgtRec] = color;
            }
        }
    }

    public boolean contains(Point point){
        if (point.x > this.width + this.x|| point.y > this.height + this.y || point.x < x || point.y < y)
            return false;
        return true;
    }

    public Color getColor(){
        return pixels[0][0];
    }

    public int getWidth(){
        return this.width ;
    }

    public int getHeight(){
        return this.height ;
    }

    public int getX(){
        return this.x ;
    }

    public int getY(){
        return this.y ;
    }

    protected void setWidth(int width) {
        this.width = width ;
    }

    protected void setHeight(int height){
        this.height = height ;
    }
}
