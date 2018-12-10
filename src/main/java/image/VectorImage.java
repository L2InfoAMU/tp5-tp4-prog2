package image;

import javafx.scene.paint.Color;

import java.util.List;

public class VectorImage implements Image{

    private List<Shape> shapes;
    private Color pixels[][];
    private int width;
    private int height;

    VectorImage(List<Shape> shapes, int width, int height){
        this.width = width;
        this.height = height;
        pixels = new Color[getWidth()][getHeight()];
        this.shapes=shapes;
        for(int index = 0;index < shapes.size();index++){
            for(int x = 0;x < width;x++){
                for(int y = 0;y < height;y++){
                    int indexTmp=index;
                    if(shapes.get(index).contains(new Point(x,y))){
                        if(pixels[x][y]==null)
                            pixels[x][y] = shapes.get(index).getColor();
                        else
                            while(this.getPixelColor(x,y)!= shapes.get(indexTmp).getColor()){
                                indexTmp--;
                            }
                            pixels[x][y] = shapes.get(indexTmp).getColor();
                    }
                }
            }
        }
        for(int x = 0;x < width;x++){
            for(int y = 0;y < height;y++){
                if(pixels[x][y] == null)
                    pixels[x][y] = Color.WHITE;
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
