package io.github.jacopogobbi.pkmn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


// Pannello
public class PokemonPanel extends JPanel implements ActionListener, Runnable {
	private static final long serialVersionUID = 1L;
	//Immagini dei pokemon
	static PokemonImages pkmn;
	//Pulsante provvisorio pokemon
	static JButton button;
	//Menu
	MenuListener menuListener;
	static JMenuBar menuBar;
	static JMenu fileMenu, developmentMenu, mapSubMenu;
	static JMenuItem fileMenuItems[], mapMenuItems[];
	//immagini: mappa centrale, mappa di sinistra, mappa di destra, ash
	static JLabel mapImage, mapImageLeft, mapImageRight, ash;
	// contatore, punto trovato durante il cambio mappa
	static int i, pointFound[];
	// ID mappa attuale, x e y mappa attuale, dimensioni x e y mappa attuale/sinistra/destra
	static int currentMap, currentY, currentX, mapSizeX, mapSizeY, mapLeftSizeX, mapLeftSizeY, mapRightSizeX, mapRightSizeY;
	// Sprite di ash
	private static final ImageIcon
		ashFront = new ImageIcon("../overworld/ashFront.png"),
		ashBack = new ImageIcon("../overworld/ashBack.png"),
		ashLeft = new ImageIcon("../overworld/ashLeft.png"),
		ashRight = new ImageIcon("../overworld/ashRight.png")
	;
	// Animazione del pokemon sul pulsante
	boolean animatedPokemon;
	public void run() {
		
	}
	PokemonPanel() {
		// pokemon corrente
		i = 380;
		/* |File|Development|
		 * 
		 * |File|
		 * 	-|Esci|
		 * 
		 * |Development|
		 * 	-|Map| -> -|Save current map Position|
		 */
		menuListener = new MenuListener();
		fileMenuItems = new JMenuItem[1];
		mapMenuItems = new JMenuItem[1];
		
		fileMenuItems[0] = new JMenuItem("Esci");
		mapMenuItems[0] = new JMenuItem("Save new current map position");

		mapSubMenu = new JMenu("Map");
		
		developmentMenu = new JMenu("Development");
		fileMenu = new JMenu("File");
		
		menuBar = new JMenuBar();
		//Istanze
		pointFound = new int[2];
		this.animatedPokemon = false;
		this.pkmn = new PokemonImages();
		this.button = new JButton(pkmn.pokemon[i][0]);
		this.ash = new JLabel(ashFront);
		//Mappa attuale
		currentMap = Maps.PETALIPOLI;
		//posizione di ash
		ash.setBounds(
				//Dimensione mappa diviso 2 (al centro) - larghezza e altezza di ash
				Petalipoli.sizeX /2 -ash.getWidth(),
				Petalipoli.sizeY /2 -ash.getHeight(),
				//Larghezza e altezza di ash
				14,
				20
		);
		//Inizializza la mappa e i vari componenti
		Initialize(currentMap-1, currentMap, currentMap+1, 6, 6);
		
		//Ascoltatori per il menu e il pulsante
		//this.button.addActionListener(this);
		this.fileMenuItems[0].addActionListener(menuListener);
		this.mapMenuItems[0].addActionListener(menuListener);
		
		//Posizione pulsante
		//this.button.setBounds(100, 100, 80, 80);
		//Menu
		mapSubMenu.add(mapMenuItems[0]);
		
		fileMenu.add(fileMenuItems[0]);
		developmentMenu.add(mapSubMenu);

		menuBar.add(fileMenu);
		menuBar.add(developmentMenu);
		
		this.add(menuBar);
		this.add(button);

		//Nessun layout
		this.setLayout(null);
	}
	
	void Initialize(int mapLeft, int map, int mapRight, int currentX, int currentY) {
		currentMap = map;
		this.currentX = currentX;//Petalipoli.getSizeX()/16/2;
		this.currentY = currentY;//Petalipoli.getSizeY()/16/2;
		//rimuove tutto e resetta tutto
		this.removeAll();
		mapImage = null;
		mapImageLeft = null;
		mapImageRight = null;
		mapImage = new JLabel(Maps.mapsImages[map]);
		mapImageLeft = new JLabel(Maps.mapsImages[mapLeft]);
		mapImageRight = new JLabel(Maps.mapsImages[mapRight]);
		mapSizeX = Maps.sizeX[map];
		mapSizeY = Maps.sizeY[map];
		mapRightSizeX = Maps.sizeX[mapRight];
		mapRightSizeY = Maps.sizeY[mapRight];
		mapLeftSizeX = Maps.sizeX[mapLeft];
		mapLeftSizeY = Maps.sizeY[mapLeft];
	
		this.mapImage.setBounds(
				// sizeX		tilesize	center	
				Maps.getMapBounds(mapSizeX, mapSizeY, currentX, currentY)[0],
				Maps.getMapBounds(mapSizeX, mapSizeY, currentX, currentY)[1],
				mapSizeX,
				mapSizeY
		);
		System.out.println("X = " + mapImage.getX() + " Y = " + mapImage.getY() + "\ncurrentX = " + currentX + " currentY = " + currentY);
		this.mapImageLeft.setBounds(
				// sizeX		tilesize	center	
				Maps.leftMapsBounds(mapSizeX, mapSizeY, mapLeft, mapImage.getX(), mapImage.getY())[0],
				Maps.leftMapsBounds(mapSizeX, mapSizeY, mapLeft, mapImage.getX(), mapImage.getY())[1],
				mapLeftSizeX,
				mapLeftSizeY
		);
		System.out.println(mapImage.getX());
		this.mapImageRight.setBounds(
				// sizeX		tilesize	center	
				Maps.rightMapsBounds(mapSizeX, mapSizeY, mapRight, mapImage.getX(), mapImage.getY())[0],
				Maps.rightMapsBounds(mapSizeX, mapSizeY, mapRight, mapImage.getX(), mapImage.getY())[1],
				mapRightSizeX,
				mapRightSizeY
		);
		this.add(ash);
		this.add(mapImage);
		this.add(mapImageLeft);
		this.add(mapImageRight);
	}

