package gui;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JPanel;

public class WrapperPanel extends JPanel {
	
	@Override
	public void setEnabled(boolean b) {
		super.setEnabled(b);
		iterativeSetEnabled(b, this);
	}
	
	private static void iterativeSetEnabled(boolean b, Container c) {
		for(Component co : c.getComponents()) {
			co.setEnabled(b);
			if(co instanceof Container && !(co instanceof WrapperPanel)) iterativeSetEnabled(b,(Container)co);
		}
	}
}
