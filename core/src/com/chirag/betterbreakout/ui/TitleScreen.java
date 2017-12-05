package com.chirag.betterbreakout.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.chirag.betterbreakout.BetterBreakout;

public class TitleScreen {
    private BitmapFont bigTitleFont;
    private GlyphLayout glyphLayout;
    private Button playButton;
    private Button quitButton;

    public TitleScreen(BitmapFont font, BitmapFont bigFont) {
        BitmapFont titleFont = font;
        bigTitleFont = bigFont;
        glyphLayout = new GlyphLayout();
        playButton = new Button(font, "Play", BetterBreakout.GAME_FULLWIDTH / 2, BetterBreakout.GAME_HEIGHT / 2);
        quitButton = new Button(font, "Quit", BetterBreakout.GAME_FULLWIDTH / 2 , BetterBreakout.GAME_HEIGHT / 2 - 150);
    }

    public void update() {
        if(playButton.isClicked()) {
            System.out.println("click");
            BetterBreakout.setCurrentScreen(BetterBreakout.Screen.GAME);
        }
        if(quitButton.isClicked()) {
            System.out.println("click");
            Gdx.app.exit();
        }
    }

    public void draw(SpriteBatch batch) {
        glyphLayout = new GlyphLayout(bigTitleFont, "Better Breakout");
        bigTitleFont.draw(batch, "Better Breakout", BetterBreakout.GAME_FULLWIDTH / 2 - glyphLayout.width / 2, BetterBreakout.GAME_HEIGHT / 2 - glyphLayout.height/2 + 400);
        playButton.draw(batch);
        quitButton.draw(batch);
    }
}