package materialgdx.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenClearer {

	private boolean enabled;
	private Color clearColor;

	public ScreenClearer(boolean enabled, Color clearColor) {
		this.enabled = enabled;
		this.clearColor = clearColor;
	}

	public void update() {
		if (enabled) {
			ScreenUtils.clear(clearColor);
		}
	}

	public void setClearColor(Color clearColor) {
		this.clearColor = clearColor;
	}

	public void enable() {
		enabled = true;
	}

	public void disable() {
		enabled = false;
	}

	public void toggle() {
		enabled = !enabled;
	}

	public boolean isEnabled() {
		return enabled;
	}

}