package Model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Horse extends ChessPiece{
	File image;
	String path = "D:\\Java_Project\\AI\\GameCoTuong\\src\\chess_pieces_Image\\";

	public Horse(Tile tile, int width, int height, boolean color) {
		super(tile, width, height, color);
		// TODO Auto-generated constructor stub
		if (color) {
			path += "b";
		} else {
			path += "r";
		}
		path += "N.png";
		image = new File(path);
	}

	@Override
	public void draw(Graphics2D g2) throws IOException {
		// TODO Auto-generated method stub

		BufferedImage boardImage = ImageIO.read(image);
		g2.drawImage(boardImage, tile.x, tile.y, tile.size, tile.size, null);
	}

}
