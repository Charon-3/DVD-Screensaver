package com.charon.DVDscreenserver;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Sprite {

    private float x;
    private float y;
    private float width;
    private float height;
    private float speed;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }


    public abstract void draw(Graphics g);

    public boolean hitTestObject(Sprite s) {
        Rectangle thisRectangle = new Rectangle(
                Math.round(x),
                Math.round(y),
                Math.round(width),
                Math.round(height)
        );
        Rectangle sRectangle = new Rectangle(
                Math.round(s.getX()),
                Math.round(s.getY()),
                Math.round(s.getWidth()),
                Math.round(s.getHeight())
        );

        return thisRectangle.intersects(sRectangle);
    }

    public void up() {}
    public void down() {}
    public void left() {}
    public void right() {}
    public void speed(float f) {}


}