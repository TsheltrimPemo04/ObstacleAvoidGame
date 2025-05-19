package com.Pemo.gameproject.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.audio.Music;

public class AssetDescriptors {

    public static final AssetDescriptor<Texture> BACKGROUND =
        new AssetDescriptor<Texture>(AssetPaths.BACKGROUND, Texture.class);

    public static final AssetDescriptor<Music> BACKGROUND_MUSIC =
        new AssetDescriptor<>(AssetPaths.MUSIC, Music.class);

    public static final AssetDescriptor<Texture> PLAYER =
        new AssetDescriptor<Texture>(AssetPaths.PLAYER, Texture.class);

    public static final AssetDescriptor<Texture> OBSTACLE =
        new AssetDescriptor<Texture>(AssetPaths.OBSTACLE, Texture.class);

    public static final AssetDescriptor<Sound> HIT_SOUND =
        new AssetDescriptor<Sound>(AssetPaths.HIT_SOUND, Sound.class);

    public static final AssetDescriptor<Skin> UI_SKIN =
        new AssetDescriptor<Skin>(AssetPaths.UI_SKIN, Skin.class);

    public static final AssetDescriptor<BitmapFont> FONT =
        new AssetDescriptor<BitmapFont>(AssetPaths.UI_FONT, BitmapFont.class);

    private AssetDescriptors() {}
}
