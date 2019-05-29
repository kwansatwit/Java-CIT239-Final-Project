package finalproject;

import javafx.scene.layout.GridPane;

/**
 * A abstract class which is a Super class 
 * it extends a pane and implements a interface called "Interface" 
 * subclass are rectangleObject and circleObject
 * @author Sweet
 */
public abstract class GeometricObject extends GridPane implements Interface {

    private String color = "white";
    private boolean filled;
  
    /**
     * Construct a default geometric object
     */
    protected GeometricObject() {
    }

    /**
     *
     * @param color set object color
     * @param filled to check object color fill or not
     */
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /**
     *
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param color set color of string type
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return filled. Since filled is boolean, the get method is named isFilled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     *
     * @param filled check object filled or not
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
