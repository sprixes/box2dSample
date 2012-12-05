package Mygame.monsters;

import utils.DynamicAnimation;
import Mygame.Assets;
import Mygame.Testscreen;

public class MonsterPink extends Monster {
	public MonsterPink(Testscreen stage) {
		this.stage = stage;

		initializeWalkingState();
		initializeDeadState();
	}

	public void initializeWalkingState() {
		walkingState = new DynamicAnimation(0.10f, Assets.atlas.findRegions("dragon/dragonPinkWalk/image"));
	}

	public void initializeDeadState() {
		deadState = new DynamicAnimation(0.10f, Assets.atlas.findRegions("dragon/dragonPinkDead/image"));
		deadState.isPlaying = false;
		deadState.isRepeating = false;
	}
}
