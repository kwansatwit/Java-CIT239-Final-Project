package finalproject;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * A subclass of GeometricObject Create circle object for player 1 use function
 * to calculate game's question ans
 *
 * @author Sweet
 */
public class CircleObject extends GeometricObject {

    private int radius;
    private int posX;
    private int posY;

    public CircleObject() {

    }

    /**
     *
     * @param radius - create a circle object and use to calculate
     */
    public CircleObject(int radius) {
        this.radius = radius;
        this.posX = 0;
        this.posY = 600;
        draw();
    }

    /**
     *
     * @param radius set circle radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     *
     * @return a circle radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     *
     * @return a circle Area
     */
    @Override
    public int getArea() {
        return radius * radius * (int) Math.PI;
    }

    /**
     * @return circle diameter
     */
    public int getDiameter() {
        return 2 * radius;
    }

    /**
     * @return circle perimeter
     */
    @Override
    public int getPerimeter() {
        return 2 * radius * (int) Math.PI;
    }

    @Override
    public void setX(int x) {
        this.posX = x;
    }

    /**
     *
     * @return posX value - move circle object
     */
    @Override
    public int getX() {
        return posX;
    }

    /**
     *
     * @param y set Y value to move circle object
     */
    @Override
    public void setY(int y) {
        this.posY = y;
    }

    /**
     *
     * @return circle int y pos
     */

    @Override
    public int getY() {
        return posY;
    }

    @Override
    public void draw() {
        Circle circle = new Circle(radius);
        circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        setAlignment(Pos.CENTER);
        getChildren().addAll(circle);
        circle.setTranslateX(0);
        circle.setTranslateY(0);
    }
}
