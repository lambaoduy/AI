package Controller;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import Model.Advisor;
import Model.Cannon;
import Model.Chariot;
import Model.ChessBoard;
import Model.ChessPiece;
import Model.Elephant;
import Model.General;
import Model.Horse;
import Model.Solider;
import Model.Tile;
import View.Frame;
import View.Listener;

public class Controller implements IController {
	ChessBoard chessboard = new ChessBoard(0, 0);
	Tile[][] state = chessboard.getBoard();
	Graphics2D g2;
	ArrayList<ChessPiece> listSurvival = new ArrayList<>();// list cac quan con song
	// Khai bao quan do
	ChessPiece redLeftChariot, redRightChariot;
	ChessPiece redLeftAdvisor, redRightAdvisor;
	ChessPiece redLeftCannon, redRightCannon;
	ChessPiece redLeftElephant, redRightElephant;
	ChessPiece redGeneral;
	ChessPiece redLeftHorse, redRightHorse;
	ChessPiece redSolider1, redSolider2, redSolider3, redSolider4, redSolider5;
	// khai bao quan den
	ChessPiece blackLeftChariot, blackRightChariot;
	ChessPiece blackLeftAdvisor, blackRightAdvisor;
	ChessPiece blackLeftCannon, blackRightCannon;
	ChessPiece blackLeftElephant, blackRightElephant;
	ChessPiece blackGeneral;
	ChessPiece blackLeftHorse, blackRightHorse;
	ChessPiece blackSolider1, blackSolider2, blackSolider3, blackSolider4, blackSolider5;

	public Controller(Graphics2D g2) throws IOException {
		this.g2 = g2;
		int tileSize = state[0][0].getSize();
		System.out.println(state[1][8].getX());
		// khoi tao quan do
		redGeneral = new General(state[4][0], tileSize, tileSize, false);
		redLeftChariot = new Chariot(state[0][0], tileSize, tileSize, false);
		redRightChariot = new Chariot(state[8][0], tileSize, tileSize, false);
		redLeftAdvisor = new Advisor(state[3][0], tileSize, tileSize, false);
		redRightAdvisor = new Advisor(state[5][0], tileSize, tileSize, false);
		redLeftCannon = new Cannon(state[1][2], tileSize, tileSize, false);
		redRightCannon = new Cannon(state[7][2], tileSize, tileSize, false);
		redLeftElephant = new Elephant(state[6][0], tileSize, tileSize, false);
		redRightElephant = new Elephant(state[2][0], tileSize, tileSize, false);
		redLeftHorse = new Horse(state[1][0], tileSize, tileSize, false);
		redRightHorse = new Horse(state[7][0], tileSize, tileSize, false);
		redSolider1 = new Solider(state[0][3], tileSize, tileSize, false);
		redSolider2 = new Solider(state[2][3], tileSize, tileSize, false);
		redSolider3 = new Solider(state[4][3], tileSize, tileSize, false);
		redSolider4 = new Solider(state[6][3], tileSize, tileSize, false);
		redSolider5 = new Solider(state[8][3], tileSize, tileSize, false);
		// add vao list
		listSurvival.add(redGeneral);
		listSurvival.add(redLeftChariot);
		listSurvival.add(redRightChariot);
		listSurvival.add(redLeftAdvisor);
		listSurvival.add(redRightAdvisor);
		listSurvival.add(redLeftCannon);
		listSurvival.add(redRightCannon);
		listSurvival.add(redLeftElephant);
		listSurvival.add(redRightElephant);
		listSurvival.add(redLeftHorse);
		listSurvival.add(redRightHorse);
		listSurvival.add(redSolider1);
		listSurvival.add(redSolider2);
		listSurvival.add(redSolider3);
		listSurvival.add(redSolider4);
		listSurvival.add(redSolider5);

		// khoi tao quan den
		blackGeneral = new General(state[4][9], tileSize, tileSize, true);
		blackLeftChariot = new Chariot(state[0][9], tileSize, tileSize, true);
		blackRightChariot = new Chariot(state[8][9], tileSize, tileSize, true);

		blackLeftAdvisor = new Advisor(state[3][9], tileSize, tileSize, true);
		blackRightAdvisor = new Advisor(state[5][9], tileSize, tileSize, true);

		blackLeftCannon = new Cannon(state[1][7], tileSize, tileSize, true);
		blackRightCannon = new Cannon(state[7][7], tileSize, tileSize, true);

		blackLeftElephant = new Elephant(state[6][9], tileSize, tileSize, true);
		blackRightElephant = new Elephant(state[2][9], tileSize, tileSize, true);

		blackLeftHorse = new Horse(state[1][9], tileSize, tileSize, true);
		blackRightHorse = new Horse(state[7][9], tileSize, tileSize, true);

		blackSolider1 = new Solider(state[0][6], tileSize, tileSize, true);
		blackSolider2 = new Solider(state[2][6], tileSize, tileSize, true);
		blackSolider3 = new Solider(state[4][6], tileSize, tileSize, true);
		blackSolider4 = new Solider(state[6][6], tileSize, tileSize, true);
		blackSolider5 = new Solider(state[8][6], tileSize, tileSize, true);
		// them cac quan den vao list
		listSurvival.add(blackGeneral);
		listSurvival.add(blackLeftChariot);
		listSurvival.add(blackRightChariot);
		listSurvival.add(blackLeftAdvisor);
		listSurvival.add(blackRightAdvisor);
		listSurvival.add(blackLeftCannon);
		listSurvival.add(blackRightCannon);
		listSurvival.add(blackLeftElephant);
		listSurvival.add(blackRightElephant);
		listSurvival.add(blackLeftHorse);
		listSurvival.add(blackRightHorse);
		listSurvival.add(blackSolider1);
		listSurvival.add(blackSolider2);
		listSurvival.add(blackSolider3);
		listSurvival.add(blackSolider4);
		listSurvival.add(blackSolider5);
		draw(g2);
	}

	public void draw(Graphics2D g2) throws IOException {
		// TODO Auto-generated method stub
		chessboard.draw(g2);
		for (ChessPiece chessPiece : listSurvival) {
			chessPiece.draw(g2);
		}

	}

	@Override
	public ChessPiece select(int x, int y) {
		// TODO Auto-generated method stub
		ChessPiece result = null;
		for (ChessPiece chessPiece : listSurvival) {
			int tileX = chessPiece.getTile().getX();
			int size = chessPiece.getTile().getSize();
			int tileY = chessPiece.getTile().getY();

			// x nam trong 1 o co vi tri tu x den x+ size va y nam trong y den y + size
			if (tileX < x && (tileX + size) > x && y > tileY && y < tileY + size) {
				result = chessPiece;
				break;
			}
		}

		return result;
	}

	@Override
	public void update() throws IOException {
		// TODO Auto-generated method stub
		draw(g2);
		System.out.println("draw");
	}

	@Override
	// di chuyen quan co den vị tri tile(x,y)
	public void move(ChessPiece chesspiece, int x, int y) {
		// TODO Auto-generated method stub

		Tile newTile = null;
		//vong lap nay lay ra cai Tile vua click chuot vao
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				int tileX = state[i][j].getX();
				int size = state[i][j].getSize();
				int tileY = state[i][j].getY();
				if (x > tileX && x < tileX + size && y > tileY && y < tileY + size) {
					newTile = state[i][j];
					break;
				}
			}
		}
		chesspiece.setTile(newTile);
	}

}
