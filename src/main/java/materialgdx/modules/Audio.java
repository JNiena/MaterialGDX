package materialgdx.modules;

import com.badlogic.gdx.utils.Disposable;
import materialgdx.audio.AudioManager;

public class Audio implements Disposable {

	private AudioManager audioManager;

	public Audio() {
		this.audioManager = new AudioManager();
	}

	public AudioManager getAudioManager() {
		return audioManager;
	}

	@Override
	public void dispose() {
		audioManager.dispose();
	}

}