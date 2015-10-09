/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

/**
 *
 * @author superanguri
 */
public class Sprite {
    
    
    private final int FRAMES;
    
    private final int WIDTH;
    private final int HEIGHT;
    
    private final ArrayList<WritableImage> AFRAMES = new ArrayList<>();
    private final WritableImage SHEET;
    private WritableImage currentFrame;
    
    public Sprite(int width, int height, int frames, String path) throws IOException{
        FRAMES = frames;
        WIDTH = width;
        HEIGHT = height;
        
        SHEET = bImageTowImage(ImageIO.read(getClass().getResource(path)));
        
        manageStuff();
    }
    
    private void manageStuff(){
        
        for(int i = 0; i < FRAMES; i++){
            int xStart = WIDTH*i;
            int yStart = 0;
            int xEnd = ((WIDTH*(i+1))-1);
            int yEnd = HEIGHT-1;
            AFRAMES.add(getSubImage(SHEET, xStart, yStart, xEnd, yEnd));
        } 
                   
        
    }
    private WritableImage getSubImage(WritableImage img, int xS, int yS, int xE, int yE){
        
        WritableImage image = new WritableImage(WIDTH, HEIGHT);
        
        for(int y1 = 0; y1 < HEIGHT; y1++)
            for(int x1 = 0; x1 < WIDTH; x1++)
                image.getPixelWriter().setArgb(x1, y1, img.getPixelReader().getArgb(xS+x1, yS+y1));
        
        return image;
    }
        
    //Wird benötigt, um das durch die ImageIO.read Funktion geladene BufferedImage in ein WritableImage zu konvertieren
    //Es wird lediglich pixel für pixel abgeklappert...
    private WritableImage bImageTowImage(BufferedImage img){
        
        WritableImage image = new WritableImage((int)img.getWidth(), (int)img.getHeight());
        
        for(int y = 0; y < image.getHeight(); y++)
            for(int x = 0; x < image.getWidth(); x++)
                image.getPixelWriter().setArgb(x, y, img.getRGB(x, y));
        
        return image;
    }
    
    private WritableImage flipFrame(WritableImage img){
        WritableImage image = new WritableImage(WIDTH, HEIGHT);
        
        return image;
    }
}
