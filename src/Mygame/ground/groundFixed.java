package Mygame.ground;

import utils.DynamicDisplay;
import utils.DynamicSprite;
import Mygame.Assets;
import Mygame.Testscreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class groundFixed extends DynamicDisplay {

	public DynamicSprite target;

	protected Testscreen stage;

	public groundFixed(Testscreen stage, int type) {
		this.stage = stage;
		switch (type) {
			case 1:
				target = new DynamicSprite(Assets.atlas.findRegion("groundBox/imageBrown1"), 0, 0);
				break;
			case 2:
				target = new DynamicSprite(Assets.atlas.findRegion("groundBox/imageBrown2"), 0, 0);
				break;
			case 3:
				target = new DynamicSprite(Assets.atlas.findRegion("groundBox/imageBrown3"), 0, 0);
				break;
			case 4:
				target = new DynamicSprite(Assets.atlas.findRegion("groundBox/imageBrown4"), 0, 0);
				break;
			case 5:
				target = new DynamicSprite(Assets.atlas.findRegion("groundBox/imageGreen1"), 0, 0);
				break;
			case 6:
				target = new DynamicSprite(Assets.atlas.findRegion("groundBox/imageGreen2"), 0, 0);
				break;
		}
	}

	@Override
	public Rectangle getBounds() {
		return target.getBounds();
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

	}

	@Override
	public void setRegistration(DynamicRegistration registration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float deltaTime) {
		target.update(deltaTime);
		updateTween();

	}

}
