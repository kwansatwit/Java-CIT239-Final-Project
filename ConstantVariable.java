/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Interface contain all the constant variable for main class
 * @author Shuk Ha Kwan
 */
public interface ConstantVariable {
     /** set  Stage width and length*/
    final public int W = 1000;
    final public int L = 700;
         /** set button New Width & length  */
    final public int BTNW = 150; 
    final public int BTNL = 50;
        /** set HBox H gap  */
    final public int HGAP = 15;
    /** set left and right pad  */
    final public int LRPAD = 60; 
        /** set top and bottom pad  */
    final public int TBPAD = 10;
        /** set word size */
    final public int WORDSIZE = 13;
         /** set  Array size*/
    final public int SIZE = 100;
    Text start = new Text("Start");
    Text end = new Text("End");
    TextField player1NameInput = new TextField();
    TextField player2NameInput = new TextField();
         /** set  array for player 1 & 2 data*/
    final public String[] questionArray = new String[SIZE];
    final public String[] ansArray = new String[SIZE];
    final public String[] questionArray2 = new String[SIZE];
    final public String[] ansArray2 = new String[SIZE];

}
