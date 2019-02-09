package com.charon.DVDscreenserver;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;
import com.charon.DVDscreenserver.Mainclass;


public class Render extends JPanel{

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Timer t;
	private static Timer ticks;
    private Sprite dvd;
    private Boolean left = false;
    private Boolean right = false;
    private Boolean up = false;
    private Boolean down = false;
    
    private int hit = 0;
    private int cornerHit = 0;
    
    private int randomX = (int) (Math.random()*10);
    private int randomY = (int) (Math.random()*10);
    
    public Render(){
        t = new Timer(1000/Mainclass.getFPS(), new UpdateScreenTimerListener());
        ticks = new Timer(1000/Mainclass.getSpeed(), new TicksTimerListener());
        
        if (randomX > 5 ) {
        	left = true;
        }
        else {
        	right = true;
        }
        
        
        if (randomY > 5 ) {
        	up = true;
        }
        else {
        	down = true;
        }
        
        dvd = new DVD();
        Mainclass.getInstance();
		dvd.setX(Mainclass.getWindowW()/2f);
        Mainclass.getInstance();
		dvd.setY(Mainclass.getWindowH()/2f);
        t.start();
        ticks.start();
        
    }
   
    
    private class TicksTimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
	           if (dvd.getX() == 0f) {
	        	   left = false;
	        	   right = true;
	        	   hit++;
	           }
	           if (dvd.getX() == Mainclass.getWindowW()-DVD.getImageWidth()) {
	        	   left = true;
	        	   right = false;
	        	   hit++;
	           }
	           if (dvd.getY() == 0f) {
	        	   up = false;
	        	   down = true;
	        	   hit++;
	           }
	           if (dvd.getY() == Mainclass.getWindowH()-DVD.getImageHeight()-20) {
	        	   up = true;
	        	   down = false;
	        	   hit++;
	           }
	           
	           if (dvd.getX() == 1f && dvd.getY() <= 1f) {
	        	   cornerHit++; 	   
	           }
	           if (dvd.getX() == Mainclass.getWindowW()-DVD.getImageWidth() && dvd.getY() == (Mainclass.getWindowH()-DVD.getImageHeight())) {
	        	   cornerHit++; 
	           }
	           
	           
	           if (left == true) {
	        	   dvd.left();
	           }
	           if (right == true) {
	        	   dvd.right();
	           }
	           if (up == true) {
	        	   dvd.up();
	           }
	           if (down == true) {
	        	   dvd.down();
	           }
		}
    	
    }
    
    private class UpdateScreenTimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            repaint();
        }
    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.setColor(new Color(0, 0, 0, 255));
        g.fillRect(0, 0, (int)Mainclass.getWindowW(), (int)Mainclass.getWindowH());
        g.setColor(new Color(255, 255, 255, 255));
        g.setFont(new Font("Arial", Font.PLAIN, 15));
        if (Mainclass.getTextEnable()==true) {
            g.drawString("Hit : " + String.valueOf(hit), 10, 15);
            g.drawString("Corner Hit : " + String.valueOf(cornerHit), 10, 30);
        }
        dvd.draw(g);

    }
}
