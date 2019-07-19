package game;
import java.awt.event.KeyEvent;

public class Keys {

public static final int NUM_KEYS = 4;
		
		public static boolean keyState[] = new boolean[NUM_KEYS];
		public static boolean prevKeyState[] = new boolean[NUM_KEYS];
		
		public static int UP = 0;
		public static int DOWN = 1;
		public static int SPACE = 2;
		public static int ENTER = 3;
		
		public static void keySet(int i, boolean b) {
			if(i == KeyEvent.VK_UP) keyState[UP] = b;
			else if(i == KeyEvent.VK_DOWN) keyState[DOWN] = b;
			else if(i == KeyEvent.VK_SPACE) keyState[SPACE] = b;
			else if(i == KeyEvent.VK_ENTER) keyState[ENTER] = b;
		}

		public static void update() {
			for(int i = 0; i < NUM_KEYS; i++) {
				prevKeyState[i] = keyState[i];
			}
		}
		
		public static boolean isPressed(int i) {
			return keyState[i] && !prevKeyState[i];
		}		
}

