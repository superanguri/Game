/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import control.KeyOverview;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author superanguri
 */
public class MainLoader extends Application{
    
    KeyOverview<String> keys = new KeyOverview<>();
    Sprite master;
    int xPos = 0;
    int yPos = 0;
    
    Canvas can;
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        
        can = new Canvas(500,500);
        
        master = new Sprite(152, 216, 2, "/game/spritesheet/kinJU.png", 0);
                
        can.getGraphicsContext2D().drawImage(master.getAFRAMES().get(0), xPos, yPos);
        
        StackPane root = new StackPane(can);
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sprite");
        primaryStage.show();
        
        scene.setOnKeyPressed(e->{
            keys.addAllKeys(e.getCode().toString());
        });
        
        scene.setOnKeyReleased(e->{
            keys.removeKey(e.getCode().toString());
        });
        
        new Thread(new Runnable(){
            
            @Override 
            public void run(){
                
                int sleep = 100;
                while (true) {                    
                    System.out.println(".");
                    if(keys.inList("RIGHT")){
                        can.getGraphicsContext2D().clearRect(0, 0, 1000, 1000);
                        can.getGraphicsContext2D().drawImage(master.getAFRAMES().get(1), xPos, yPos);
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainLoader.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    can.getGraphicsContext2D().clearRect(0, 0, 1000, 1000);
                    can.getGraphicsContext2D().drawImage(master.getAFRAMES().get(0), xPos, yPos);
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainLoader.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    xPos+=5;
                    }
                    
                    else if(keys.inList("LEFT")){
                        can.getGraphicsContext2D().clearRect(0, 0, 1000, 1000);
                        can.getGraphicsContext2D().drawImage(master.getAFRAMES().get(1), xPos, yPos);
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainLoader.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    can.getGraphicsContext2D().clearRect(0, 0, 1000, 1000);
                    can.getGraphicsContext2D().drawImage(master.getAFRAMES().get(0), xPos, yPos);
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainLoader.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    xPos-=5;
                    }
                    
                }
            }
        }).start();
        
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
}
