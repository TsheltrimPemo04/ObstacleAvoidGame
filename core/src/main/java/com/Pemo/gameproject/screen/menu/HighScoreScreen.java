package com.Pemo.gameproject.screen.menu;

import com.Pemo.gameproject.ObstacleAvoidGame;
import com.Pemo.gameproject.assets.AssetDescriptors;
import com.Pemo.gameproject.common.GameManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Logger;

public class HighScoreScreen extends MenuScreenBase {

    private static final Logger log = new Logger(HighScoreScreen.class.getName(), Logger.DEBUG);

    public HighScoreScreen(ObstacleAvoidGame game) {
        super(game);
    }

    @Override
    protected Actor createUi() {
        Table table = new Table();
        Skin uiSkin = assetManager.get(AssetDescriptors.UI_SKIN);

        // ✅ Load background from direct texture
        Texture backgroundTexture = assetManager.get(AssetDescriptors.BACKGROUND);
        TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundTexture));
        table.setBackground(backgroundDrawable);

        // Highscore title label
        Label highScoreText = new Label("HIGHSCORE", uiSkin);

        // Highscore value label
        String highScoreString = GameManager.INSTANCE.getHighScoreString();
        Label highScoreLabel = new Label(highScoreString, uiSkin);

        // Back button
        TextButton backButton = new TextButton("BACK", uiSkin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                back();
            }
        });

        // Setup content table without RegionNames
        Table contentTable = new Table(uiSkin);
        contentTable.defaults().pad(20);

        contentTable.add(highScoreText).row();
        contentTable.add(highScoreLabel).row();
        contentTable.add(backButton).row();

        contentTable.center();

        table.add(contentTable);
        table.center();
        table.setFillParent(true);
        table.pack();

        return table;
    }

    private void back() {
        log.debug("back()");
        game.setScreen(new MenuScreen(game));
    }
}
