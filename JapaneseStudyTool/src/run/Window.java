package run;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Test.Tester;
import backbone.Term;
import backbone.TermsList;
import gui.SearchBar;
import gui.SearchPanel;
import gui.TitleScreen;

/**
 * 
 * @author QuincyJohnson
 * @version 09/25/18 v1.0.0
 */
public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	public static final Dimension SCREEN_SIZE = new Dimension(1270, 720);
	public static final Dimension GAME_SIZE = new Dimension(1270, 720);
	public static final String TITLE = "Jacob's Japanese Quiz v1.0.0";
	public static final Color BACKGROUND_COLOR = Color.BLACK;
	public static final Color FOREGROUND_COLOR = Color.WHITE;
	public static FlowLayout layout;
	public static boolean isRunning = false;

	TitleScreen ts = new TitleScreen(1270, 720);
	
	public Window() {
		init();
	}
	
	
	public void init(){
		layout = new FlowLayout(FlowLayout.LEADING, 0, 0);
	    layout.setVgap(0);
	    setResizable(false);
	    setLayout(layout);
		setSize(SCREEN_SIZE);
		setTitle(TITLE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(BACKGROUND_COLOR);
		setForeground(FOREGROUND_COLOR);
		//add searchbar first. add searchabr functionality
		SearchPanel sp = Tester.sPanel();
		Window w = this;
		add(ts);
		add(new SearchBar(1270, 40,sp));
		add(sp);
		ts.termSearch.addActionListener(u -> {
			rem();
		});
		
		setVisible(true);
		//pack();
	}
	
	public void rem() {
		getContentPane().remove(ts);
		revalidate();
		repaint();
		
	}
}