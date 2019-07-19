package game;

import java.awt.Color;
import java.awt.Graphics2D;

public class Menu{

	private int anim, animpom, buttoncooldown;
	public final int MCONTINUE=1, MSTART=2, MOPTIONS=3, MCREDITS=4, MQUIT=5;
	public int MCURRENT=1;
	private int HEIGHT, WIDTH;
	
	public Menu() {
		HEIGHT = SupportPanel.HEIGHT;
		WIDTH = SupportPanel.WIDTH;
		anim=-1360; animpom=0; buttoncooldown=0;
	}

	public void update() {
		handleInput();
		animpom++;//every 5 frames, position of the image updates
		if(animpom>=5) {
			if(anim<0)anim++;//as long as there is space to go up, the camera on background image goes up
			animpom=0;
			}
		if(buttoncooldown>0)buttoncooldown--;
		}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);g.fillRect(0, 0, WIDTH, HEIGHT);
		g.drawImage(ImageLoader.menu, 0,anim,WIDTH,2440, null);
		if(MCURRENT==1) {
			g.drawImage(ImageLoader.mbuttons[0][0], WIDTH/2-150, 700, null);
			} else g.drawImage(ImageLoader.mbuttons[0][1], WIDTH/2-150, 700, null);
		if(MCURRENT==2) {
			g.drawImage(ImageLoader.mbuttons[1][0], WIDTH/2-150, 750, null);
			} else g.drawImage(ImageLoader.mbuttons[1][1], WIDTH/2-150, 750, null);
		if(MCURRENT==3) {
			g.drawImage(ImageLoader.mbuttons[2][0], WIDTH/2-150, 800, null);
			} else g.drawImage(ImageLoader.mbuttons[2][1], WIDTH/2-150, 800, null);
		if(MCURRENT==4) {
			g.drawImage(ImageLoader.mbuttons[3][0], WIDTH/2-150, 850, null);
			} else g.drawImage(ImageLoader.mbuttons[3][1], WIDTH/2-150, 850, null);
		if(MCURRENT==5) {
			g.drawImage(ImageLoader.mbuttons[4][0], WIDTH/2-150, 900, null);
			} else g.drawImage(ImageLoader.mbuttons[4][1], WIDTH/2-150, 900, null);
	}

	private void selectOption() {
		switch (MCURRENT) { //only exit option is implemented
		case 1: {break;}
		case 2: {break;}
		case 3: {break;}
		case 4: {break;}
		case 5: {
			System.exit(0);
			break;
		}
		default: break;
		}
	}
	
	private void buttonUP() {
		if(MCURRENT>MCONTINUE) MCURRENT--; 
		buttoncooldown=10; //a delay between active button update, otherwise it would allow to scroll up and down instantly
	}

	private void buttonDOWN() {
		if(MCURRENT<MQUIT) MCURRENT++; 
		buttoncooldown=10;
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.UP) )        {if (buttoncooldown<=0) buttonUP();}
		else if(Keys.isPressed(Keys.DOWN) ) {if (buttoncooldown<=0) buttonDOWN();}
		else if((Keys.isPressed(Keys.ENTER))||(Keys.isPressed(Keys.SPACE))) {if (buttoncooldown<=0) selectOption();}
	}
}
