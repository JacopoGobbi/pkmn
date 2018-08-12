package io.github.jacopogobbi.pkmn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements KeyEventDispatcher {
	private static final long serialVersionUID = 1L;
	
	private PokemonPanel pokemonPanel;
	private JTabbedPane tabs;
	DevelopmentPanel developmentPanel;
	
	public static void main(String args[]) {
        @SuppressWarnings("unused")
        Window w = new Window();
	}

    private Window() {
    	Thread game, development;
		this.setTitle("Pokemon");
		tabs = new JTabbedPane();
		pokemonPanel = new PokemonPanel();
		//developmentPanel = new DevelopmentPanel();
		game = new Thread(pokemonPanel);
		//development = new Thread(developmentPanel);
		tabs.addTab("Gioco", null, pokemonPanel);
		//tabs.addTab("Sviluppo", null, developmentPanel);
		this.add(tabs);
		this.setJMenuBar(PokemonPanel.menuBar);
		
		this.setSize(1024, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(this);
    }
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
        	int key = e.getKeyCode();
        	pokemonPanel.moveMap(key);
        	/*debugPanel = new DebugPanel();
        	tabs.remove(debugPanel);
        	tabs.addTab("Sviluppo", null, debugPanel);*/
        	
        }
        else if (e.getID() == KeyEvent.KEY_RELEASED) {}
        else if (e.getID() == KeyEvent.KEY_TYPED) {}
        return false;
    }	
}
