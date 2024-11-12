package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import Controller.IController;
import Model.ChessPiece;

public class Listener implements MouseListener {
	IController controll;
	boolean reach = false; //biến này dùng để kiểm tra xem có click vào quân cờ hay chưa
	ChessPiece chesspiece;
	Panel panel;
	public Listener(IController controll, Panel panel) {
		// TODO Auto-generated constructor stub
		this.controll = controll;
		this.panel=panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (reach == false) {
			chesspiece = controll.select(e.getX(), e.getY());

			if (chesspiece != null) {
				reach = true;
				System.out.println("is select");
			}
		} else {
			controll.move(chesspiece,e.getX(),e.getY());
			try {
				// cap nhat lai hinh anh
				panel.refresh();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			reach = false;
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}