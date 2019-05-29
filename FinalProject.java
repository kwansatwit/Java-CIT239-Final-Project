/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * Main class for run program, hold all the pane and stage
 *
 * @author Shuk Ha Kwan
 */
public class FinalProject extends Application implements ConstantVariable {

    // Global variable 
    private Cell[][] cell = new Cell[6][6];
    int countNum1 = 0;
    int countWalk1 = 0;
    int countNum2 = 0;
    int countWalk2 = 0;
    String holdString;
    int checkA = 0;
    int holdranNum = (int) (Math.random() * 3 + 1);
    boolean ans = false;
    boolean gameRun = false;
    int point = 0;
    int point2 = 0;
    Stage stage;
    Scene loginScene, gameScene, fileScene;
    int updateArray = 0, updateArray2 = 0;
    int countCorrect1 = 0, countWrong1 = 0, countCorrect2 = 0, countWrong2 = 0;

    @Override
    public void start(Stage primaryStage) {
//new Stage, panes for both player

        Stage window = primaryStage;
        VBox displayMess = new VBox();
        GridPane displayQA = new GridPane();
        Text displayMessage = new Text("");
        //================================ login background 
        Image loginBackground = new Image("G3.gif");
        ImageView imageView = new ImageView(loginBackground);
        //=======================================================================game base pane
        GridPane pane = new GridPane();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                pane.add(cell[i][j] = new Cell(), j, i);
            }
        }
        start.setFont(Font.font("Verdana", 15));
        end.setFont(Font.font("Verdana", 15));
        start.setX(-40);
        start.setY(10);
        end.setX(550);
        end.setY(500);
        //====================================================================================================login page
        GridPane loginPane = new GridPane();
        loginPane.setAlignment(Pos.CENTER);
        loginPane.setPadding(new Insets(10, 10, 10, 10));
        loginPane.setHgap(15);
        loginPane.setVgap(15);
        Button gameStar = new Button("GameStar");
        Label player1Name = new Label("Player 1");
        Label player2Name = new Label("Player 2");
        player1NameInput.setPromptText("Please enter player one's name");
        player2NameInput.setPromptText("Please enter player two's name");
        Label hints = new Label("Please enter two players' user name");
        Label space = new Label("      ");
        Label errorLabel = new Label("Please enter user name");
        errorLabel.setVisible(false);
        loginPane.add(hints, 1, 0);
        loginPane.add(player1Name, 0, 1);
        loginPane.add(player1NameInput, 1, 1);
        loginPane.add(player2Name, 0, 2);
        loginPane.add(player2NameInput, 1, 2);
        loginPane.add(gameStar, 1, 4); //col, row
        loginPane.add(space, 1, 5);
        loginPane.add(errorLabel, 1, 5);
        StackPane loginPage = new StackPane(imageView, loginPane);
        loginScene = new Scene(loginPage, W, L);
        /**
         * @gameStar login page button event, to make sure user enter their name
         * already. that can use for write data for each user
         */
        gameStar.setOnAction(e -> {
            if (player1NameInput.getText() != null && !player1NameInput.getText().isEmpty()
                    && player2NameInput.getText() != null && !player2NameInput.getText().isEmpty()) {
                window.setScene(gameScene);
            } else {
                space.setVisible(false);
                errorLabel.setVisible(true);
            }
        });

        //===================================================================================================Player 1
        /*
        All nodes, objects, and pane for player 1
         */
        Button player1 = new Button("Roll Dice");
        Label play1 = new Label("Player 1");
        Circle player1Shape = new Circle(10);
        StackPane object = new StackPane();
        CircleObject playerOne = new CircleObject(10);
        RectangleObject playerTwo = new RectangleObject(20, 20);
        HBox play1Dice = new HBox(HGAP);
        play1Dice.setAlignment(Pos.CENTER);
        play1Dice.setPadding(new Insets(TBPAD, LRPAD, TBPAD, LRPAD));
        play1Dice.setStyle("-fx-background-color: lightblue");
        playerOne.setTranslateX(-20);
        playerOne.setTranslateY(30);
        Dice dice1 = new Dice();
        Label displayPoint1 = new Label();
        /**
         * @player1 player1 event hanger for rolling dice, and control object
         */
        player1.setOnAction((ActionEvent e) -> {
            if (countNum1 <= 36) {
                Random ranNum = new Random();
                dice1.setDice(ranNum.nextInt(6) + 1);
                dice1.rollDice();
                int player = 1;
                countNum1 += dice1.getDiceNum();
                countWalk1 = dice1.getDiceNum();
                quizBox(player, countWalk1, countNum1,
                        displayPoint1, displayMessage, displayMess);
                objectRun(playerOne, playerTwo, player, countNum1, countWalk1);
            } else if (countNum1 >= 36) {
                gameOver(window);
            }
        });

