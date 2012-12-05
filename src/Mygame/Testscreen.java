package Mygame;

import java.util.ArrayList;

import utils.DynamicScreen;
import Mygame.finishBox.finishBox;
import Mygame.ground.groundFixed;
import Mygame.ground.groundGreen;
import Mygame.ground.groundWhite;
import Mygame.mainChar.Candy;
import Mygame.monsters.Monster;
import Mygame.monsters.MonsterPink;
import Mygame.monsters.MonsterRed;
import Mygame.stick.stick;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.QueryCallback;

/**
 * @author Sprixes
 * 
 */
public class Testscreen extends DynamicScreen {

	public ArrayList<Body> monsters = new ArrayList<Body>();
	public ArrayList<Body> Characters = new ArrayList<Body>();
	public ArrayList<Body> ground = new ArrayList<Body>();
	public ArrayList<Body> ground2 = new ArrayList<Body>();
	public ArrayList<Body> finishBoxBody = new ArrayList<Body>();
	public BitmapFont font;
	// final short CATEGORY_PLAYER = 0x0001; // 0000000000000001 in binary
	// final short CATEGORY_MONSTER = 0x0002; // 0000000000000010 in binary
	final short CATEGORY_GROUND = 0x0001; // 0000000000000100 in binary
	public boolean replay = false;
	public boolean triggerNextLevel = false;
	public Test test;

	// target, 5 properties

	public Testscreen(Game game, Test test) {
		super(game, 1280, 800);
		this.test = test;
		font = new BitmapFont();
		dynamic2dShape.createEdge(3, 0, 0, 1280, 0, 0);
		dynamic2dShape.createEdge(3, 1280, 0, 1280, 800, 0);
		dynamic2dShape.createEdge(3, 0, 0, 0, 800, 0);
		dynamic2dShape.createEdge(3, 0, 800, 1280, 800, 0);

		/* monsters */

		// createMonster(1, 200, 200);
		// createMonster(2, 400, 200);
		// /* character */
		// createCandy(1, 400, 200);
		// createCandy(2, 400, 200);
		// createCandy(3, 400, 200);
		// createCandy(4, 400, 200);
		// /* finish */
		// createFinish(100, 100);
		// /* Ground Box */
		//
		// createGround(1, 700, 600);
		// createGround(2, 800, 600);
		//
		// createGroundFixed(1, 600, 300, 45);
		// createGroundFixed(2, 700, 100, 45);
		// createGroundFixed(3, 100, 100, 45);
		// createGroundFixed(4, 300, 100, 45);
		// createGroundFixed(5, 600, 100, 45);
		// createGroundFixed(6, 600, 600, 45);
		Box2DDebug = false;
	}

	public void createGroundFixed(int type, float x, float y, float angle) {
		groundFixed target = new groundFixed(this, type);
		dynamicBodyBuilder.fixture(dynamicBodyBuilder.getfixtureDefBuilder().boxShape(target).build()).position(x, y).userData(target).angle(angle).build();
	}

	public void createStick(int type, float x, float y, float angle) {
		stick target = new stick(this, type);
		dynamicBodyBuilder.fixture(dynamicBodyBuilder.getfixtureDefBuilder().density(0.2f).boxShape(target).build()).position(x, y).userData(target).angle(angle).type(BodyType.DynamicBody).build();

	}

	public void createMonster(int type, float x, float y) {
		Monster target = null;
		if (type == 1) {
			target = new MonsterPink(this);

		}
		if (type == 2) {
			target = new MonsterRed(this);

		}

		monsters.add(dynamicBodyBuilder.fixture(dynamicBodyBuilder.getfixtureDefBuilder().boxShape(target).build()).position(x, y).userData(target).build());
	}

	public void createCandy(int type, float x, float y) {
		Candy target = new Candy(this, type);
		Characters.add(dynamicBodyBuilder.fixture(dynamicBodyBuilder.getfixtureDefBuilder().circleShape(target).density(0.2f).friction(0.2f).restitution(0.2f).build()).position(x, y)
				.type(BodyType.DynamicBody).userData(target).build());
		target = null;
	}

	public void createGroundGreen(int type, float x, float y) {
		groundGreen target = new groundGreen(this, type);
		ground.add(dynamicBodyBuilder.fixture(dynamicBodyBuilder.getfixtureDefBuilder().boxShape(target).build()).position(x, y).userData(target).build());
		target = null;
	}

