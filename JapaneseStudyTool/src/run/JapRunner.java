package run;

import javax.swing.JApplet;

public class JapRunner extends JApplet {

	private static final long serialVersionUID = 1L;
	

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