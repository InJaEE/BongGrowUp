package common;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class MainView extends JFrame{
	
	private int f_width, f_height;
	private JTextArea mainTa, stat1, stat2;
	private JTextField mainTf;
	private JScrollPane mainSp;
	private Toolkit tk;
	private Image tempImg, buffImage;
	private Graphics buffg;
	
	public MainView() {

		
		mainTa = new JTextArea("");
		stat1 = new JTextArea("stat", 3, 2);
		stat2 = new JTextArea("stat", 3, 2);
		
		mainTf = new JTextField();
		mainTa.setBorder(new TitledBorder("상태"));
		mainTf.setBorder(new TitledBorder("입력"));
		mainSp=new JScrollPane(mainTa);
		stat1.setEditable(false);
		mainTa.setEditable(false);
//		mainTf.requestFocus();
		setLayout(new BorderLayout());
		
		tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		f_width = 500;
		f_height = 400;
		int f_xpos = (int) (screen.getWidth() / 2 - f_width / 2);
		int f_ypos = (int) (screen.getHeight() / 2 - f_height / 2)-50;
		
		JPanel nn=new JPanel(new GridLayout(1, 2));
//		JPanel north = new imagePanel();
//		JPanel north = new game.game()
		
		nn.add(stat1);
		nn.add(stat2);
		
		add("North", nn);
		add("Center", mainSp);
		add("South", mainTf);
//		add(north);
//		repaint();
		
		MainController mc = new MainController(this);
		mainTf.addActionListener(mc);
		addWindowListener(mc);
		
		
		setSize(f_width, f_height);
		setLocation(f_xpos, f_ypos);
		setResizable(false);
		setVisible(true);
	}
	
	class imagePanel extends Panel{
		
		public imagePanel() {
			repaint();
		}
		public void paint(Graphics g) {
			tempImg = new ImageIcon(getClass().getResource("temp.png")).getImage();
			buffImage = createImage(f_width, f_height);
			buffg = buffImage.getGraphics();
	
			update(g);
		}
	
		public void update(Graphics g) {
			drawBackGround();
	
			g.drawImage(buffImage,0, 0, this);
		}
	
		public void drawBackGround() {
//			buffg.clearRect(0, 0, f_width, f_height);
	
			buffg.drawImage(tempImg, 0, 0, this);
		}
		
		
	}
	
	
	
	
	public JTextArea getMainTa() {
		return mainTa;
	}




	public JTextArea getStat1() {
		return stat1;
	}




	public JTextField getMainTf() {
		return mainTf;
	}




	public JScrollPane getMainSp() {
		return mainSp;
	}




	public static void main(String[] args) {
		new MainView();
	}

	
}
