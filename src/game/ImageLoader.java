package game;
//import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageLoader {
	public static BufferedImage intro = iload("/images/intro.gif");
	public static BufferedImage sign = iload("/images/sign.gif");
	public static BufferedImage menu;
	public static BufferedImage [][] mbuttons;
	
	public static void loadMedia() { //loads all other media than the 2 used on intro screen
		mbuttons = sload("/images/menu_buttons.gif",300,48);
		menu = iload("/images/menu.gif");
		//any additional media put here
	}
	
	public static BufferedImage iload(String s) {
		try {
			BufferedImage loadimg = ImageIO.read(ImageLoader.class.getResourceAsStream(s));
			return loadimg;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when an image was loading.");
			System.exit(0);
		}
		return null;
	}
		
	public static BufferedImage[][] sload(String s, int w, int h) {
		BufferedImage[][] ret;
		try {
			BufferedImage spritesheet = ImageIO.read(ImageLoader.class.getResourceAsStream(s));
			int width = spritesheet.getWidth() / w;
			int height = spritesheet.getHeight() / h;
			ret = new BufferedImage[height][width];
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					ret[i][j] = spritesheet.getSubimage(j * w, i * h, w, h);
				}
			}
			return ret;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error when a sprite was loading.");
			System.exit(0);
		}return null;
	}
}

