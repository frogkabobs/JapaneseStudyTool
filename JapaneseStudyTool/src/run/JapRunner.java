package run;

import javax.swing.JApplet;

@SuppressWarnings("serial")
public class JapRunner extends JApplet {

	

	public JapRunner() {
		new Window();
	}
	
	public static void main(String args[]) {
	    java.awt.EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            new JapRunner().setVisible(true);
	        }
	    });
	}
	

	
}