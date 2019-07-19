package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Intro {

	public static BufferedImage ima, introbackground,sign;
	private int alpha, frames, HEIGHT, WIDTH;
	private final int FADE_IN = 60;
	private final int LENGTH = 60;
	private final int FADE_OUT = 60;
	@SuppressWarnings("unused")
	private Graphics2D g;
	public static boolean letitload;
	
	public Intro() {
		introbackground = ImageLoader.intro;
		sign = ImageLoader.sign;
		letitload=false;
		HEIGHT = SupportPanel.HEIGHT;
		WIDTH = SupportPanel.WIDTH;
		ima = new BufferedImage(WIDTH,HEIGHT,1);
		frames = 0;
		g = (Graphics2D) ima.getGraphics();
	}

	public void update() {
		handleInput();
		frames++;
		if(frames < FADE_IN) {
			alpha = (int) (255 - 255 * (1.0 * frames / FADE_IN));
				if(alpha < 0) alpha = 0;
			}
	if((frames > FADE_IN + LENGTH)&&(letitload)) {
		alpha = (int) (255 * (1.0 * frames - FADE_IN - LENGTH) / FADE_OUT);
		if(alpha > 255) alpha = 255;
	}
	if((frames > FADE_IN + LENGTH)&&(!letitload)) {frames--;}//waiting for background media loader to complete
	if(frames > FADE_IN + LENGTH + FADE_OUT) {
		System.out.println("Files loading confirmed, allowing menu launch.");
		SupportPanel.setState(1);
		}
	}

	public static void letTheMenuLoad(){letitload=true;}

	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.drawImage(introbackground, 0, 0,WIDTH, HEIGHT, null);
		g.drawImage(sign, WIDTH/2-171, HEIGHT-280, null);
		g.setColor(new Color(0, 0, 0, alpha));
		g.fillRect(0, 0, WIDTH,HEIGHT);
	}
	
	public void handleInput() {
		//for safety, input handling disabled so there is enough time to load the game files
	}
}