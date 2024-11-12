package Model;

import java.awt.Graphics2D;
import java.io.IOException;

public abstract class ChessPiece {
	int width, height;
	Tile tile;
	boolean color;// red=true black= false

	public ChessPiece(Tile tile, int width, int height, boolean color) {
		super();
		this.tile = tile;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public Tile getTile() {
		return this.tile;
	}

	public abstract void draw(Graphics2D g2) throws IOException;

	public void setTile(Tile tile2) {
		this.tile = tile2;
	}
}
