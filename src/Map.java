import javax.swing.ImageIcon;


public class Map {
	public static final int
		CANWALK = 2,
		CANTWALK = 3,
		CHANGEMAP = 5,
		sizeX = 0,
		sizeY = 0,
		map[][] = {{0}, {0}},
		errorXLeft = 0,
		errorYLeft = 0,
		errorXCenter = 0,
		errorYCenter = 0,
		errorXRight = 0,
		errorYRight = 0
	;
	public static final
		ImageIcon mapImage = new ImageIcon()
	;
	public static int[] findPoint(int theMap, int num, int k,  int l) {
		int ar[] = new int[2], i, j;
		for(i = k; i < (Maps.sizeX[theMap]/16); ++i)
			for(j = l; j < (Maps.sizeY[theMap]/16); ++j)
				if((Maps.maps[theMap][i][j] % num) == 0) {
					ar[0] = i;
					ar[1] = j;
					return ar;
				}
		ar[0] = -1;
		ar[1] = -1;
		return ar;
	}
}
