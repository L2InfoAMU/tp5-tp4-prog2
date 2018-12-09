package image;

public abstract class RasterImage implements Image{
    private int width;
    private int height;
    public RasterImage(int width,int height){
        this.width=width;
        this.height=height;
    }
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
