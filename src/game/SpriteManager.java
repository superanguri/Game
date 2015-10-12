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
public class SpriteManager {
    
    ArrayList<Character> sprites = new ArrayList<>();
    
    public SpriteManager(){
        
    }

    public Character getSprites(int position) {
        return sprites.get(position-1);
    }

    public void setSprite(Character sprite) {
        sprites.add(sprite);
    }
    
    public void removeSprite(int position){
        sprites.remove(position);
    }
    
    public void removeSprite(Character figure){
        sprites.remove(figure);
        System.out.println("removed");
    }
    
    public int getSize(){
        return sprites.size();
    }
    
    public ArrayList<Character> getList(){
        return sprites;
    }
}
