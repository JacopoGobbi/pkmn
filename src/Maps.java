import javax.swing.ImageIcon;

public class Maps {
	public static final int
		MAPS[] = {
			0, 1, 2, 3
		},
		PERCORSO104 = 0,
		PETALIPOLI = 1,
		PERCORSO102 = 2,
		SOLAROSA = 3,
		maps[][][] = {
			Percorso104.map,
			Petalipoli.map,
			Percorso102.map,
			Solarosa.map
		},
		sizeX[] = {
			Percorso104.sizeX,
			Petalipoli.sizeX,
			Percorso102.sizeX,
			Solarosa.sizeX
		},
		sizeY[] = {
			Percorso104.sizeY,
			Petalipoli.sizeY,
			Percorso102.sizeY,
			Solarosa.sizeY
		},
		errorXRight[] = {
			Percorso104.sizeY,
			Petalipoli.sizeY,
			Percorso102.sizeY,
			Solarosa.sizeY
		},
		errorYRight[] = {
			Percorso104.sizeY,
			Petalipoli.sizeY,
			Percorso102.sizeY,
			Solarosa.sizeY
		},
		errorXCenter[] = {
			Percorso104.sizeY,
			Petalipoli.sizeY,
			Percorso102.sizeY,
			Solarosa.sizeY
		},
		errorYCenter[] = {
			Percorso104.sizeY,
			Petalipoli.sizeY,
			Percorso102.sizeY,
			Solarosa.sizeY
		},
		errorXLeft[] = {
			Percorso104.sizeY,
			Petalipoli.sizeY,
			Percorso102.sizeY,
			Solarosa.sizeY
		},
		errorYLeft[] = {
			Percorso104.sizeY,
			Petalipoli.sizeY,
			Percorso102.sizeY,
			Solarosa.sizeY
		}
	;
	public static int[] getMapBounds(int mapSizeX, int mapSizeY, int currentPlayerX, int currentPlayerY) {
		return new int[]{
			(mapSizeX	/16			/2		-(currentPlayerX+1))	*16,
			(mapSizeY	/16			/2		-(currentPlayerX+1))	*16
		};
	}
	public static int[] leftMapsBounds(int mapSizeX, int mapSizeY, int mapLeft, int mapGetX, int mapGetY) {
		int ar[] = new int[2];
		switch(mapLeft) {
			case PERCORSO104:
				ar[0] = mapGetX-Maps.sizeX[mapLeft];
				ar[1] = mapGetY-800;
			break;
			case PETALIPOLI:
				ar[0] = mapGetX-Maps.sizeX[mapLeft];
				ar[1] = mapGetY-160;
			break;
			case PERCORSO102:
			
			break;
			case SOLAROSA:
			
			break;
				
		}
		return ar;
	}
	public static int[] rightMapsBounds(int mapSizeX, int mapSizeY, int mapRight, int mapImageGetX, int mapImageGetY) {
		int ar[] = new int[2];
		switch(mapRight) {
			case PERCORSO104:
			break;
			case PETALIPOLI:
			
			break;
			case PERCORSO102:
				ar[0] = mapImageGetX+mapSizeX;
				ar[1] = mapImageGetY+160;
			
			break;
			case SOLAROSA:
				ar[0] = mapImageGetX+mapSizeX;
				ar[1] = mapImageGetY;
			break;
				
		}
		return ar;
	}
	public static final ImageIcon
		mapsImages[] = {
			Percorso104.mapImage,
			Petalipoli.mapImage,
			Percorso102.mapImage,
			Solarosa.mapImage
		}			
	;
}