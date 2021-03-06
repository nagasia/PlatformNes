package com.jaen.pedro.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;

public class Floor {
    private TiledMap map;
    private Rectangle rectangle;
    private float top;
    private float bottom;
    private float left;
    private float right;

    public Floor(TiledMap map, Rectangle rectangle) {
        this.map = map;
        this.rectangle = rectangle;
        top=rectangle.getY()+rectangle.getHeight();
        bottom=rectangle.getY();
        left=rectangle.getX();
        right=rectangle.getX()+rectangle.getWidth();
    }

    public TiledMap getMap() {
        return map;
    }

    public void setMap(TiledMap map) {
        this.map = map;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public float getTop() {
        return top;
    }

    public float getLeft() {
        return left;
    }

    public float getRight() {
        return right;
    }

}
