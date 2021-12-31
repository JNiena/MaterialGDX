package materialgdx.modules;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Disposable;
import materialgdx.graphics.ScreenClearer;
import materialgdx.graphics.renderers.PolygonRenderer;
import materialgdx.graphics.renderers.SpriteRenderer;

public class Graphics implements Disposable {

	private PolygonRenderer polygonRenderer;
	private SpriteRenderer spriteRenderer;
	private ScreenClearer screenClearer;

	public Graphics() {
		this.polygonRenderer = new PolygonRenderer();
		this.spriteRenderer = new SpriteRenderer();
		this.screenClearer = new ScreenClearer(true, Color.BLACK);
	}

	public void update() {
		screenClearer.update();
		polygonRenderer.update();
		spriteRenderer.update();
	}

	@Override
	public void dispose() {
		polygonRenderer.dispose();
		spriteRenderer.dispose();
	}

	public PolygonRenderer getPolygonRenderer() {
		return polygonRenderer;
	}

	public SpriteRenderer getSpriteRenderer() {
		return spriteRenderer;
	}

	public ScreenClearer getScreenClearer() {
		return screenClearer;
	}

}