package Mygame.levelscreen;

import Mygame.Test;
import Mygame.Testscreen;

import com.badlogic.gdx.Game;

public class Level4 extends Testscreen {

	public Level4(Game game, Test test) {
		super(game, test);
		createFinish(600, 240);
		createCandy(1, 500, 320);
		createCandy(2, 450, 320);
		createCandy(3, 350, 320);
		createCandy(4, 320, 320);
		createStick(1, 410, 300, 0);
		createGroundGreen(1, 320, 240);
		createGroundGreen(1, 320, 280);

		createGroundGreen(1, 500, 240);
		createGroundGreen(1, 500, 280);
		for (int index = 0; index < 8; index++) {
			createGroundFixed(1, 200 + (60 * index), 200, 0);
		}

	}
}
