package com.charon.DVDscreenserver;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class DVD extends Sprite {
    private static Image image;
    private float vx;
    private float vy;

    public DVD() {
        image = (new ImageIcon(getClass().getResource("/DVD_logo.png"))).getImage();
        setHeight(image.getHeight(null));
        setWidth(image.getWidth(null));
        vx = 2f;
        vy = 2f;

    }
    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
        g.drawImage(image, Math.round(getX()), Math.round(getY()), null);
    }
    
    public static float getImageWidth() {
    	return image.getWidth(null);
    }
    public static float getImageHeight() {
    	return image.getHeight(null);
    }

    public void up() {
        float curY = getY();
        curY -= vy;
        setY(curY);
    }
    public void down() {
        setY(getY() + vy);
    }
    public void left() {
        setX(getX() - vx);
    }
    public void right() {
        setX(getX() + vx);

    }


}
