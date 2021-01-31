package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    public Tile(int x, int y){
        setWidth(Main.Tile_Size);
        setHeight(Main.Tile_Size);

        setFill(Color.PINK);
        setStroke(Color.BLACK);
    }

}