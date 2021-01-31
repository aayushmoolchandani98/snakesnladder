package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public int rand;
    public Label randResult;

    public int cirPos[][] = new int[10][10];
    public int leadderPositon[][] = new int[6][6];


    public static final int Tile_Size = 60;
    public static final int Width = 10;
    public static final int Height = 10;

    public Circle player1;
    public Circle player2;

    public int playerPosition1 = 1;
    public  int playerPosition2 = 1;

    public boolean player1Turn = true;
    public boolean player2Turn = true;

    public static int player1XPos = 30;
    public static int player1YPos = 570;

    public static int player2XPos = 30;
    public static int player2YPos = 570;

    public int posCir1 = 1;
    public int posCir2 = 1;

    public boolean gameStart = false;
    public Button gameButton;



    private Group tileGroup = new Group();

    private Parent createContent(){

        Pane root = new Pane();
        root.setPrefSize(Width*Tile_Size,(Height*Tile_Size)+60);//60          buttons
        root.getChildren().addAll(tileGroup);

        for(int i=0;i<Height;i++) {
            for (int j = 0; j < Width; j++) {
                Tile tile = new Tile(Tile_Size, Tile_Size);
                tile.setTranslateX(j * Tile_Size);
                tile.setTranslateY(i * Tile_Size);

                tileGroup.getChildren().add(tile);
                cirPos[i][j]=i*(Tile_Size-30);
            }
        }
        for (int i = 0; i<Width;i++)
        {
            for(int j = 0; j < Height; j++)
            {
                System.out.print(cirPos[i][j] + " ");
            }
            System.out.println();
        }
        player1 = new Circle(30);
        player1.setId("player1");
        player1.getStyleClass().add("style.css");
        player1.setFill(Color.YELLOW);
        player1.setTranslateX(player1XPos);
        player1.setTranslateY(player1YPos);

        player2 = new Circle(30);
        player2.setId("player2");
        player2.getStyleClass().add("sample/style.css");
        player1.setFill(Color.RED);
        player2.setTranslateX(player2XPos);
        player2.setTranslateY(player2YPos);

        Button button = new Button("PLAYER1");
        button.setTranslateX(10);
        button.setTextFill(Color.RED);
        button.setTranslateY(610);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart){
                    if(player1Turn){
                          diceVal();
                          randResult.setText(String.valueOf(rand));
                          move1player();
                          translatePlayer(player1XPos,player1YPos,player1);
                          player1Turn = false;
                          player2Turn = true;

                        // Ladders
                        if(player1XPos==150 && player1YPos==570){
                            translatePlayer(player1XPos= 90 ,player1YPos=390,player1);
                            posCir1++;
                        }
                        if(player1XPos==570 && player1YPos==570){
                            translatePlayer(player1XPos=510,player1YPos=510,player1);
                            posCir1++;
                        }
                        if(player1XPos==390 && player1YPos==450){
                            translatePlayer(player1XPos=450,player1YPos=270,player1);
                            posCir1++;
                        }
                        if(player1XPos==270 && player1YPos==270){
                            translatePlayer(player1XPos=210,player1YPos=90,player1);
                            posCir1++;
                        }
                        if(player1XPos==30 && player1YPos==210){
                            translatePlayer(player1XPos=90,player1YPos=30,player1);
                            posCir1++;
                        }
                        if(player1XPos==510 && player1YPos==150){
                            translatePlayer(player1XPos=570,player1YPos=90,player1);
                            posCir1++;
                        }

                      //SNAKES
                        if(player1XPos==270 && player1YPos==510){
                            translatePlayer(player1XPos= 450 ,player1YPos=510,player1);
                            posCir1++;
                        }
                        if(player1XPos==570 && player1YPos==390){
                            translatePlayer(player1XPos= 210 ,player1YPos=570,player1);
                            posCir1++;
                        }
                        if(player1XPos==390 && player1YPos==330){
                            translatePlayer(player1XPos=270,player1YPos=450,player1);
                            posCir1++;
                        }
                        if(player1XPos==150 && player1YPos==210){
                            translatePlayer(player1XPos=30,player1YPos=270,player1);
                            posCir1++;
                        }
                        if(player1XPos==330 && player1YPos==210){
                            translatePlayer(player1XPos=510,player1YPos=270,player1);
                            posCir1++;
                        }
                        if(player1XPos== 210 && player1YPos==30){
                            translatePlayer(player1XPos=330,player1YPos=150,player1);
                            posCir1++;
                        }
                    }
                }

            }
        });

        Button button2 = new Button("PLAYER2");
        button2.setTranslateX(530);
        button2.setTranslateY(610);
        button2.setTextFill(Color.RED);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart){
                    if(player2Turn){
                        diceVal();
                        randResult.setText(String.valueOf(rand));
                        move2player();
                        translatePlayer(player2XPos,player2YPos,player2);
                        player2Turn=false;
                        player1Turn=true;


                        // Ladders
                        if(player2XPos==150 && player2YPos==570){
                            translatePlayer(player2XPos= 90 ,player2YPos=390,player2);
                            posCir2++;
                        }
                        if(player2XPos==570 && player2YPos==570){
                            translatePlayer(player2XPos=510,player2YPos=510,player2);
                            posCir2++;
                        }
                        if(player2XPos==390 && player2YPos==450){
                            translatePlayer(player2XPos=450,player2YPos=270,player2);
                            posCir2++;
                        }
                        if(player2XPos==270 && player2YPos==270){
                            translatePlayer(player2XPos=210,player2YPos=90,player2);
                            posCir2++;
                        }
                        if(player2XPos==30 && player2YPos==210){
                            translatePlayer(player2XPos=90,player2YPos=30,player2);
                            posCir2++;
                        }
                        if(player2XPos==510 && player2YPos==150){
                            translatePlayer(player2XPos=570,player2YPos=90,player2);
                            posCir2++;
                        }

                        //SNAKES
                        if(player2XPos==270 && player2YPos==510){
                            translatePlayer(player2XPos= 450 ,player2YPos=510,player2);
                            posCir2++;
                        }
                        if(player2XPos==570 && player2YPos==390){
                            translatePlayer(player2XPos= 210 ,player2YPos=570,player2);
                            posCir2++;
                        }
                        if(player2XPos==390 && player2YPos==330){
                            translatePlayer(player2XPos=270,player2YPos=450,player2);
                            posCir2++;
                        }
                        if(player2XPos==150 && player2YPos==210){
                            translatePlayer(player2XPos=30,player2YPos=270,player2);
                            posCir2++;
                        }
                        if(player2XPos==330 && player2YPos==210){
                            translatePlayer(player2XPos=510,player2YPos=270,player2);
                            posCir2++;
                        }
                        if(player2XPos== 210 && player2YPos==30){
                            translatePlayer(player2XPos=330,player2YPos=150,player2);
                            posCir2++;
                        }

                    }
                }

            }
        });
       gameButton = new Button("START GAME");
       gameButton.setTranslateY(610);
       gameButton.setTranslateX(255);
       gameButton.setTextFill(Color.DARKCYAN);
        gameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               gameButton.setText("GAME STARTED");
               player1XPos = 30;
               player1YPos = 570;

                player2XPos = 30;
                player2YPos = 570;

                player1.setTranslateX(player1XPos);
                player1.setTranslateY(player1YPos);

                player2.setTranslateX(player2XPos);
                player2.setTranslateY(player2YPos);
                gameStart = true;


            }
        });

        randResult = new Label("0");
        randResult.setTranslateX(150);
        randResult.setTranslateY(610);


        Image img = new Image("snakebg.jpg");
        ImageView bgImage = new ImageView();
        bgImage.setImage(img);
        bgImage.setFitHeight(600);
        bgImage.setFitWidth(600);


        tileGroup.getChildren().addAll(bgImage,player1,player2,button,button2,gameButton,randResult);

        return  root;
        }

        private void diceVal(){
        rand = (int)(Math.random()*6+1);
        }
         private void move1player() {
        for(int i = 0 ; i < rand ; i++){
            if(posCir1%2 == 1){
                player1XPos += 60;
            }
            if(posCir1%2 == 0){
                player1XPos -= 60;
            }
            if(player1XPos>570){
                player1XPos-=60;
                player1YPos-=60;
                posCir1++;
            }
            if(player1XPos<30){
                player1XPos+=60;
                player1YPos-=60;
                posCir1++;
            }
            if(player1XPos<20 || player1YPos<20){
                player1XPos=30;
                player1YPos=30;
                gameStart = false;
                randResult.setText("Player 1 won");
                gameButton.setText("Start Again");
            }
        }
    }


    private void move2player() {
        for(int i = 0 ; i < rand ; i++){
            if(posCir2%2 == 1){
                player2XPos += 60;
            }
            if(posCir2%2 == 0){
                player2XPos -= 60;
            }
            if(player2XPos>570){
                player2XPos-=60;
                player2YPos-=60;
                posCir2++;
            }
            if(player2XPos<30){
                player2XPos+=60;
                player2YPos-=60;
                posCir2++;
            }
            if(player2XPos<20 || player2YPos<20){
                player2XPos=30;
                player2YPos=30;
                gameStart = false;
                randResult.setText("Player 2 won");
                gameButton.setText("Start Again");
            }
        }
    }
    private void translatePlayer(int x, int y, Circle b) {
        TranslateTransition animate = new TranslateTransition(Duration.millis(1000), b);
        animate.setToX(x);
        animate.setToY(y);
        animate.setAutoReverse(false);
        animate.play();
    }



            @Override
            public void start(Stage primaryStage) throws Exception{
                Scene scene = new Scene(createContent());
                primaryStage.setTitle("Snakes and Ladders");
                primaryStage.setScene(scene);
                primaryStage.show();
            }



            public static void main(String[] args) {
        launch(args);
    }
}
