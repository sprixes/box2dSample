package Mygame;

import utils.DynamicDisplay;
import utils.DynamicScreen.DynamicCamera;
import Mygame.levelscreen.Level1;
import Mygame.levelscreen.Level2;
import Mygame.levelscreen.Level3;
import Mygame.levelscreen.Level4;
import aurelienribon.tweenengine.Tween;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Test extends Game {
	int currentAreaNum;
	int currentLevelNum;
	Testscreen currentLevel;

	@Override
	public void create() {
		Gdx.graphics.setVSync(true);
		initTween();
		// setScreen(new Testscreen(this));
		// setScreen(new Level1(this));
		// setScreen(new Level2(this));
		// setScreen(new Level4(this));
		switchToLevel(1, 1);

	}

	public void switchToLevel(int area, int level) {
		switch (area) {
			case 1:
				switch (level) {
					case 1:
						currentLevel = new Level1(this, this);
						break;
					case 2:
						currentLevel = new Level2(this, this);
						break;
					case 3:
						currentLevel = new Level3(this, this);
						break;
					case 4:
						currentLevel = new Level4(this, this);
						break;
				}
		}
		if (currentLevel == null)
			Gdx.app.exit();
		currentAreaNum = area;
		currentLevelNum = level;
		setScreen(currentLevel);
	}

	public void resetScreen() {
		if (currentLevel == null) {
			Gdx.app.exit();
		}

		setScreen(currentLevel);
	}

	public void nextLevel() {
		switchToLevel(currentAreaNum, ++currentLevelNum);
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		super.render();

	}

	private void initTween() {
		Tween.ensurePoolCapacity(20);
		Tween.registerAccessor(DynamicCamera.class, new DynamicCamera());
		Tween.registerAccessor(DynamicDisplay.class, new DynamicDisplay() {

			@Override
			public Rectangle getBounds() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getValues(DynamicDisplay arg0, int arg1, float[] arg2) {
				return 0;
			}

			@Override
			public void render(SpriteBatch spriteBatch) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setRegistration(DynamicRegistration registration) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setValues(DynamicDisplay arg0, int arg1, float[] arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void update(float deltaTime) {
				// TODO Auto-generated method stub

			}

		});
	}
}
