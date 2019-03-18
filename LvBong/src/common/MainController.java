package common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainController extends WindowAdapter implements ActionListener, KeyListener{

	private MainView mv;
	
	public MainController(MainView mv) {
		this.mv=mv;
		mv.getMainTf().requestFocus();
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		mv.dispose();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mv.getMainTf()) {
			if(!"".equals(mv.getMainTf().getText())) {
			mv.getMainTa().append(mv.getMainTf().getText()+"\n");
			mv.getMainTf().setText("");
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}


}
