package start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;

import javax.swing.JOptionPane;

import common.MainView;
import game.game;

public class StartController extends WindowAdapter implements ActionListener, KeyListener {

	private StartView sv;
	private int cursorFlag;
	
	public StartController(StartView sv) {
		this.sv=sv;
		cursorFlag=1;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if(cursorFlag==1) {
				sv.getFlagLabel().setBounds(180, 180, 100, 100);
				cursorFlag=0;
				break;
			} else if(cursorFlag==2) {
				sv.getFlagLabel().setBounds(180, 225, 100, 100);
				cursorFlag=1;
				break;
			}
			
			break;
		case KeyEvent.VK_DOWN:
			if(cursorFlag==0) {
				sv.getFlagLabel().setBounds(180, 225, 100, 100);
				cursorFlag=1;
				break;
			} else if(cursorFlag==1) {
				sv.getFlagLabel().setBounds(180, 275, 100, 100);
				cursorFlag=2;
				break;
			} else if(cursorFlag==2) {
				sv.getFlagLabel().setBounds(180, 275, 100, 100);
				cursorFlag=2;
				break;
			}
			
		case KeyEvent.VK_ENTER:
			if(cursorFlag==0) {
				sv.dispose();
				new MainView();
				break;
			}
			if(cursorFlag==1) {
				sv.dispose();
				new game();
				break;
			}
			if(cursorFlag==2) {
				sv.dispose();
				break;
			}
			
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == sv.getNewGame()) {
			sv.dispose();
			new MainView();
			return;
		}
		if(e.getSource() == sv.getLoadGame()) {
			sv.dispose();
			new game();
			return;
		}
		if(e.getSource() == sv.getExitGame()) {
			JOptionPane.showMessageDialog(sv, "종료하기");
//			sv.dispose();
			return;
		}
		
	}
}
