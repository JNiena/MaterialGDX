package materialgdx.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureUtilities {

	public static TextureRegion createSinglePixelTexture(Color color) {
		Pixmap pixmap = new Pixmap(1, 1, Format.RGB888);
		pixmap.setColor(color);
		pixmap.fill();
		return new TextureRegion(new Texture(pixmap), 0, 0, 1, 1);
	}

	public static TextureRegion createSinglePixelTexture() {
		return createSinglePixelTexture(Color.WHITE);
	}

}