package materialgdx.graphics.renderers;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;
import java.util.concurrent.ConcurrentLinkedQueue;
import materialgdx.graphics.TextureUtilities;
import materialgdx.graphics.renderables.RenderablePolygon;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class PolygonRenderer implements Disposable {

	private ConcurrentLinkedQueue<RenderablePolygon> renderables;
	private PolygonSpriteBatch batch;
	private TextureRegion pixel;
	private ShapeDrawer drawer;

	public PolygonRenderer() {
		this.renderables = new ConcurrentLinkedQueue<>();
		this.batch = new PolygonSpriteBatch();
		this.pixel = TextureUtilities.createSinglePixelTexture();
		this.drawer = new ShapeDrawer(this.batch, this.pixel);
	}

	public void add(RenderablePolygon renderable) {
		renderables.add(renderable);
	}

	public void remove(RenderablePolygon renderable) {
		renderables.remove(renderable);
	}

	public void update() {
		batch.begin();
		for (RenderablePolygon renderable : renderables) {
			renderable.render(drawer);
		}
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}