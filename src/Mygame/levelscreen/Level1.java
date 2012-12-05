package Mygame.levelscreen;

import Mygame.Test;
import Mygame.Testscreen;

import com.badlogic.gdx.Game;

public class Level1 extends Testscreen {

	public Level1(Game game, Test test) {
		super(game, test);
		/* finish */
		createCandy(1, 600, 710);
		createFinish(600, 340);

		createMonster(1, 200, 200);
		createMonster(2, 400, 200);
		/* character */

		// createCandy(2, 400, 200);
		// createCandy(3, 400, 200);
		// createCandy(4, 400, 200);

		/* Ground Box */

		// createGroundGreen(1, 700, 600);
		createGroundGreen(2, 600, 670);

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
		createGroundFixed(6, 600, 300, 0);
	}

}
