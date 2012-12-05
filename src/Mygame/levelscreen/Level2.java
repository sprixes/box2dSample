package Mygame.levelscreen;

import Mygame.Test;
import Mygame.Testscreen;

import com.badlogic.gdx.Game;

public class Level2 extends Testscreen {

	public Level2(Game game, Test test) {
		super(game, test);
		/* finish */
		createFinish(180, 340);
		createFinish(1000, 340);

		createMonster(1, 200, 50);
		createMonster(2, 800, 50);
		/* character */
		createCandy(1, 1000, 710);
		createCandy(2, 180, 710);
		// createCandy(3, 400, 200);
		// createCandy(4, 400, 200);

		/* Ground Box */

		createGroundGreen(1, 180, 600);
		createGroundGreen(1, 1000, 600);
		// createGroundGreen(2, 600, 670);

		// createGroundWhite(1, 100, 300);
		// createGroundWhite(2, 200, 300);
		// createGroundWhite(3, 300, 300);
		// createGroundWhite(4, 400, 300);
		// createGroundWhite(5, 500, 300);
		// createGroundWhite(6, 600, 300);

		// createGroundFixed(1, 600, 300, 0);
		// createGroundFixed(2, 700, 100, 45);
		// createGroundFixed(3, 100, 100, 45);
		// createGroundFixed(4, 300, 100, 45);
		// createGroundFixed(5, 600, 100, 45);
		createGroundFixed(6, 180, 300, 0);
		createGroundFixed(6, 1000, 300, 0);
	}

}