	public void actionPerformed(ActionEvent e) {
		if(animatedPokemon == true) {
			this.button.setIcon(pkmn.pokemon[i][0]);
		}
		else if(animatedPokemon == false) {
			this.button.setIcon(pkmn.pokemon[i][1]);
			i++;
		}
		System.out.println(i);
		this.animatedPokemon = !this.animatedPokemon;
	}
	@SuppressWarnings("static-access")
	public void moveMap(int key) {
		if(key == KeyEvent.VK_UP) {
			this.ash.setIcon(ashBack);
			if(currentX-1 >= 0)
				if((Maps.maps[currentMap][currentX-1][currentY] % Map.CANWALK) == 0) {
					mapImage.setBounds(mapImage.getX(), mapImage.getY()+16, mapImage.getWidth(), mapImage.getHeight());
					mapImageLeft.setBounds(mapImageLeft.getX(), mapImageLeft.getY()+16, mapImageLeft.getWidth(), mapImageLeft.getHeight());
					mapImageRight.setBounds(mapImageRight.getX(), mapImageRight.getY()+16, mapImageRight.getWidth(), mapImageRight.getHeight());
					--currentX;
				}
		}
		if(key == KeyEvent.VK_DOWN) {
			this.ash.setIcon(ashFront);
			if(currentX+1 < Maps.sizeY[currentMap]/16)
				if((Maps.maps[currentMap][currentX+1][currentY] % Map.CANWALK) == 0) {
					mapImage.setBounds(mapImage.getX(), mapImage.getY()-16, mapImage.getWidth(), mapImage.getHeight());
					mapImageLeft.setBounds(mapImageLeft.getX(), mapImageLeft.getY()-16, mapImageLeft.getWidth(), mapImageLeft.getHeight());
					mapImageRight.setBounds(mapImageRight.getX(), mapImageRight.getY()-16, mapImageRight.getWidth(), mapImageRight.getHeight());
					++currentX;
				}
		}
		if(key == KeyEvent.VK_LEFT) {
			this.ash.setIcon(ashLeft);
			if(currentY-1 >= 0)
				if((Maps.maps[currentMap][currentX][currentY-1]% Map.CANWALK) == 0) {
					mapImage.setBounds(mapImage.getX()+16, mapImage.getY(), mapImage.getWidth(), mapImage.getHeight());
					mapImageLeft.setBounds(mapImageLeft.getX()+16, mapImageLeft.getY(), mapImageLeft.getWidth(), mapImageLeft.getHeight());
					mapImageRight.setBounds(mapImageRight.getX()+16, mapImageRight.getY(), mapImageRight.getWidth(), mapImageRight.getHeight());			
					--currentY;
				}
		}
		if(key == KeyEvent.VK_RIGHT) {
			this.ash.setIcon(ashRight);
			if(currentY+1 < Maps.sizeY[currentMap]/16) {
				if((Maps.maps[currentMap][currentX][currentY+1] % Map.CANWALK) == 0) {
					mapImage.setBounds(mapImage.getX()-16, mapImage.getY(), mapImage.getWidth(), mapImage.getHeight());
					mapImageLeft.setBounds(mapImageLeft.getX()-16, mapImageLeft.getY(), mapImageLeft.getWidth(), mapImageLeft.getHeight());
					mapImageRight.setBounds(mapImageRight.getX()-16, mapImageRight.getY(), mapImageRight.getWidth(), mapImageRight.getHeight());
					++currentY;
				}
			}
			else if((Maps.maps[currentMap][currentX][currentY] %  Map.CHANGEMAP) == 0) {
				mapImage.setBounds(mapImage.getX()-16, mapImage.getY(), mapImage.getWidth(), mapImage.getHeight());
				mapImageLeft.setBounds(mapImageLeft.getX()-16, mapImageLeft.getY(), mapImageLeft.getWidth(), mapImageLeft.getHeight());
				mapImageRight.setBounds(mapImageRight.getX()-16, mapImageRight.getY(), mapImageRight.getWidth(), mapImageRight.getHeight());
				++currentY;
				pointFound = Map.findPoint(currentMap+1, Map.CHANGEMAP, 0, 0);
				Initialize(currentMap, currentMap+1, currentMap+2, pointFound[0], pointFound[1]);
			}
		}
	}

	
	/*void exec(String comando) {
    	try {
    		Runtime r = Runtime.getRuntime();
    		Process p = r.exec(comando);

    		BufferedReader in = new BufferedReader(new
    		InputStreamReader(p.getInputStream()));
    		String inputLine;
    		while ((inputLine = in.readLine()) != null)
    			System.out.println(inputLine);
    		in.close();

    	}
    	catch (IOException e) {
    		System.out.println(e);
    	}
	}*/
}