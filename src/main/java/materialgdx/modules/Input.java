package materialgdx.modules;

import materialgdx.input.KeyboardHandler;
import materialgdx.input.MouseHandler;

public class Input {

	private KeyboardHandler keyboardHandler;
	private MouseHandler mouseHandler;

	public Input() {
		this.keyboardHandler = new KeyboardHandler();
		this.mouseHandler = new MouseHandler();
	}

	public void update() {
		keyboardHandler.update();
		mouseHandler.update();
	}

	public KeyboardHandler getKeyboardHandler() {
		return keyboardHandler;
	}

	public MouseHandler getMouseHandler() {
		return mouseHandler;
	}

}