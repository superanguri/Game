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
        
        
    }
    
    private WritableImage getSubImage(WritableImage img, int xS, int yS, int xE, int yE){
        
        
    }
    
    private WritableImage bImageTowImage(BufferedImage img){
        
        WritableImage image = new WritableImage(img.getWidth(), img.getHeight());
        
        for(int y = 0; y < image.getHeight(); y++)
            for(int x = 0; x < image.getWidth(); x++)
                image.getPixelWriter().setArgb(x, y, img.getRGB(x, y));
        
        return image;
    }
}