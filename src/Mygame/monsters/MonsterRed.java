package Mygame.monsters;

import utils.DynamicAnimation;
import Mygame.Assets;
import Mygame.Testscreen;

public class MonsterRed extends Monster {
	public MonsterRed(Testscreen stage) {
		this.stage = stage;
		initializeWalkingState();
		initializeDeadState();

	}

	public void initializeWalkingState() {
		walkingState = new DynamicAnimation(0.10f, Assets.atlas.findRegions("dragon/dragonRedWalk/image"));
	}

	public void initializeDeadState() {
		deadState = new DynamicAnimation(0.10f, Assets.atlas.findRegions("dragon/dragonRedDead/image"));
		deadState.isPlaying = false;
		deadState.isRepeating = false;
	}
}
