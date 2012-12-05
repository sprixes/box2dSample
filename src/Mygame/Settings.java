package Mygame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver.Resolution;
import com.badlogic.gdx.graphics.Texture;

public class Settings {

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 800;

	public static boolean musicEnabled = true;
	public static boolean soundEnabled = true;

	public static AssetManager getAssetManager() {

		Resolution[] resolutions = { new Resolution(480, 320, ".480320"), new Resolution(800, 480, ".800480"), new Resolution(856, 480, ".856480"), new Resolution(1280, 800, ".1280800") };
		ResolutionFileResolver resolver = new ResolutionFileResolver(new InternalFileHandleResolver(), resolutions);

		AssetManager assetManager = new AssetManager();
		assetManager.setLoader(Texture.class, new TextureLoader(resolver));

		Texture.setAssetManager(assetManager);

		return assetManager;
	}

}
