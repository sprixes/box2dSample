package Mygame.levelscreen;

import Mygame.Test;
import Mygame.Testscreen;

import com.badlogic.gdx.Game;

public class Level3 extends Testscreen {

	public Level3(Game game, Test test) {
		super(game, test);
		createCandy(1, 700, 350);
		createFinish(700, 200);
		createGroundWhite(6, 700, 220);
		createGroundWhite(6, 700, 250);
		createGroundWhite(6, 700, 300);

	}

}
