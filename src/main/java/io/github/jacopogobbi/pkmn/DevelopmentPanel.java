package io.github.jacopogobbi.pkmn;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;


public class DevelopmentPanel extends JPanel implements Runnable {
	JList l;
	private DefaultListModel model = new DefaultListModel();
	String s[];
	DevelopmentPanel() {
		l = new JList(model);
		this.add(l);
	}
	public void run() {
		s = new String[] {
				("Ash X: " + Integer.toString(PokemonPanel.ash.getX())),
				("Ash Y: " + Integer.toString(PokemonPanel.ash.getY()))
			};
		for (int i=0; i<s.length; i++)
		    model.add(i, s[i]);
		this.repaint();
	}
}
