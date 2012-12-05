package Mygame.finishBox;

import utils.DynamicAnimation;
import utils.DynamicDisplay;
import Mygame.Assets;
import Mygame.Testscreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class finishBox extends DynamicDisplay {
	protected Testscreen stage;
	protected DynamicAnimation target;

	public finishBox(Testscreen stage) {
		this.stage = stage;
		target = new DynamicAnimation(0.050f, Assets.atlas.findRegions("finishBox/image"));

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
