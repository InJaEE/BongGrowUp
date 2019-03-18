package common;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainView extends JFrame{
	
	private int f_width, f_height;
	private JTextArea mainTa;
	private JTextField mainTf;
	private Toolkit tk;
	private Image tempImg, buffImage;
	private Graphics buffg;
	
	public MainView() {

		
		mainTa = new JTextArea("");
		mainTf = new JTextField("");
		
		mainTa.setEditable(false);
		setLayout(new BorderLayout());
		
		tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		f_width = 500;
		f_height = 400;
		int f_xpos = (int) (screen.getWidth() / 2 - f_width / 2);
		int f_ypos = (int) (screen.getHeight() / 2 - f_height / 2)-50;
		
//		tempImg = new ImageIcon(getClass().getResource("google.png")).getImage();
		
		Panel north = new Panel();
//		north.add(tempImg);
		
		add("North", north);
		add("Center", mainTa);
		add("South", mainTf);
		
//		repaint();
		setSize(f_width, f_height);
		setLocation(f_xpos, f_ypos);
		setResizable(false);
		setVisible(true);
	}
	
//	public void paint(Graphics g) {
//		buffImage = createImage(f_width, f_height);
//		buffg = buffImage.getGraphics();
//
//		update(g);
//	}
//
//	public void update(Graphics g) {
//		drawBackGround();
//
//		g.drawImage(buffImage, 0, 0, this);
//	}
//
//	public void drawBackGround() {
//		buffg.clearRect(0, 0, f_width, f_height);
//
//		buffg.drawImage(tempImg, 0, 0, this);
//	}
	
	
	
	
	public static void main(String[] args) {
		new MainView();
	}

	
}
