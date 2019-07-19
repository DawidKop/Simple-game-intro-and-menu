/**
 * This is the main class,
 * @author Dawid S. Kopczewski
 * The program is strongly influenced by the data gathered around the Internet
 */
package game;

import javax.swing.JFrame;

public class Game {

	public Game() {
		SupportPanel panel = new SupportPanel();
		JFrame frame = new JFrame("This is an example game intro and menu");
		frame.add(panel);
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setSize(panel.returnWidth(), panel.returnHeight());
		frame.setLocationRelativeTo(null);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//display is set to constant full HD resolution, borderless. In FHD screen it imitates a fullscreen view
		
		//declares and launches supportive thread to load other media in the background
		Loader background= new Loader("background"); 
		background.start();
	}
	
	public static void main(String[] args) {
		new Game();
	}
}
