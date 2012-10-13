package z;

import java.applet.*;
import java.net.URL;
import javax.swing.*;

public class M extends JApplet {

	private AudioClip a;

	public M() {
		URL f = getClass().getResource("t.wav");
		a = Applet.newAudioClip(f);
		a.loop();
	}

	public void start() {
		if (a != null)
			a.loop();
	}

	public void stop() {
		if (a != null)
			a.stop();
	}

}
