/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.scene.control.Label;

/**
 *Question is a super class extends to Ans class
 * It contains all the question 
 * and use random number to create math questions
 * @author Shuk Ha Kwan
 */
public class Question {

    public int qNum;
    public int ranNum1 = (int) (Math.random() * 10 + 1);
    public int ranNum2 = (int) (Math.random() * 10 + 1);
    public int status;
    public String ans;
    CircleObject circle = new CircleObject();
    RectangleObject rect = new RectangleObject();
    public String q;
    Label a = new Label("    ");

  public Question() {
        this.qNum = 0;

    }

    public Question(int qN) {
        this.qNum = qN;
    }

    /**
     *
     * @param qn get random int number from main to set question
     */
    public void setQn(int qn) {
        this.qNum = qn;
    }

    /**
     *
     * @return a number to setUpQ function
     */
    public int getQn() {
        return qNum;
    }

    /**
     *
     * @return base on get question number to select one question and return a
     * String to function call
     */
    public String setUpQ() {
        if (qNum == 1) {
            q = ("Q: What is the area of a rectangle \n width = " + ranNum1
                    + " and lenght = " + ranNum2);
            rect.setWidth(ranNum1);
            rect.setHeight(ranNum2);
            System.out.println(rect.getArea());
        } else if (qNum == 2) {
            q = ("Q: What is the Perimeter of rectangle \n width = " + ranNum1
                    + " and length = " + ranNum2);
            rect.setWidth(ranNum1);
            rect.setHeight(ranNum2);
            System.out.println(rect.getPerimeter());
        } else if (qNum == 3) {
            q = ("Q: " + ranNum1 + " * " + ranNum2 + "-" + ranNum1 + " = ? ");
            System.out.println(ranNum1 * ranNum2 - ranNum1);
        } else if (qNum == 4) {

            q = ("Q: What's the circle area of " + ranNum1 + " radius");
            circle.setRadius(ranNum1);
            System.out.println(circle.getArea());
        } else if (qNum == 5) {
            q = ("Q:    5    \n  7        3\n  5    8    2 \n "
                    + "9   6   4   ?\n What is the number of\"?\"");
            System.out.println("1");
        }
        return q;
    }
}
