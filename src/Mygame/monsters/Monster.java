package Mygame.monsters;

import utils.DynamicAnimation;
import utils.DynamicDisplay;
import Mygame.Testscreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * @author Sprixes
 * 
 */
public class Monster extends DynamicDisplay {

	public enum MonsterState {
		WALKING, DEAD
	}

	public MonsterState state = MonsterState.WALKING;

	public DynamicAnimation walkingState;
	public DynamicAnimation deadState;
	protected Testscreen stage;

	@Override
	public Rectangle getBounds() {
		if (getStateAnimation() != null) {
			return getStateAnimation().getBounds();
		}
		return null;
	}

	public DynamicAnimation getStateAnimation() {
		if (state == MonsterState.WALKING) {
			return walkingState;
		} else if (state == MonsterState.DEAD) {
			return deadState;
		} else {
			return null;
		}
	}

	@Override
	public void render(SpriteBatch spriteBatch) {
		if (visible) {
			spriteBatch.setColor(color.r, color.g, color.b, color.a);
			getStateAnimation().color.set(color);
			getStateAnimation().position.add(position);
			getStateAnimation().scale.set(scale.x, scale.y);
			getStateAnimation().setRotation(rotation);
			getStateAnimation().render(spriteBatch);
			getStateAnimation().position.sub(position);
		}

	}

	@Override
	public void setRegistration(DynamicRegistration registration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float deltaTime) {
		if (visible) {
			switch (state) {
				case WALKING:
					walkingState.update(deltaTime);
					break;
				case DEAD:
					deadState.update(deltaTime);
					break;

			}
			updateTween();

		}

	}

}
