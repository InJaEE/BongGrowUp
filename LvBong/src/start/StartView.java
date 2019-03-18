package start;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class StartView extends JFrame {

	private int f_width, f_height;
	private JTextArea notice;
	private JButton newGame, loadGame, exitGame;
	private JLabel flagLabel;
	private Toolkit tk;

	public StartView() {
		setLayout(null);
		notice = new JTextArea("BBJ Grow Up");
		newGame = new JButton("새로하기");
		loadGame = new JButton("이어하기");
		exitGame = new JButton("종료하기");
		flagLabel = new JLabel("→");
		tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		f_width = 500;
		f_height = 400;
		int f_xpos = (int) (screen.getWidth() / 2 - f_width / 2);
		int f_ypos = (int) (screen.getHeight() / 2 - f_height / 2)-50;

		notice.setEditable(false);
		notice.setBounds(100, 30, 300, 150);
		newGame.setBounds(200, 200, 100, 50);
		loadGame.setBounds(200, 250, 100, 50);
		exitGame.setBounds(200, 300, 100, 50);
		flagLabel.setBounds(180, 225, 100, 100);

		add(notice);
		add(newGame);
		add(loadGame);
		add(exitGame);
		add(flagLabel);
		
		
		this.requestFocus(); 
		setFocusable(true);

		StartController sc = new StartController(this);
		addWindowListener(sc);
		addKeyListener(sc);
		newGame.addActionListener(sc);
		loadGame.addActionListener(sc);
		exitGame.addActionListener(sc);
		

		setSize(f_width, f_height);
		setLocation(f_xpos, f_ypos);
		setResizable(false);
		setVisible(true);
	}

	public JTextArea getNotice() {
		return notice;
	}

	public JButton getNewGame() {
		return newGame;
	}

	public JButton getLoadGame() {
		return loadGame;
	}

	public JButton getExitGame() {
		return exitGame;
	}

	public JLabel getFlagLabel() {
		return flagLabel;
	}

}
