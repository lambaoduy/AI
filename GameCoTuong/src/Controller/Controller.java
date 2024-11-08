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

public class Controller implements IController {
	ChessBoard chessboard = new ChessBoard(0, 0);
	ArrayList<ChessPiece> listSurvival = new ArrayList<>();//list cac quan con song
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

	public Controller() {
		Tile[][] state = chessboard.getBoard();
		System.out.println(state[0][0].getX());
		int tileSize = state[0][0].getSize();
		// khoi tao quan do
		redGeneral = new General(state[0][4], tileSize, tileSize, false);
		redLeftChariot = new Chariot(state[0][0], tileSize, tileSize, false);
		redRightChariot = new Chariot(state[0][8], tileSize, tileSize, false);
		redLeftAdvisor = new Advisor(state[0][3], tileSize, tileSize, false);
		redRightAdvisor = new Advisor(state[0][5], tileSize, tileSize, false);
		redLeftCannon = new Cannon(state[2][1], tileSize, tileSize, false);
		redRightCannon = new Cannon(state[2][7], tileSize, tileSize, false);
		redLeftElephant = new Elephant(state[0][6], tileSize, tileSize, false);
		redRightElephant = new Elephant(state[0][2], tileSize, tileSize, false);
		redLeftHorse = new Horse(state[0][1], tileSize, tileSize, false);
		redRightHorse = new Horse(state[0][7], tileSize, tileSize, false);
		redSolider1 = new Solider(state[3][0], tileSize, tileSize, false);
		redSolider2 = new Solider(state[3][2], tileSize, tileSize, false);
		redSolider3 = new Solider(state[3][4], tileSize, tileSize, false);
		redSolider4 = new Solider(state[3][6], tileSize, tileSize, false);
		redSolider5 = new Solider(state[3][8], tileSize, tileSize, false);
		listSurvival.add(redGeneral);
		// khoi tao quan den
		blackGeneral = new General(state[9][4], tileSize, tileSize, true);
		blackLeftChariot = new Chariot(state[9][0], tileSize, tileSize, true);
		blackRightChariot = new Chariot(state[9][8], tileSize, tileSize, true);

		blackLeftAdvisor = new Advisor(state[9][3], tileSize, tileSize, true);
		blackRightAdvisor = new Advisor(state[9][5], tileSize, tileSize, true);

		blackLeftCannon = new Cannon(state[7][1], tileSize, tileSize, true);
		blackRightCannon = new Cannon(state[7][7], tileSize, tileSize, true);

		blackLeftElephant = new Elephant(state[9][6], tileSize, tileSize, true);
		blackRightElephant = new Elephant(state[9][2], tileSize, tileSize, true);

		blackLeftHorse = new Horse(state[9][1], tileSize, tileSize, true);
		blackRightHorse = new Horse(state[9][7], tileSize, tileSize, true);

		blackSolider1 = new Solider(state[6][0], tileSize, tileSize, true);
		blackSolider2 = new Solider(state[6][2], tileSize, tileSize, true);
		blackSolider3 = new Solider(state[6][4], tileSize, tileSize, true);
		blackSolider4 = new Solider(state[6][6], tileSize, tileSize, true);
		blackSolider5 = new Solider(state[6][8], tileSize, tileSize, true);
	}

	public void draw(Graphics2D g2) throws IOException {
		// TODO Auto-generated method stub
		chessboard.draw(g2);
//draw quan do
		redGeneral.draw(g2);
		redLeftChariot.draw(g2);
		redRightChariot.draw(g2);
		redLeftAdvisor.draw(g2);
		redRightAdvisor.draw(g2);
		redLeftCannon.draw(g2);
		redRightCannon.draw(g2);
		redLeftElephant.draw(g2);
		redRightElephant.draw(g2);
		redLeftHorse.draw(g2);
		redRightHorse.draw(g2);
		redSolider1.draw(g2);
		redSolider2.draw(g2);
		redSolider3.draw(g2);
		redSolider4.draw(g2);
		redSolider5.draw(g2);
//draw quan den
		blackGeneral.draw(g2);
		blackLeftChariot.draw(g2);
		blackRightChariot.draw(g2);
		blackLeftAdvisor.draw(g2);
		blackRightAdvisor.draw(g2);
		blackLeftCannon.draw(g2);
		blackRightCannon.draw(g2);
		blackLeftElephant.draw(g2);
		blackRightElephant.draw(g2);
		blackLeftHorse.draw(g2);
		blackRightHorse.draw(g2);
		blackSolider1.draw(g2);
		blackSolider2.draw(g2);
		blackSolider3.draw(g2);
		blackSolider4.draw(g2);
		blackSolider5.draw(g2);
	}

}
