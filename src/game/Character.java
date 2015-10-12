/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author superanguri
 */


/**
 * This is just what's necessary for a character
 * if there's something else you need, just make your own character class and extend this
 * one.
*/
public class Character {
    
    private Sprite spritesheet;
    
    private int xPos;
    private int yPos;
    
    private int dropOut;
    
    //MoveSpeed is for the speed the sprite moves from one place to another
    private int moveSpeed;
    
    private ArrayList<Integer> walkLeft = new ArrayList<>();
    private ArrayList<Integer> walkRight = new ArrayList<>();
    
    public Character(int frameWidth, int frameHight, int frames, int spacing, String path, int moveSpeed, int xPos, int yPos) throws IOException{
        this.spritesheet = spritesheet;
        this.xPos = xPos;
        assert this.xPos >= 0;
        this.yPos = yPos;
        assert this.yPos >= 0;
        this.moveSpeed = moveSpeed;
        
        spritesheet = new Sprite(frameWidth, frameHight, frames, spacing, path);
    }
    
    public void setLeftWalk(int...position){
        
        for(int a:position)
            walkLeft.add(a);
    }
    
    public void setRightWalk(int...position){
        
        for(int a:position)
            walkRight.add(a);
    }

    public ArrayList<Integer> getRightWalk(){
        return walkRight;
    }
    
    public ArrayList<Integer> getLeftWalk(){
        return walkLeft;
    }
    
    public Sprite getSpritesheet() {
        return spritesheet;
    }

    public void setSpritesheet(Sprite spritesheet) {
        this.spritesheet = spritesheet;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
    
    public Rectangle2D getBounds(){
        
        return new Rectangle2D(getxPos(), getyPos(), spritesheet.getWIDTH(), spritesheet.getHEIGHT());
    }
    
    public boolean intersects(Character character){
        return getBounds().intersects(character.getBounds());
    }
    
    public void setDropOut(int dropOut){
        this.dropOut = dropOut;
    }
    
    public int getDropOut(){
        return dropOut;
    }
    
    //Überarbeiten...vielleicht werden Animationen aus einem Thread aus gestartet,
    //würde zu viel werden, wenn für jede Animation ein Thread gestartet würde
    public void stepLeft(GraphicsContext gc){
        System.out.println("startet");
        new Thread(new Runnable(){
            
            @Override
            public void run(){
                for(int a:walkLeft){
                    gc.clearRect(0, 0, 1000, 30);
                    gc.drawImage(spritesheet.getAFRAMES().get(a), xPos, yPos);
                    try {
                        Thread.sleep(dropOut);
                    } catch (InterruptedException ex) {
                        System.out.println("löl");
                    }
                    xPos-=moveSpeed;
                }
            }
        }).start();
        System.out.println("sollte laufen...");
    }
    
    public void stepRight(GraphicsContext gc){
        new Thread(new Runnable(){
            
            @Override
            public void run(){
                for(int a:walkRight){
                    gc.clearRect(0, 0, 1000, 30);
                    gc.drawImage(spritesheet.getAFRAMES().get(a), xPos, yPos);
                    try {
                        Thread.sleep(dropOut);
                    } catch (InterruptedException ex) {
                    }
                    xPos+=moveSpeed;
                }
            }
        }).start();
    }
}
