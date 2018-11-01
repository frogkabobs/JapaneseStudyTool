package run;

import javax.swing.JApplet;

import com.sun.javafx.application.PlatformImpl;

@SuppressWarnings("serial")
public class JapRunner extends JApplet {

	//change to javafx Application and call Application.launch();

	public JapRunner() {
		new Window();
	}
	
	public static void main(String args[]) {
	    java.awt.EventQueue.invokeLater(new Runnable() {
	        public void run() {
	        	PlatformImpl.startup(()->{});//hacky
	            new JapRunner().setVisible(true);
	        }
	    });
	}
	

	
}