//==============================================================Player 2
/*
All nodes, panes, and objects for player 2
         */
        Button player2 = new Button("Roll Dice");
        Label play2 = new Label("Player 2");
        Rectangle player2Shape = new Rectangle(20, 20);
        HBox play2Dice = new HBox(HGAP);
        play2Dice.setAlignment(Pos.CENTER);
        play2Dice.setPadding(new Insets(TBPAD, LRPAD, TBPAD, LRPAD));
        play2Dice.setStyle("-fx-background-color: pink");
        playerTwo.setTranslateX(-20);
        playerTwo.setTranslateY(50);
        object.getChildren().addAll(playerOne, playerTwo);
        Dice dice2 = new Dice();
        Label displayPoint2 = new Label();
        /**
         * @player2 Player2 button hanger for player2 rolling dice and move
         * object
         */
        player2.setOnAction(e -> {
            Random ranNum = new Random();
            dice2.setDice(ranNum.nextInt(6) + 1);
            dice2.rollDice();
            int detect = 2;
            countNum2 += dice2.getDiceNum();
            countWalk2 = dice2.getDiceNum();
            quizBox(detect, countWalk2, countNum2,
                    displayPoint2, displayMessage, displayMess);
            objectRun(playerOne, playerTwo, detect, countNum2, countWalk2);
            if (countNum2 >= 36) {
                gameOver(window);
            }
        });
//==================================================================Pane and nodes for player1 and player2

//displayStatus for display each player's event messages 
        ScrollPane displayStatus = new ScrollPane(displayMess);
        displayStatus.setPrefSize(300, 600);
        displayQA.add(displayStatus, 0, 0);
        displayQA.setPrefSize(300, 600);
        //play1Dice or play2Dice pane for showing player1 and player2's node on scene
        play1Dice.getChildren().addAll(play1, player1, player1Shape, displayPoint1);
        play2Dice.getChildren().addAll(play2, player2, player2Shape, displayPoint2);
