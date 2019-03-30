package com.jaen.pedro.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jaen.pedro.PlatformNesGame;
import com.jaen.pedro.utils.Constants;

import java.util.ArrayList;

public class ScoreScreen extends InputAdapter implements Screen {
    PlatformNesGame game;
    SpriteBatch batch;
    FitViewport viewport;
    BitmapFont font;
    BitmapFont lilFont;
    ArrayList<Long> puntuaciones;

    public ScoreScreen(PlatformNesGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch=new SpriteBatch();
        viewport=new FitViewport(Constants.WORLD_SIZE,Constants.WORLD_SIZE);

        Gdx.input.setInputProcessor(this);

        font=new BitmapFont();
        font = new BitmapFont(Gdx.files.internal(Constants.FONT_FILE));
        font.getData().setScale(Constants.FONT_SCALE);
        lilFont=new BitmapFont();
        lilFont = new BitmapFont(Gdx.files.internal(Constants.FONT_FILE));
        lilFont.getData().setScale(Constants.FONT_LIL_SCALE);

        game.getPreferencias().cargaPuntuaciones();
        puntuaciones=game.getPreferencias().getPuntuaciones();
    }

    @Override
    public void render(float delta) {
        viewport.apply();

        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r,
                Constants.BACKGROUND_COLOR.g,
                Constants.BACKGROUND_COLOR.b,
                Constants.BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //pintamos las letras
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        font.draw(batch,
                Constants.SCORES,
                Constants.SCORES_POSITION.x,
                Constants.SCORES_POSITION.y,
                0, Align.center,false);

        int contador=1;

        for(float i=(Constants.WORLD_SIZE/2)+140;contador<6;i-=70f, contador++){
            lilFont.draw(batch,
                    contador+" - "+puntuaciones.get(contador-1),
                    Constants.SCORES_POSITION.x,
                    i,
                    0, Align.center,false);
        }

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
        lilFont.dispose();
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
