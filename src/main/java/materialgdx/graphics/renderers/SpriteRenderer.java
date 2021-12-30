package materialgdx.graphics.renderers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import java.util.ArrayList;
import java.util.List;
import materialgdx.graphics.renderables.RenderableSprite;

public class SpriteRenderer implements Disposable {

	private List<RenderableSprite> renderables;
	private SpriteBatch batch;

	public SpriteRenderer() {
		this.renderables = new ArrayList<>();
		this.batch = new SpriteBatch();
	}

	public void add(RenderableSprite renderable) {
		renderables.add(renderable);
	}

	public void add(RenderableSprite... renderables) {
		for (RenderableSprite renderable : renderables) {
			this.renderables.add(renderable);
		}
	}

	public void remove(RenderableSprite renderable) {
		renderables.remove(renderable);
	}

	public void remove(RenderableSprite... renderables) {
		for (RenderableSprite renderable : renderables) {
			this.renderables.remove(renderable);
		}
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