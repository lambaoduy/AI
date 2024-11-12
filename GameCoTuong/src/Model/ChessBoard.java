package Model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import View.Frame;

public class ChessBoard {
	Tile[][] board;
	public static int marginTop = 33;// đệm 1 khoảng lên trên để hiển thị đúng vị trí trên bàn cờ
	public static int marginLeft = 99;// đệm 1 khoảng vào bên trái để hiển thị đúng vị trí trên bàn cờ

	private int tilesize;
	int x, y;
	File image;

	public ChessBoard(int x, int y) {
		super();
		board = new Tile[9][10]; // 10 hàng 9 cột
		image = new File("src\\Board_Image\\Xiangqi_board.png");
		tilesize = 67;
		this.x = x;
		this.y = y;
		initialBoard();
	}

	private void initialBoard() {
		// Tạo mảng ban đầu
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				// tọa độ x,y sao cho khớp 1 ô là vị trí quân trên đường của bàn cờ
				int x = i * tilesize + marginTop - tilesize / 2;
				int y = j * tilesize + marginLeft - tilesize / 2;
				board[i][j] = new Tile(x, y, tilesize);
			}
		}
	}

	public void draw(Graphics2D g2) throws IOException {
		BufferedImage boardImage = ImageIO.read(image);
		int with = boardImage.getWidth() * 2 / 3;// nhân 2/3 để điều chỉnh tỷ lệ ảnh gốc của bàn cờ
		int height = boardImage.getHeight() * 2 / 3;

		g2.drawImage(boardImage, x, y, with, height, null);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				Tile tile = board[i][j];
				g2.drawRect(tile.getX(), tile.getY(), tilesize, tilesize);
			}
		}
	}
	public Tile[][] getBoard() {
		return board;
	}

	public void setBoard(Tile[][] board) {
		this.board = board;
	}
}
