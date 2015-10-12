/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.nio.channels.Channels;
import javafx.scene.canvas.Canvas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author superanguri
 */
public class MainLoader extends Application{
    
    
        @Override
        public void start(Stage primaryStage) throws Exception {
            
            Sprite s = new Sprite(18, 31, 3, 0, "/game/spritesheet/PeachSSR.png");
            Character ch = new Character(s, 2, 0, 0);
            
            ch.setLeftWalk(3,4,5);
            ch.setRightWalk(0,1,2);
            
            Canvas c = new Canvas(1000,1000);
            
            BorderPane root = new BorderPane(c);
            
            
            for(int a:ch.getLeftWalk())
                c.getGraphicsContext2D().drawImage(ch.getSpritesheet().getAFRAMES().get(a), 50*a, 0);
            
            for(int a:ch.getRightWalk())
                c.getGraphicsContext2D().drawImage(ch.getSpritesheet().getAFRAMES().get(a), 50*a, 30);
            
            Scene scene = new Scene(root);
            
            primaryStage.setScene(scene);
            primaryStage.setTitle("Sprite");
            primaryStage.show();
        }
    
    public static void main(String[] args){
        launch(args);
    }
}
