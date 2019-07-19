package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SupportPanel extends JPanel implements Runnable, KeyListener{

	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	private Thread thread;
	private boolean running;
	private final int FPS = 50;
	private final int TARGET_TIME = 1000 / FPS;
	private BufferedImage image;
	private Graphics2D g;
	private static int state; //there are 2 states: 0=intro and 1=menu
	private Intro intro;
	private Menu menu;
	
	public SupportPanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		intro = new Intro();
		menu = new Menu();
		state=0; //starts in intro
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			addKeyListener(this);
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public void run() {
	
		init();
		long start,elapsed,wait;
		while(running) {
			start = System.nanoTime();
			update();
			draw();
			drawOnTheScreen();
			elapsed = System.nanoTime() - start;
			wait = TARGET_TIME - elapsed / 1000000;
			if(wait < 0) wait = TARGET_TIME;
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void init() {
		running = true;
		image = new BufferedImage(WIDTH, HEIGHT, 1);
		g = (Graphics2D) image.getGraphics();
	}

	private void update() {
		if (state==0) intro.update();
		else if (state==1) menu.update();
	}

	private void draw() {
		if (state==0) intro.draw(g);
		else if (state==1) menu.draw(g);
	}

	private void drawOnTheScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		g2.dispose();
	}
	
	public int returnWidth() {
		return WIDTH;
	}

	public int returnHeight() {
		return HEIGHT;
	}
	
	public static void setState(int st) {
		state=st;
	}

	public void keyPressed(KeyEvent key) {
		Keys.keySet(key.getKeyCode(), true);	
	}

	public void keyReleased(KeyEvent key) {
		Keys.keySet(key.getKeyCode(), false);	
	}

	public void keyTyped(KeyEvent key) {}
}

