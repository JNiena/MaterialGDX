package materialgdx;

import com.badlogic.gdx.ApplicationListener;

public interface GameAdapter extends ApplicationListener {

	public default void start() {

	}

	public default void update() {

	}

	public default void exit() {

	}

	@Override
	public default void pause() {

	}

	@Override
	public default void resume() {

	}

	@Override
	public default void resize(int width, int height) {

	}

}