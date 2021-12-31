package materialgdx.graphics.renderers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import java.util.concurrent.ConcurrentLinkedQueue;
import materialgdx.graphics.renderables.RenderableSprite;

public class SpriteRenderer implements Disposable {

	private ConcurrentLinkedQueue<RenderableSprite> renderables;
	private SpriteBatch batch;

	public SpriteRenderer() {
		this.renderables = new ConcurrentLinkedQueue<>();
		this.batch = new SpriteBatch();
	}

	public void add(RenderableSprite renderable) {
		renderables.add(renderable);
	}

	public void remove(RenderableSprite renderable) {
		renderables.remove(renderable);
	}

	public void update() {
		batch.begin();
		for (RenderableSprite renderable : renderables) {
			renderable.render(batch);
		}
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}