package image;

public abstract class RasterImage implements Image{
    int width;
    int height;
    public int getHeight(){
        return this.height ;
    }
    public int getWidth(){
        return this.width ;
    }
    protected void setWidth(int width) {
        this.width = width ;
    }
    protected void setHeight(int height){
        this.height = height ;
    }
    public abstract void createRepresentation();
}
