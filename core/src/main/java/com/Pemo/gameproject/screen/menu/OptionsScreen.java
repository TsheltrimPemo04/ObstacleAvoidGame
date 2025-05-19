package com.Pemo.gameproject.screen.menu;

import com.Pemo.gameproject.ObstacleAvoidGame;
import com.Pemo.gameproject.assets.AssetDescriptors;
import com.Pemo.gameproject.common.GameManager;
import com.Pemo.gameproject.config.DifficultyLevel;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Logger;



public class OptionsScreen extends MenuScreenBase {

    private static final Logger log = new Logger(OptionsScreen.class.getName(), Logger.DEBUG);

    private ButtonGroup<CheckBox> checkBoxGroup;
    private CheckBox easy;
    private CheckBox medium;
    private CheckBox hard;

    public OptionsScreen(ObstacleAvoidGame game) {
        super(game);
    }


    @Override
    protected Actor createUi() {
        Table table = new Table();
        table.defaults().pad(15);

        Skin uiSkin = assetManager.get(AssetDescriptors.UI_SKIN);


        Texture backgroundTexture = assetManager.get(AssetDescriptors.BACKGROUND);
        TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(new TextureRegion(backgroundTexture));
        table.setBackground(backgroundDrawable);

        // label
        Label label = new Label("DIFFICULTY", uiSkin);

        easy = checkBox(DifficultyLevel.EASY.name(), uiSkin);
        medium = checkBox(DifficultyLevel.MEDIUM.name(), uiSkin);
        hard = checkBox(DifficultyLevel.HARD.name(), uiSkin);

        checkBoxGroup = new ButtonGroup<CheckBox>(easy, medium, hard);

        final DifficultyLevel difficultyLevel = GameManager.INSTANCE.getDifficultyLevel();
        checkBoxGroup.setChecked(difficultyLevel.name());

        TextButton backButton = new TextButton("BACK", uiSkin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                back();
            }
        });

        ChangeListener listener = new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                difficultyChanged();
            }
        };

        easy.addListener(listener);
        medium.addListener(listener);
        hard.addListener(listener);

        // setup table
        Table contentTable = new Table(uiSkin);
        contentTable.defaults().pad(10);
//        contentTable.setBackground(RegionNames.PANEL);

        contentTable.add(label).row();
        contentTable.add(easy).row();
        contentTable.add(medium).row();
        contentTable.add(hard).row();
        contentTable.add(backButton);

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

    private void difficultyChanged() {
        log.debug("difficultyChanged()");
        CheckBox checked = checkBoxGroup.getChecked();

        if (checked == easy) {
            log.debug("easy");
            GameManager.INSTANCE.updateDifficulty(DifficultyLevel.EASY);
        } else if (checked == medium) {
            log.debug("medium");
            GameManager.INSTANCE.updateDifficulty(DifficultyLevel.MEDIUM);
        } else if (checked == hard) {
            log.debug("hard");
            GameManager.INSTANCE.updateDifficulty(DifficultyLevel.HARD);
        }
    }

    private static CheckBox checkBox(String text, Skin skin) {
        CheckBox checkBox = new CheckBox(text, skin);
        checkBox.left().pad(8);
        checkBox.getLabelCell().pad(8);
        return checkBox;
    }
}
