package materialgdx.modules;

import com.badlogic.gdx.Gdx;

public class Application {

	public void setDimensions(int width, int height) {
		Gdx.graphics.setWindowedMode(width, height);
	}

	public void setWidth(int width) {
		Gdx.graphics.setWindowedMode(width, Gdx.graphics.getHeight());
	}

	public void setHeight(int height) {
		Gdx.graphics.setWindowedMode(Gdx.graphics.getWidth(), height);
	}

	public int getWidth() {
		return Gdx.graphics.getWidth();
	}

	public int getHeight() {
		return Gdx.graphics.getHeight();
	}

	public void exit() {
		Gdx.app.exit();
	}

	public void post(Runnable runnable) {
		Gdx.app.postRunnable(runnable);
	}

}