package defaultpackage;

import java.awt.image.BufferedImage;

public class SpritSheetPlant {
   private BufferedImage image;
	
	public SpritSheetPlant(BufferedImage image) {
		this.image = image;
	}
	public BufferedImage grabImage(int col,int row,int width,int height) {
		return image.getSubimage((col*32)-32, (row*32)-32, width, height);
	}
}
