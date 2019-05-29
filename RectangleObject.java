package finalproject;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Rectangle object extends GeometricObject and inherit GeometricObject that
 * implement interface and it class
 *
 * @author Sweet
 */
public class RectangleObject extends GeometricObject {

    private int width;
    private int height;
    private int posX;
    private int posY;

    public RectangleObject() {
    }

    /**
     *
     * @param width set up a rectangle width to draw it out
     * @param height set up a rectangle height to draw it out
     */
    public RectangleObject(
            int width, int height) {
        this.width = width;
        this.height = height;
        this.posX = 0;
        this.posY = 600;
        draw();
    }

    /**
     *
     * @param width set rect width
     * @param height set rect height
     * @param color set object color of String
     * @param fill fill color? true or false
     */
    public RectangleObject(
            int width, int height, String color, boolean fill) {
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(fill);
    }

    /**
     * Set a new width
     *
     * @param width object width in int
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Set a new height
     *
     * @param height set a new height for object
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @return area
     */
    @Override
    public int getArea() {
        return width * height;
    }

    /**
     * @return rectangle perimeter
     */
    @Override
    public int getPerimeter() {
        return 2 * (width + height);
    }

    /**
     *
     * @param x set rectangle object x pos
     */
    @Override
    public void setX(int x) {
        this.posX = x;
    }

    /**
     *
     * @return x pos to move object
     */
    @Override
    public int getX() {
        return posX;
    }

    /**
     *
     * @param y set rectangle object y pos
     */
    @Override
    public void setY(int y) {
        this.posY = y;
    }

    /**
     *
     * @return y pos to move object
     */
    @Override
    public int getY() {
        return posY;
    }

    @Override
    public void draw() {
        Rectangle rec = new Rectangle(width, height);
        rec.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        setAlignment(Pos.CENTER);
        getChildren().add(rec);
        rec.setTranslateX(0);
        rec.setTranslateY(0);
    }
}
