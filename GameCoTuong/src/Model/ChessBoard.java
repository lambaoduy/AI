package Model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ChessBoard {
	public static final int PLAYER1_WINS = 1;
	public static final int PLAYER2_WINS = 2;
	public boolean isPlayer1Turn,endgame; // Track whose turn it is
	Tile[][] board;
	public static int marginTop = 33;// đệm 1 khoảng lên trên để hiển thị đúng vị trí trên bàn cờ
	public static int marginLeft = 99;// đệm 1 khoảng vào bên trái để hiển thị đúng vị trí trên bàn cờ
	private int x, y;
	private int tilesize;
	List<ChessPiece> listPieceRedAlive, listPieceBlAlive;
	File image;
	
	public ChessBoard(Tile[][] board, List<ChessPiece> listPieceBlAlive, List<ChessPiece> listPieceRedAlive) {
		super();
		this.board = board;
		this.listPieceBlAlive=listPieceBlAlive;
		this.listPieceRedAlive=listPieceRedAlive;
		image = new File("src\\Board_Image\\Xiangqi_board.png");
	}

	public ChessBoard(int x, int y) {
		super();
		board = new Tile[9][10]; // 10 hàng 9 cột
		image = new File("src\\Board_Image\\Xiangqi_board.png");
		tilesize = 67;
		this.x = x;
		this.y = y;
		listPieceRedAlive = new ArrayList<>();
		listPieceBlAlive = new ArrayList<>();
		initialBoard();
		initialState(this.board);

	}

	/**
	 * Tạo bàn cờ giả
	 */
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

//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				Tile tile = board[i][j];
//				g2.drawRect(tile.getX(), tile.getY(), tilesize, tilesize);
//
//			}
//		}
	}

	/**
	 * Khởi tạo vị trí ban đầu cho các quân cờ
	 */
	public void initialState(Tile[][] gameBoard) {

		// Red chariots
		board[0][0].setPiece(new Chariot(true));
		board[8][0].setPiece(new Chariot(true));
		// Black chariots
		board[0][9].setPiece(new Chariot(false));
		board[8][9].setPiece(new Chariot(false));

		// Red Cannons
		board[1][2].setPiece(new Cannon(true));
		board[7][2].setPiece(new Cannon(true));
		// Black Cannons
		board[1][7].setPiece(new Cannon(false));
		board[7][7].setPiece(new Cannon(false));

		// Red Horses
		board[1][0].setPiece(new Horse(true));
		board[7][0].setPiece(new Horse(true));
		// Black Horses
		board[1][9].setPiece(new Horse(false));
		board[7][9].setPiece(new Horse(false));

		// Red Elephants
		board[2][0].setPiece(new Elephant(true));
		board[6][0].setPiece(new Elephant(true));
		// Black Elephants
		board[2][9].setPiece(new Elephant(false));
		board[6][9].setPiece(new Elephant(false));

		// Red Advisors
		board[3][0].setPiece(new Advisor(true));
		board[5][0].setPiece(new Advisor(true));
		// Black Advisors
		board[3][9].setPiece(new Advisor(false));
		board[5][9].setPiece(new Advisor(false));

		// Red General
		board[4][0].setPiece(new General(true));
		// Black General
		board[4][9].setPiece(new General(false));

		// Red Solider
		board[0][3].setPiece(new Soldier(true));
		board[2][3].setPiece(new Soldier(true));
		board[4][3].setPiece(new Soldier(true));
		board[6][3].setPiece(new Soldier(true));
		board[8][3].setPiece(new Soldier(true));
		// Black Soldier
		board[0][6].setPiece(new Soldier(false));
		board[2][6].setPiece(new Soldier(false));
		board[4][6].setPiece(new Soldier(false));
		board[6][6].setPiece(new Soldier(false));
		board[8][6].setPiece(new Soldier(false));
//		thêm các quân cờ vào danh sách các quân cờ còn sống
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].getPiece() != null) {
					board[i][j].getPiece().UpDateListCanMove(i, j, board);
					if (board[i][j].getPiece().color) {
						listPieceRedAlive.add(board[i][j].getPiece());
					} else {
						listPieceBlAlive.add(board[i][j].getPiece());
					}
				}
			}
		}
	}

	/**
	 * Make a move
	 * 
	 * @param move
	 */
	void doMove(Move move) {
		ChessPiece curr = board[move.getOriginX()][move.getOriginY()].getPiece();		
		this.board[move.getFinalX()][move.getFinalY()].setPiece(curr);
		this.board[move.getOriginX()][move.getOriginY()].setPiece(null);
		toggleTurn();
		updatePiece();
	
	}

	private void updatePiece() {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].getPiece() != null) {
					board[i][j].getPiece().UpDateListCanMove(i, j, board);
				}
			}
		}
	}

	/**
	 * Check if move is legal then make a move,if make a move then toggle player
	 * turn
	 * 
	 * @param move
	 * @return
	 */
	public boolean isMakeLegalMove(Move move) {
		MoveChecker moveChecker = new MoveChecker(this, move);
		ChessPiece curr = board[move.getOriginX()][move.getOriginY()].getPiece();
		if (moveChecker.isLegal() && ((isPlayer1Turn == curr.getColor()))) {
			doMove(move);
			
			return true;
		}

		return false;
	}

	public Tile[][] getBoard() {
		return board;
	}

	public boolean isPlayer1Turn() {
		return isPlayer1Turn;
	}

	public void setPlayer1Turn(boolean isPlayer1Turn) {
		this.isPlayer1Turn = isPlayer1Turn;
	}

	public List<ChessPiece> getListPieceRedAlive() {
		return listPieceRedAlive;
	}

	public void setListPieceRedAlive(List<ChessPiece> listPieceRedAlive) {
		this.listPieceRedAlive = listPieceRedAlive;
	}

	public List<ChessPiece> getListPieceBlAlive() {
		return listPieceBlAlive;
	}

	public void setListPieceBlAlive(List<ChessPiece> listPieceBlAlive) {
		this.listPieceBlAlive = listPieceBlAlive;
	}

	public void setBoard(Tile[][] board) {
		this.board = board;
	}

	public Tile getTile(int x, int y) {
		return board[x][y];
	}

	public void toggleTurn() {
		isPlayer1Turn = !isPlayer1Turn;
	}

	public int getTileSize() {
		return this.tilesize;
	}

	public int heuristic() {
		int totalRed = 0;
		int totalBlack = 0;
		for (ChessPiece piece : listPieceRedAlive) {
			totalRed += piece.heuristic();
		}
		for (ChessPiece piece : listPieceBlAlive) {
			totalBlack += piece.heuristic();
		}
//		int res = totalRed-totalBlack;
		
		int res=totalBlack -totalRed;
		return res;

	}

	public void attack(Move move) {
		// TODO Auto-generated method stub
		ChessPiece piece = board[move.getFinalX()][move.getFinalY()].getPiece();
		if(piece instanceof General) {endgame=true;
		System.out.println("end");}
		if (piece.color) {
			listPieceRedAlive.remove(piece);
		} else {
			listPieceBlAlive.remove(piece);
		}
		board[move.getFinalX()][move.getFinalY()].setPiece(null);
	}

	public boolean isGameOver() {
		if (checkMate()) {
			return true;
			// set Winner
		}
		return false;
	}

	private boolean checkMate() {
		// if no valid move for general return true
		return endgame;
	}
//	sao chép bàn cờ thành 1 bàn cờ mới(deep copy)
	public ChessBoard clone() {
		Tile[][]copyboard= new Tile[9][10];
		List<ChessPiece> listRedCopy= new ArrayList<>();
		List<ChessPiece> listBlackCopy= new ArrayList<>();
		for (int i = 0; i < copyboard.length; i++) {
			for (int j = 0; j < copyboard[0].length; j++) {
				// tọa độ x,y sao cho khớp 1 ô là vị trí quân trên đường của bàn cờ
				int x = i * tilesize + marginTop - tilesize / 2;
				int y = j * tilesize + marginLeft - tilesize / 2;
				copyboard[i][j] = new Tile(x, y, tilesize);
				if(board[i][j].getPiece()!=null) {
					copyboard[i][j].setPiece(board[i][j].getPiece().clone());
					if (board[i][j].getPiece().color) {
						listRedCopy.add(board[i][j].getPiece());
					} else {
						listBlackCopy.add(board[i][j].getPiece());
					}
				}
			}
		}
		return new ChessBoard(copyboard, listRedCopy, listBlackCopy);
	}
}
