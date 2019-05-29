/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *Dice class for rolling class, in main class create its object
 * @author Sweet
 */
public class Dice extends Pane {

    public static final int MAX = 6;
    public static final int MIN = 1;
    Text diceNum = new Text();
    private int diceSide = 1;
    Image dice;
    ImageView imageView;
    private Timeline animation;

    Dice() {
        this.diceSide = 1;
        animation = new Timeline(new KeyFrame(Duration.millis(100), e -> rollDice()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation 
        rollDice();
    }

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    /**
     *
     * @param dice number to decide image of dice side
     */
    Dice(int dice) {
        this.diceSide = dice;
    }

    /**
     *
     * @param dice set (int) random number from main
     */
    public void setDice(int dice) {

        this.diceSide = dice;
    }

    /**
     *
     * @return a dice number for roll dice function
     */
    public int getDiceNum() {
        return diceSide;
    }

    public void rollDice() {

        switch (diceSide) {
            case 1:
                dice = new Image("1.jpg");
                imageView = new ImageView(dice);
                break;
            case 2:
                dice = new Image("2.jpg");
                imageView = new ImageView(dice);
                break;
            case 3:
                dice = new Image("3.jpg");
                imageView = new ImageView(dice);
                break;
            case 4:
                dice = new Image("4.jpg");
                imageView = new ImageView(dice);
                break;
            case 5:
                dice = new Image("5.jpg");
                imageView = new ImageView(dice);
                break;
            case 6:
                dice = new Image("6.jpg");
                imageView = new ImageView(dice);
                break;
        }
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);

        getChildren().add(imageView);
    }

}
