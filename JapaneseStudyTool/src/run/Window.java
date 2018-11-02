package run;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Test.Tester;
import backbone.Flashcard;
import backbone.Term;
import backbone.TermsList;
import gui.SearchBar;
import gui.SearchPanel;
import gui.TermBox;
import gui.TermBoxWrapper;
import gui.TitleScreen;
import gui.WrapperPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
	public ArrayList<MediaPlayer> songs = new ArrayList<>();
	public int index = 0;
	public TermsList flashcards/* = new ArrayList<>()*/;
	//add song player class
	TitleScreen ts = new TitleScreen(1270, 720);
	
	public Window() {
		songLoad();
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
		flashcards = new TermsList(Tester.flashcards());
		SearchPanel fp = new SearchPanel(1265, 720, flashcards, false);
		add(ts);
		//add(new SearchBar(1270, 40,sp));
		//add(sp);
		//add(fp);
		sp.setEnabled(false);
		fp.setEnabled(false);
		ts.termSearch.addActionListener(u -> {
			reorder(sp);
		});
		
		ts.flashcards.addActionListener(u -> {
			reorder(fp);
		});
		for(TermBoxWrapper tb : fp.boxes) {
			tb.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					reorder(new SearchPanel(1265, 720, ((Flashcard)tb.termBox.term).terms, true));
					
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		sp.addToFlashcards.addActionListener(u -> {
			reorder(fp);
			fp.addToFlashcards.addActionListener(v->{
				for(TermBoxWrapper tbw : sp.boxes) {
					for(TermBoxWrapper tb : fp.boxes) {
						((Flashcard)tb.termBox.term).terms.add(tbw.termBox.term);
					}
				}
				reorder(sp);
			});
		});
		setVisible(true);
		//pack();
	}
	
	public void rem() { //remove
		getContentPane().remove(ts);
		revalidate();
		repaint();
		
	}
	
	public void reorder(Component c) {
		c.setEnabled(true);
		Component comp = getContentPane().getComponents()[0];
		getContentPane().remove(comp);
		add(c);
		comp.setEnabled(false);
		revalidate();
		repaint();
	}
	
	public void songLoad() {
		try (Stream<Path> paths = Files.walk(Paths.get("Files"))) {
		    paths.filter(Files::isRegularFile).forEach(u -> songs.add(new MediaPlayer(new Media(u.toUri().toString()))));
		} catch(IOException e) {
			e.printStackTrace();
		}
		for(MediaPlayer mp : songs) {
			mp.setCycleCount(MediaPlayer.INDEFINITE);
			mp.setOnRepeat(() -> {
				mp.pause();
				songs.get(index = ++index % songs.size()).play();
			});
		}
		songs.get(0).play();
	}
}