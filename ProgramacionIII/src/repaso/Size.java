package repaso;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Size {
	public static void main(String[] args) {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		System.out.println(width);
		System.out.println(height);
	}

}