	public void createGroundWhite(int type, float x, float y) {
		groundWhite target = new groundWhite(this, type);
		ground2.add(dynamicBodyBuilder.fixture(dynamicBodyBuilder.getfixtureDefBuilder().boxShape(target.getBounds().getWidth() / 2 - 20, target.getBounds().getHeight() / 2 - 5).build())
				.position(x, y).userData(target).type(BodyType.DynamicBody).build());
		target = null;
	}

	public void createFinish(float x, float y) {
		finishBox target = new finishBox(this);
		finishBoxBody.add(dynamicBodyBuilder.fixture(dynamicBodyBuilder.getfixtureDefBuilder().boxShape(target).build()).position(x, y).userData(target).build());
	}

	@Override
	public void beginContact(Contact contact) {
		for (int index = 0; index < finishBoxBody.size(); index++) {
			if (contact.getFixtureA().getBody() == finishBoxBody.get(index)) {
				for (int index2 = 0; index2 < Characters.size(); index2++) {
					if (contact.getFixtureB().getBody() == Characters.get(index2)) {
						finishLineHit(contact.getFixtureA().getBody(), contact.getFixtureB().getBody());

					}
				}
			}

		}

	}

	public void finishLineHit(Body b1, Body b2) {
		Candy target = (Candy) b2.getUserData();
		hitBody = b2;
		target.interpolateXY(b1.getPosition().x * PIXEL_PER_METER, b1.getPosition().y * PIXEL_PER_METER, 1000, true);
		target.interpolateRotation(360f, 1000, true);
		target.interpolateAlpha(0, 1000, true).setCallback(new TweenCallback() {
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				world.destroyBody(hitBody);
				hitBody.setUserData(null);
				hitBody = null;

			}
		});
	}

	@Override
	public void render(float delta) {

		spriteBatch.begin();
		font.draw(spriteBatch, "REPLAY", 1280 - 60, 800);
		font.draw(spriteBatch, "NEXT", 1280 - 110, 800);
		spriteBatch.end();

		super.render(delta);
		if (hitBody != null) {
			hitBody.setActive(false);
			// world.destroyBody(hitBody);
			// hitBody.setUserData(null);
			// hitBody = null;
		}
		for (int index = 0; index < ground.size(); index++) {
			groundGreen temp = (groundGreen) ground.get(index).getUserData();
			if (temp.remove == true) {
				world.destroyBody(ground.get(index));
				ground.remove(index);
			}
		}
		for (int index = 0; index < ground2.size(); index++) {
			groundWhite temp = (groundWhite) ground2.get(index).getUserData();
			if (temp.remove == true) {
				world.destroyBody(ground2.get(index));
				ground2.remove(index);
			}
		}
		if (replay) {
			replay = false;

			triggerNextLevel = false;
			test.resetScreen();
		}
		if (triggerNextLevel) {
			triggerNextLevel = false;
			replay = false;

			test.nextLevel();
		}
	}

	public QueryCallback callback = new QueryCallback() {

		@Override
		public boolean reportFixture(Fixture fixture) {
			// hitBody = null;
			// if the hit point is inside the fixture of the body
			// we report it
			if (fixture.testPoint(testPoint.x, testPoint.y)) {
				if (fixture.getBody() != null) {
					Body hitBody2 = fixture.getBody();
					for (int index = 0; index < ground.size(); index++) {
						if (hitBody2 == ground.get(index)) {
							groundGreen temp = (groundGreen) hitBody2.getUserData();
							hitBody2.setActive(false);
							temp.click();

						}
					}
					for (int index = 0; index < ground2.size(); index++) {
						if (hitBody2 == ground2.get(index)) {
							groundWhite temp = (groundWhite) hitBody2.getUserData();
							hitBody2.setActive(false);
							temp.click();

						}
					}
				}
				return false;
			} else {

				return true;
			}
		}
	};

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		Vector2 position = new Vector2(screenX, screenY);

		position.x *= (float) 1280 / Gdx.graphics.getWidth();
		position.y = (Gdx.graphics.getHeight() - position.y) * 800 / Gdx.graphics.getHeight();
		position.add(camera.position.x, camera.position.y);
		System.out.println(position);
		// Replay button
		if (position.x > 1222 && position.y > 700) {
			System.out.println("REPLAY");
			replay = true;
			return false;
		}
		// Next button
		if (position.x > 1170 && position.y > 700) {
			triggerNextLevel = true;
		}

		if (hitBody != null) {

		}
		position.div(PIXEL_PER_METER);
		testPoint.set(position.x, position.y, 0);

		world.QueryAABB(callback, testPoint.x - 0.0001f, testPoint.y - 0.0001f, testPoint.x + 0.0001f, testPoint.y + 0.0001f);

		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		hitBody = null;
		return false;
	}
}
