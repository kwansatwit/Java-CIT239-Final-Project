/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;

/**
 *create a game platform
 * @author Shuk Ha Kwan
 */
public class Cell extends StackPane {

    public Cell() {
        setStyle("-fx-border-color: black");
        this.setPrefSize(90, 90);
        setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    }

}
