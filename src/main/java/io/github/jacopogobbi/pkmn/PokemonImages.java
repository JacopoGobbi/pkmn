package io.github.jacopogobbi.pkmn;

import javax.swing.ImageIcon;

class PokemonImages {
	ImageIcon pokemon[][];
	private int i;
	PokemonImages() {
		pokemon = new ImageIcon[386][2];
		for(i=0; i < 386; ++i) {
			if(i < 10) {
				pokemon[i][0] = new ImageIcon("../pkmn/00" + (i+1) + "(1)(hgss).png");
				pokemon[i][1] = new ImageIcon("../pkmn/00" + (i+1) + "(2)(hgss).png");
			}
			else if(i < 100) {
				pokemon[i][0] = new ImageIcon("../pkmn/0" + (i+1) + "(1)(hgss).png");
				pokemon[i][1] = new ImageIcon("../pkmn/0" + (i+1) + "(2)(hgss).png");
			}
			else {
				pokemon[i][0] = new ImageIcon("../pkmn/" + (i+1) + "(1)(hgss).png");
				pokemon[i][1] = new ImageIcon("../pkmn/" + (i+1) + "(2)(hgss).png");
			}				
		}
	}
	PokemonImages(String folder) {
		pokemon = new ImageIcon[386][2];
		for(i=0; i < 386; ++i) {
			if(i < 10) {
				pokemon[i][0] = new ImageIcon("../" + folder + "/00" + (i+1) + "(1)(hgss).png");
				pokemon[i][1] = new ImageIcon("../" + folder + "/00" + (i+1) + "(2)(hgss).png");
			}
			else if(i < 100) {
				pokemon[i][0] = new ImageIcon("../" + folder + "/0" + (i+1) + "(1)(hgss).png");
				pokemon[i][1] = new ImageIcon("../" + folder + "/0" + (i+1) + "(2)(hgss).png");
			}
			else {
				pokemon[i][0] = new ImageIcon("../" + folder + "/" + (i+1) + "(1)(hgss).png");	
				pokemon[i][1] = new ImageIcon("../" + folder + "/" + (i+1) + "(2)(hgss).png");	
			}
		}
	}
}
