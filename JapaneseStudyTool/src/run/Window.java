package run;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;

import backbone.Term;
import gui.SearchPanel;
import gui.TermButton;

/**
 * 
 * @author QuincyJohnson
 * @version 09/25/18 v1.0.0
 */
public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	public static final Dimension SCREEN_SIZE = new Dimension(1270, 662);
	public static final Dimension GAME_SIZE = new Dimension(1270, 662);
	public static final String TITLE = "Jacob's Japanese Quiz v1.0.0";
	public static final Color BACKGROUND_COLOR = Color.BLACK;
	public static final Color FOREGROUND_COLOR = Color.WHITE;
	public static FlowLayout layout;
	public static boolean isRunning = false;
	
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
		
		add(new SearchPanel(700,600,new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e")),new TermButton(new Term("happy","e"))));
		//addKeyListener(ds.gameplay.listener);
		setVisible(true);
		//pack();
		
	}
}