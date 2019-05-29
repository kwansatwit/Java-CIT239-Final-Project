/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *interface contain some abstract class 
 * related to rectangleObject and circleObject
 * @author Sweet
 */
public interface Interface {

    /**
    * @return a double new to compare answer
     */
    public int getArea();

    /**
     *
     * @return a perimeter of double number to compare answer
     */
    public int getPerimeter();

    public void draw();

    public void setX(int x);

    public int getX();

    public void setY(int y);

    public int getY();
}
