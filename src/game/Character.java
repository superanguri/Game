/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

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
    
    //MoveSpeed is for the speed the sprite moves from one place to another
    private int moveSpeed;
    
    private ArrayList<Integer> walkLeft = new ArrayList<>();
    private ArrayList<Integer> walkRight = new ArrayList<>();
    
    public Character(Sprite spritesheet, int moveSpeed, int xPos, int yPos){
        this.spritesheet = spritesheet;
        this.xPos = xPos;
        this.yPos = yPos;
        this.moveSpeed = moveSpeed;
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
    
    
}
