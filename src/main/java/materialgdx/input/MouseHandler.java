package materialgdx.input;

import com.badlogic.gdx.Gdx;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class MouseHandler {

	private HashMap<Integer, BiConsumer<Integer, Integer>> tappedActions;
	private HashMap<Integer, BiConsumer<Integer, Integer>> heldActions;

	public MouseHandler() {
		tappedActions = new HashMap<>();
		heldActions = new HashMap<>();
	}

	public void update() {
		for (int button : tappedActions.keySet()) {
			if (Gdx.input.isButtonJustPressed(button)) {
				tappedActions.get(button).accept(getX(), getY());
			}
		}
		for (int button : heldActions.keySet()) {
			if (Gdx.input.isButtonPressed(button)) {
				heldActions.get(button).accept(getX(), getY());
			}
		}
	}

	public void bindTappedKey(int key, BiConsumer<Integer, Integer> action) {
		tappedActions.put(key, action);
	}

	public void bindHeldKey(int key, BiConsumer<Integer, Integer> action) {
		heldActions.put(key, action);
	}

	public void unbindTappedKey(int key) {
		tappedActions.remove(key);
	}

	public void unbindHeldKey(int key) {
		heldActions.remove(key);
	}

	public int getX() {
		return Gdx.input.getX();
	}

	public int getY() {
		return Gdx.graphics.getHeight() - Gdx.input.getY();
	}

}