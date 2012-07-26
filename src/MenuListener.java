import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(PokemonPanel.mapMenuItems[0].getText())) {
			int 
				x = PokemonPanel.mapImageLeft.getX()-PokemonPanel.mapImage.getX(),
				y = PokemonPanel.mapImageLeft.getY()-PokemonPanel.mapImage.getY()
			;
			System.out.println("Da Sinistra: X = " + x + " Y = " + y + "\n");
		}
		else if (e.getActionCommand().equals(PokemonPanel.fileMenuItems[0].getText())) {
			System.exit(0);
		}
	}
}
