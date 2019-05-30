package componentes;  
import java.io.File;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;  
   

public class Audioss extends Object {
	private MediaPlayer mp;
	
	public Audioss() {
		//JFXPanel fxPanel = new JFXPanel();   NECESARIO
				String path = "src/audios/Tutorial.mp3";
				Media media = new Media(new File(path).toURI().toString());
				mp = new MediaPlayer(media);
				mp.setAutoPlay(true);
				mp.setVolume(0.4);
				MediaView mediaView = new MediaView(mp);
	}
public Audioss(String path) {
	
	  path = "src/audios/Deal.mp3";
	Media media = new Media(new File(path).toURI().toString());
	mp = new MediaPlayer(media);
	mp.setAutoPlay(true);
	mp.setVolume(0.1);
	MediaView mediaView = new MediaView(mp);
	}
	public MediaPlayer getMp() {
		return mp;
	}
	public void setMp() {
		
		this.mp = mp;
	}
	public void Pause(MediaPlayer mp) {
		mp.pause();
		this.mp = mp;
	}	
	
	public MediaPlayer Stop() {
		this.mp.stop();
		return mp;
	}
	
	public void Play(MediaPlayer mp) {
		mp.play();
		this.mp = mp;
	}
	
}	
