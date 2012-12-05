package Mygame.mainChar;

import utils.DynamicDisplay;
import utils.DynamicSprite;
import Mygame.Assets;
import Mygame.Testscreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Candy extends DynamicDisplay {

	public DynamicSprite idleState;
	protected Testscreen stage;

	/* int type of mainCharacter */
	public Candy(Testscreen stage, int type) {
		this.stage = stage;
		switch (type) {
			case 1:
				idleState = new DynamicSprite(Assets.atlas.findRegion("characters/image1"), 0, 0);
				break;

			case 2:
				idleState = new DynamicSprite(Assets.atlas.findRegion("characters/image2"), 0, 0);
				break;
			case 3:
				idleState = new DynamicSprite(Assets.atlas.findRegion("characters/image3"), 0, 0);
				break;
			case 4:
				idleState = new DynamicSprite(Assets.atlas.findRegion("characters/image4"), 0, 0);
				break;

			default:
				break;
		}
	}

	@Override
	public Rectangle getBounds() {
		return idleState.getBounds();

	}

	@Override
	public void render(SpriteBatch spriteBatch) {
		if (visible) {
			spriteBatch.setColor(color.r, color.g, color.b, color.a);
			idleState.color.set(color);
			idleState.position.add(position);
			idleState.scale.set(scale.x, scale.y);
			idleState.setRotation(rotation);
			idleState.render(spriteBatch);
			idleState.position.sub(position);
		}

	}

	@Override
	public void setRegistration(DynamicRegistration registration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float deltaTime) {
		if (visible) {
			idleState.update(deltaTime);
			updateTween();
		}

	}

}
