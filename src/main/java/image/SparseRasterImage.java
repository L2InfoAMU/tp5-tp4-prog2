package image;

import javafx.scene.paint.Color;
import java.util.Map;

public class SparseRasterImage extends RasterImage {
    Map<Point, Color> PixelMap;
    Color[][] pixels;

    public SparseRasterImage(int width, int height) {
        super(width, height);
    }

    @Override
    public void createRepresentation() {

    }

    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }
}
