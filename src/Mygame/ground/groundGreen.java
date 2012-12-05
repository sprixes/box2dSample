package Mygame.ground;

import utils.DynamicAnimation;
import utils.DynamicDisplay;
import Mygame.Assets;
import Mygame.Testscreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class groundGreen extends DynamicDisplay {
	Testscreen stage;
	DynamicAnimation target;
	public boolean remove = false;

	public groundGreen(Testscreen stage, int type) {
		this.stage = stage;
		switch (type) {
			case 1:
				target = new DynamicAnimation(0.10f, Assets.atlas.findRegions("BoxGreen/box1/image"));
				break;
			case 2:
				target = new DynamicAnimation(0.10f, Assets.atlas.findRegions("BoxGreen/box2/image"));
				break;
		}
		target.isPlaying = false;
		target.isRepeating = false;
	}

	@Override
	public Rectangle getBounds() {

		return target.getBounds();
	}

	public void click() {
		target.isPlaying = true;

	}

	@Override
	public void render(SpriteBatch spriteBatch) {
		if (visible) {
			spriteBatch.setColor(color.r, color.g, color.b, color.a);
			target.color.set(color);
			target.position.add(position);
			target.scale.set(scale.x, scale.y);
			target.setRotation(rotation);
			target.render(spriteBatch);
			target.position.sub(position);
		}
		if (target.frameIndex == 6) {
			remove = true;
		}

	}

	@Override
	public void setRegistration(DynamicRegistration registration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float deltaTime) {
		target.update(deltaTime);

	}

}
