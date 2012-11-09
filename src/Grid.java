import java.util.Arrays;
import java.util.List;


public abstract class Grid<P> implements Pict {
	private P[][] grid;
	
	public Grid(P[][] grid) {
		this.grid = grid;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		int rows = grid.length;
		int cols = grid[0].length;
		String[][] rendered = new String[rows][cols];
		String[][][] extended = new String[rows][cols][];
		int height = 0;
		int width = 0;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				String elem = grid[i][j].toString();
				rendered[i][j] = elem;
				
				String[] lines = elem.split("\n");
				if(lines.length > height) {
					height = lines.length;
				}
				if(lines[0].length() > width) {
					width = lines[0].length();
				}
			}
		}


		char[] emptyLine = new char[width];
		Arrays.fill(emptyLine, ' ');
		String empty = emptyLine.toString();
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				String[] orig = rendered[i][j].split("\n");
				String[] ext = new String[height];
				
				for(int line = 0; line < orig.length; line++) {
					StringBuilder sb = new StringBuilder();
					sb.append(orig[line]);
					sb.append(empty.substring(orig.length));
					ext[line] = sb.toString();
				}
				
				Arrays.fill(ext, orig.length, height, empty);
				extended[i][j] = ext;
			}
		}

		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				
			}
		}
		
		return builder.toString();
	}
}
