package game;

import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Game extends JFrame {

	private static final long serialVersionUID = 2832894152970309904L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Game(Controller controller) {
		setTitle("Search Battle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpenMap = new JMenuItem("Open Map");
		mntmOpenMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser c = new JFileChooser();
				int rVal = c.showOpenDialog(Game.this);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					controller.openMap(c.getSelectedFile().getAbsolutePath());
				}
			}
		});
		mnFile.add(mntmOpenMap);
		
		JMenuItem mntmOpenEditor = new JMenuItem("Open Editor");
		mnFile.add(mntmOpenEditor);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_SPACE)
					controller.togglePause();
			}
		});
	}

}
