package Mygame.stick;

import utils.DynamicDisplay;
import utils.DynamicSprite;
import Mygame.Assets;
import Mygame.Testscreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class stick extends DynamicDisplay {

	public DynamicSprite target;

	protected Testscreen stage;

	public stick(Testscreen stage, int type) {
		this.stage = stage;
		switch (type) {
			case 1:
				target = new DynamicSprite(Assets.atlas.findRegion("stick/image1"), 0, 0);
				break;
			case 2:
				target = new DynamicSprite(Assets.atlas.findRegion("stick/image2"), 0, 0);
				break;
			case 3:
				target = new DynamicSprite(Assets.atlas.findRegion("stick/image3"), 0, 0);
				break;
			case 4:
				target = new DynamicSprite(Assets.atlas.findRegion("stick/image4"), 0, 0);
				break;
			case 5:
				target = new DynamicSprite(Assets.atlas.findRegion("stick/image5"), 0, 0);
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
