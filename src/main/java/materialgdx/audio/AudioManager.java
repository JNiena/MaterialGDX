package materialgdx.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Disposable;
import java.util.HashMap;

public class AudioManager implements Disposable {

	private HashMap<String, Sound> sounds;
	private HashMap<String, Music> music;

	public AudioManager() {
		this.sounds = new HashMap<>();
		this.music = new HashMap<>();
	}

	public void loadSound(FileHandle handle) {
		sounds.putIfAbsent(handle.name(), Gdx.audio.newSound(handle));
	}

	public void loadMusic(FileHandle handle) {
		music.putIfAbsent(handle.name(), Gdx.audio.newMusic(handle));
	}

	public Sound getSound(String name) {
		return sounds.get(name);
	}

	public Music getMusic(String name) {
		return music.get(name);
	}

	@Override
	public void dispose() {
		for (Sound sound : sounds.values()) {
			sound.dispose();
		}
		for (Music music : music.values()) {
			music.dispose();
		}
	}

}