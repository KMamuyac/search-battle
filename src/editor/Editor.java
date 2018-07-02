package editor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editor extends JFrame {
	
	private static final long serialVersionUID = 5374292351259402378L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Editor(Controller controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMap = new JMenuItem("New Map");
		mntmNewMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        int width = Integer.parseInt(JOptionPane.showInputDialog("Input width for new map: "));
		        int height = Integer.parseInt(JOptionPane.showInputDialog("Input height for new map: "));
		        controller.newMap(width, height);
			}
		});
		mnFile.add(mntmNewMap);
		
		JMenuItem mntmOpenMap = new JMenuItem("Open Map");
		mntmOpenMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser c = new JFileChooser();
				int rVal = c.showOpenDialog(Editor.this);
				if(rVal == JFileChooser.APPROVE_OPTION) {
					controller.openMap(c.getSelectedFile().getAbsolutePath());
				}
			}
		});
		mnFile.add(mntmOpenMap);
		
		JMenuItem mntmSaveMap = new JMenuItem("Save Map");
		mntmSaveMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.save();
			}
		});
		mnFile.add(mntmSaveMap);
		
		JMenu mnTool = new JMenu("Tool");
		menuBar.add(mnTool);
		
		JMenuItem mntmSpace = new JMenuItem("Space");
		mntmSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectSpace();
			}
		});
		mnTool.add(mntmSpace);
		
		JMenuItem mntmWall = new JMenuItem("Wall");
		mntmWall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.selectWall();
			}
		});
		mnTool.add(mntmWall);
		
		JMenuItem mntmTreasure = new JMenuItem("Treasure");
		mntmTreasure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectTreasure();
			}
		});
		mnTool.add(mntmTreasure);
		
		JMenuItem mntmBot = new JMenuItem("Bot");
		mnTool.add(mntmBot);
		
		JMenuItem mntmEnemy = new JMenuItem("Enemy");
		mntmEnemy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectEnemy();
			}
		});
		mnTool.add(mntmEnemy);
		
		JMenuItem mntmBotandy = new JMenuItem("BotAndy");
		mntmBotandy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.selectBotAndy();
			}
		});
		mnTool.add(mntmBotandy);
		
		JMenuItem mntmBotbrad = new JMenuItem("BotBrad");
		mntmBotbrad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectBotBrad();
			}
		});
		mnTool.add(mntmBotbrad);
		
		JMenuItem mntmBotChip = new JMenuItem("BotChip");
		mntmBotChip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectBotChip();
			}
		});
		mnTool.add(mntmBotChip);
		
		JMenuItem mntmBotdave = new JMenuItem("BotDave");
		mntmBotdave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectBotDave();
			}
		});
		mnTool.add(mntmBotdave);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
