package me.jumper251.replay.replaysystem;

import java.util.Arrays;
import java.util.List;

import org.bukkit.entity.Player;

import me.jumper251.replay.replaysystem.data.ReplayData;
import me.jumper251.replay.replaysystem.recording.Recorder;
import me.jumper251.replay.replaysystem.replaying.Replayer;
import me.jumper251.replay.utils.ReplayManager;
import me.jumper251.replay.utils.StringUtils;

public class Replay {

	private String id;
	
	private ReplayData data;
	
	private Recorder recorder;
	private Replayer replayer;
	
	private boolean isRecording, isPlaying;
	
	public Replay() {
		this.id = StringUtils.getRandomString(6);
		this.data = new ReplayData();
		this.isRecording = false;
		this.isPlaying = false;
	}
	
	public Replay(String id, ReplayData data) {
		this.id = id;
		this.data = data;
	}
	
	public void record(Player... players) {
		recordAll(Arrays.asList(players));
	}
	
	public void recordAll(List<Player> players) {
		this.recorder = new Recorder(this, players);
		this.recorder.start();
		this.isRecording = true;
		
		ReplayManager.activeReplays.put(this.id, this);

	}
	
	public void play(Player watcher) {
		this.replayer = new Replayer(this, watcher);
		this.replayer.start();
		this.isPlaying = true;
		
	}
	
	public String getId() {
		return id;
	}
	
	public ReplayData getData() {
		return data;
	}
	
	public void setData(ReplayData data) {
		this.data = data;
	}
	
	public Recorder getRecorder() {
		return recorder;
	}
	
	public Replayer getReplayer() {
		return replayer;
	}
	
	public boolean isRecording() {
		return isRecording;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setRecording(boolean recording) {
		this.isRecording = recording;
	}
	
	public boolean isPlaying() {
		return isPlaying;
	}
	
	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}
}