//buttonPane to build up completely dice roll scene        
        HBox buttonPane = new HBox(HGAP * 2);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.getChildren().addAll(play1Dice, dice1, dice2, play2Dice);
        //group pane add game scene together
        Group group = new Group();
        group.getChildren().addAll(pane, object, start, end);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(group);
        borderPane.setBottom(buttonPane);
        borderPane.setLeft(displayQA);
        Image gameBackground = new Image("B2.gif");
        ImageView imageView2 = new ImageView(gameBackground);
        StackPane gamePage = new StackPane(imageView2, borderPane);
        gameScene = new Scene(gamePage, W, L);

        window.setTitle("Lucky & Knowledge Game"); // Set the stagtitle
        window.setScene(loginScene); // Place the scene in the stage
        window.show(); // Display the stage
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * @param player - a circle object for player one
     * @param player2 - a rectangle object for player 2
     * @param detect - detect player 1 or 2
     * @param countNum - a variable save the total dice roll number to move
     * object
     * @param countWalk - currently dice roll number
     */
    public void objectRun(CircleObject player, RectangleObject player2, int detect, int countNum, int countWalk) {
        int y = 0;
        y = (detect == 1 ? -5 : 20);

        if (countNum <= 6) {
            (detect == 1 ? player : player2).setTranslateX((countNum - 1) * 100);
            //notice.setTranslateX((countWalk - 1) * 100);
            (detect == 1 ? player : player2).setTranslateY(detect == 1 ? 30 : 50);
            //notice.setTranslateY(30);
        } else if (countNum > 6 && countNum <= 12) {
            walking(player, player2, detect, countNum, countWalk);
            (detect == 1 ? player : player2).setTranslateY(100 + y);
            //notice.setTranslateY(100);
        } else if (countNum > 12 && countNum <= 18) {
            walking(player, player2, detect, countNum, countWalk);
            (detect == 1 ? player : player2).setTranslateY(200 + y);
            //notice.setTranslateY(200);
        } else if (countNum > 18 && countNum <= 24) {
            walking(player, player2, detect, countNum, countWalk);
            (detect == 1 ? player : player2).setTranslateY(300 + y);
            //notice.setTranslateY(300);
        } else if (countNum > 24 && countNum <= 30) {
            walking(player, player2, detect, countNum, countWalk);
            (detect == 1 ? player : player2).setTranslateY(400 + y);
            //notice.setTranslateY(400);
        } else if (countNum > 30 && countNum <= 36) {
            walking(player, player2, detect, countNum, countWalk);
            (detect == 1 ? player : player2).setTranslateY(480 + y);
            // notice.setTranslateY(500);
        } else {
            (detect == 1 ? player : player2).setTranslateX(500);
            (detect == 1 ? player : player2).setTranslateY(480 + y);
        }
    }

    /**
     *
     * @param player - set player object move x-pos
     * @param player2 - set player 2 object move x-pos
     * @param detect - detect move player 1 or 2
     * @param countNum - move object x-pos
     * @param countWalk - move object x-pos
     */
    public void walking(CircleObject player, RectangleObject player2, int detect, int countNum, int countWalk) {
        if (countNum % 6 == 1) {
            countWalk = 1;
            (detect == 1 ? player : player2).setTranslateX((countWalk) * 20);
        } else if (countNum % 6 == 2) {
            countWalk = 1;
            (detect == 1 ? player : player2).setTranslateX((countWalk) * 100);
        } else if (countNum % 6 == 3) {
            countWalk = 2;
            (detect == 1 ? player : player2).setTranslateX((countWalk) * 100);
        } else if (countNum % 6 == 4) {
            countWalk = 3;
            (detect == 1 ? player : player2).setTranslateX((countWalk) * 100);
        } else if (countNum % 6 == 5) {
            countWalk = 4;
            (detect == 1 ? player : player2).setTranslateX((countWalk) * 100);
        } else if (countNum % 6 == 0) {
            countWalk = 5;
            (detect == 1 ? player : player2).setTranslateX((countWalk) * 100);
        }
    }

    /**
     * function for questions all the box have random questions
     *
     * @param player - detect player 1 or 2
     * @param countWalk - for display dice message
     * @param countNum - for question condition
     * @param displayPoint - add point to players
     * @param displayMessage - a text node to display game info
     * @param displayMess - a pane to add all message in to one
     */
    public void quizBox(int player, int countWalk, int countNum,
            Label displayPoint, Text displayMessage, VBox displayMess) {

        Ans a = new Ans();
        Label correctAS = new Label("Correct Ans, "
                + (player == 1 ? player1NameInput.getText() : player2NameInput.getText())
                + " add 1 point");
        correctAS.setFont(Font.font("Verdana", WORDSIZE));
        Label errorAs = new Label("Wrong Ans, "
                + (player == 1 ? player1NameInput.getText() : player2NameInput.getText())
                + " lose 1 point");
        errorAs.setFont(Font.font("Verdana", WORDSIZE));
        correctAS.setVisible(false);
        errorAs.setVisible(false);
        VBox questionBox = new VBox(15);
        questionBox.setAlignment(Pos.CENTER);
        questionBox.setPadding(new Insets(10, 10, 10, 10));
        questionBox.setMaxSize(300, 200);
        if (countNum >= 1 && countNum <= 36) {

            stage = new Stage();
            TextField getAns = new TextField();
            getAns.setPromptText("Please enter answer here");
            Label question;

            a.setQn((int) (Math.random() * 5 + 1));
            question = new Label(a.setUpQ());
            question.setFont(Font.font("Verdana", WORDSIZE));
            if (player == 1) {
                questionArray[updateArray] = a.setUpQ();
            } else {
                questionArray2[updateArray2] = a.setUpQ();
            }

            getAns.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.ENTER) {
                    String getTry;
                    getTry = getAns.getText();
                    a.setAS(getTry);
                    a.compareTo(a);
                    addPoint(player, a, displayPoint, correctAS, errorAs);

                    if (player == 1) {
                        ansArray[updateArray] = getTry;
                        updateArray++;
                    } else {
                        ansArray2[updateArray2] = getTry;
                        updateArray2++;
                    }
                    stage.close();
                }
            });
            questionBox.getChildren().addAll(question, getAns);
        }

        String display
                = ("\n" + (player == 1 ? player1NameInput.getText() : player2NameInput.getText())
                + " rolled dice : " + countWalk + "\n"
                + ("\n" + (player == 1 ? player1NameInput.getText() : player2NameInput.getText())
                + " go to No." + countNum + " area"));
        displayMessage = new Text(display);
        displayMessage.setFont(Font.font("Verdana", WORDSIZE));

        displayMess.getChildren().addAll(displayMessage, correctAS, errorAs);
        if (countNum <= 36) {
            Scene scene1 = new Scene(questionBox, W / 2, L / 2);
            stage.setTitle("Q & A"); // Set the stagtitle
            stage.setScene(scene1); // Place the scene in the stage
            stage.show(); // Display the stage
        }
    }

    /**
     *
     * @param player - detect player 1 or 2
     * @param a - ans class object
     * @param displayPoint - update player points
     * @param correctAS - update correct ans message
     * @param errorAs - update wrong ans message
     */
    public void addPoint(int player, Ans a, Label displayPoint, Label correctAS, Label errorAs) {

        if (player == 1) {
            if (a.checkAns == 1) {
                point += 1;
                countCorrect1++;
                correctAS.setVisible(true);
                errorAs.setVisible(false);
            } else {
                point -= 1;
                countWrong1++;
                correctAS.setVisible(false);
                errorAs.setVisible(true);
            }
            displayPoint.textProperty().bind(new SimpleIntegerProperty(point).asString());
        } else if (player == 2) {
            if (a.checkAns == 1) {
                point2 += 1;
                countCorrect2++;
                correctAS.setVisible(true);
                errorAs.setVisible(false);
            } else {
                point2 -= 1;
                countWrong2++;
                correctAS.setVisible(false);
                errorAs.setVisible(true);
            }
            displayPoint.textProperty().bind(new SimpleIntegerProperty(point2).asString());
        }
    }

    /**
     *
     * @param window for switch to file scene
     */
    public void gameOver(Stage window) {
        Label winner = new Label();
        String winName = "";
        int status = 0;

        if (point > point2) {
            status = 1;
            winName = player1NameInput.getText();
        } else if (point < point2) {
            status = 1;
            winName = player2NameInput.getText();
        } else {
            status = 2;
        }
        Stage gameOverStage = new Stage();
        GridPane endGamePane = new GridPane();
        Label gameEnd = new Label("End Game!");
        gameEnd.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, WORDSIZE * 2));
        gameEnd.setStyle("-fx-stroke: black; -fx-text-fill:red;");
        gameEnd.setAlignment(Pos.CENTER);
        winner = new Label((status == 1 ? "Congratulation! \n"
                + winName + ", You Won the game!" : "Sorry no one won"));
        winner.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, WORDSIZE + 5));
        Label file = new Label("Do you want to save or read a file data?\n"
                + "Click \"Yes\" button!\n"
                + "Otherwise Click \"No\" button to leave");
        file.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, WORDSIZE + 5));
        Button yes = new Button("Yes");
        Button no = new Button("No");
        HBox button = new HBox(30);
        button.getChildren().addAll(yes, no);
        endGamePane.add(gameEnd, 1, 1);
        endGamePane.add(winner, 1, 2);
        endGamePane.add(file, 1, 3);
        endGamePane.add(button, 1, 4);
        endGamePane.setAlignment(Pos.CENTER);
        endGamePane.setPadding(new Insets(10, 10, 10, 10));
        endGamePane.setHgap(15);
        endGamePane.setVgap(15);
        yes.setOnAction(e -> {
            file(window, gameOverStage);
        });
        no.setOnAction(e -> {
            window.close();
            gameOverStage.close();
        });

        Scene endscene = new Scene(endGamePane, W / 2, L / 2);
        endscene.setFill(Color.BISQUE);
        gameOverStage.setTitle("End Game"); // Set the stagtitle
        gameOverStage.setScene(endscene); // Place the scene in the stage
        gameOverStage.show(); // Display the stage
    }

    /**
     *
     * @param window - for exit button
     * @param gameOverStage - for exit button
     */
    public void file(Stage window, Stage gameOverStage) {

        window.setScene(fileScene);
        Button writeData = new Button("Data out");
        Button readData = new Button("Enter");
        Button exit = new Button("Exit");
        writeData.setMaxSize(BTNW, BTNL);
        readData.setMaxSize(BTNW, BTNL);
        exit.setMaxSize(BTNW, BTNL);
        Label outPutData = new Label("Send data into a file");
        outPutData.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, WORDSIZE));
        Label inPutData = new Label("Read data from a file and display it");
        inPutData.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, WORDSIZE));
        TextField fileName = new TextField();
        fileName.setPromptText("Please Enter a file name");
        fileName.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, WORDSIZE));
        GridPane filePane = new GridPane();
        filePane.add(outPutData, 0, 0);
        filePane.add(writeData, 0, 1);
        filePane.add(inPutData, 0, 2);
        filePane.add(fileName, 0, 3);
        filePane.add(readData, 0, 4);
        filePane.add(exit, 0, 5);
        filePane.setAlignment(Pos.CENTER);
        filePane.setPadding(new Insets(10, 10, 10, 10));
        filePane.setHgap(15);
        filePane.setVgap(15);
        fileScene = new Scene(filePane, W, L);
        writeData.setOnAction(e -> {
            try (
                    ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(player1NameInput.getText() + ".dat", true)));) {

                output.writeObject(questionArray);
                output.writeObject(ansArray);

            } catch (IOException ex) {
                Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            try (
                    ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(player2NameInput.getText() + ".dat", true)));) {

                output.writeObject(questionArray2);
                output.writeObject(ansArray2);

            } catch (IOException ex) {
                Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //======================================================================read data event
        readData.setOnAction(e -> {
            readfile(fileName, window, gameOverStage);
        });
        exit.setOnAction(e -> {
            window.close();
            gameOverStage.close();
        });
    }

    /**
     *
     * @param fileName - to open a file and read data
     * @param window - for exit button
     * @param gameOverStage -for exit button
     */
    public void readfile(TextField fileName, Stage window, Stage gameOverStage) {
        Stage info = new Stage();
        GridPane displayPane = new GridPane();
        displayPane.setAlignment(Pos.CENTER);
        displayPane.setPadding(new Insets(10, 10, 10, 10));
        displayPane.setHgap(40);
        displayPane.setVgap(20);//readfile(window, fileName);
        Button exitAll = new Button("Exit");
        int i = 0;
        Label QQ, AA;
        Label space = new Label("                    ");
        displayPane.add(space, 0, 0);
        try (
                ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName.getText() + ".dat")));) {

            String[] getQQ = (String[]) (input.readObject());
            String[] getAA = (String[]) (input.readObject());
            for (i = 0; getQQ[i] != null; i++) {
                QQ = new Label(getQQ[i]);
                displayPane.add(QQ, 3, i + 1);
                AA = new Label(getAA[i]);
                displayPane.add(AA, 4, i + 1);
                QQ.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, WORDSIZE));
                AA.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, WORDSIZE));
                QQ.setAlignment(Pos.CENTER);
                AA.setAlignment(Pos.CENTER);
            }

        } catch (IOException ex) {
            Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        displayPane.add(exitAll, 4, i + 1);
        exitAll.setOnAction(e -> {
            window.close();
            gameOverStage.close();
            info.close();
        });
        ScrollPane displayInfo = new ScrollPane(displayPane);

        Scene displayData = new Scene(displayInfo, W, L);
        info.setScene(displayData);
        info.setTitle("Info"); // Set the stagtitle
        info.show(); // Display the stage
    }
}
