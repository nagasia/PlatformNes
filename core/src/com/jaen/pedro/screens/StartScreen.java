package com.jaen.pedro.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.jaen.pedro.PlatformNesGame;
import com.jaen.pedro.utils.Constants;
import com.jaen.pedro.utils.Enums;

public class StartScreen extends InputAdapter implements Screen {
    SpriteBatch batch;
    ExtendViewport viewport;
    BitmapFont font;
    PlatformNesGame game;
    Music music;

    public StartScreen(PlatformNesGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        viewport=new ExtendViewport(Constants.WORLD_SIZE,Constants.WORLD_SIZE);
        batch=new SpriteBatch();

        Gdx.input.setInputProcessor(this);

        font=new BitmapFont();
        font = new BitmapFont(Gdx.files.internal(Constants.FONT_FILE));
        font.getData().setScale(Constants.FONT_SCALE);

        if(!game.isMute()){
            game.suenaMusica(Constants.MUSICA_INICIO);
        }
    }



    @Override
    public void render(float delta) {
        viewport.apply();

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //pintamos las letras
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        font.draw(batch,
                Constants.TITLE,
                viewport.getWorldWidth()/2,
                viewport.getWorldHeight()/2,
                0, Align.center,false);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height,true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        game.setMenuScreen();
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        game.setMenuScreen();
        return true;
    }
}
