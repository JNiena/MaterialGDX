package materialgdx;

import materialgdx.modules.Application;
import materialgdx.modules.Audio;
import materialgdx.modules.Graphics;
import materialgdx.modules.Input;
import materialgdx.modules.Network;

public class Game implements GameAdapter {

	private Graphics graphics;
	private Input input;
	private Audio audio;
	private Network network;
	private Application application;

	@Override
	public final void create() {
		graphics = new Graphics();
		input = new Input();
		audio = new Audio();
		network = new Network();
		application = new Application();
		start();
	}

	@Override
	public final void render() {
		graphics.update();
		input.update();
		update();
	}

	@Override
	public final void dispose() {
		audio.dispose();
		network.dispose();
		exit();
	}

	protected Graphics getGraphics() {
		return graphics;
	}

	protected Input getInput() {
		return input;
	}

	protected Audio getAudio() {
		return audio;
	}

	public Network getNetwork() {
		return network;
	}

	public Application getApplication() {
		return application;
	}

}