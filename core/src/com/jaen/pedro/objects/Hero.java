package com.jaen.pedro.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.jaen.pedro.utils.Assets;
import com.jaen.pedro.utils.Utils;

public class Hero {
    TiledMap map;
    Rectangle rectangle;

    public Hero(TiledMap map, Rectangle rectangle) {
        this.map = map;
        this.rectangle = rectangle;
    }

    public void render(SpriteBatch batch){
        TextureRegion region= Assets.instance.heroeAssets.stand;
        Utils.drawTextureRegion(batch,region,rectangle.getX(),rectangle.getY());
    }
}
