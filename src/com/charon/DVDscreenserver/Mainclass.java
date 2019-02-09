package com.charon.DVDscreenserver;
import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Mainclass {
	private static int _w;
	private static int _h;
	private static int _speed;
	private static int _fps;
	private static Boolean _text;
	
    private static Mainclass instance;
    private JFrame frame;

    public static Mainclass getInstance() {
        if (instance == null) {
            instance = new Mainclass();
        }
        return instance;
    }

    //Main
    public static void main(String[] args) {
        Mainclass app = getInstance();
        /*
         * ========================
         * Set Window size
         * setWindowSize(Width, Height);
         * ========================
         */
        setWindowSize(1280, 720);
        
        /*
         * ========================
         * Set speed
         * setSpeed(speed);
         * ========================
         */
        setSpeed(60);
        
        /*
         * ========================
         * Set FPS
         * **More FPS == More CPU used
         * setFPS(fps);
         * ========================
         */
        setFPS(60);
        
        /*
         * ========================
         * Enable/Disable On screen Text
         * setTextEnable(true|false);
         * 
         */
        setTextEnable(true);
        
        app.init();
    }

    public static void setWindowSize(int w, int h) {
    	_w = w;
    	_h = h;
    }

    public static float getWindowW() {
    	return _w;
    } 
    
    public static float getWindowH() {
    	return _h;
    } 

    public static void setSpeed(int speed) {
    	_speed = speed;
    }
    
    public static int getSpeed() {
    	return _speed;
    } 

    public static void setFPS(int fps) {
    	_fps = fps;
    }
    
    public static int getFPS() {
    	return _fps;
    } 
    
    public static void setTextEnable(Boolean text) {
    	_text = text;
    }
    
    public static Boolean getTextEnable() {
    	return _text;
    } 
    
    public void init(){
        frame = new JFrame("DVD");
        JPanel panel = new Render();

        frame.add(panel, BorderLayout.CENTER);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int w = (int) (gd.getDisplayMode().getWidth()/2-(getWindowW()/2));
        int h = (int) (gd.getDisplayMode().getHeight()/2-(getWindowH()/2));
        frame.setLocation(w,h);
        frame.setSize((int)getWindowW(), (int)getWindowH());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);


    }
}
