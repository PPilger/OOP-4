import java.util.Arrays;

public abstract class Grid<P> implements Pict {
	private P[][] grid;

	public Grid(P[][] grid) {
		this.grid = grid;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		int rows = grid.length;
		int cols = grid[0].length;
		String[][][] rendered = new String[rows][cols][];
		String[][][] extended = new String[rows][cols][];
		int height = 0;
		int width = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				rendered[i][j] = grid[i][j].toString().split("\n");
				String[] lines = rendered[i][j];
				
				if (lines.length > height) {
					height = lines.length;
				}
				
				for(int line = 0; line < lines.length; line++) {
					if (lines[line].length() > width) {
						width = lines[0].length();
					}
				}
			}
		}

		char[] emptyLine = new char[width];
		Arrays.fill(emptyLine, ' ');
		String empty = new String(emptyLine);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				String[] orig = rendered[i][j];
				String[] ext = new String[height];

				for (int line = 0; line < orig.length; line++) {
					StringBuilder sb = new StringBuilder();
					sb.append(orig[line]);
					sb.append(empty.substring(orig[line].length()));
					ext[line] = sb.toString();
				}

				Arrays.fill(ext, orig.length, height, empty);
				extended[i][j] = ext;
			}
		}

		for (int i = 0; i < rows; i++) {
			StringBuilder[] concatLines = new StringBuilder[height];

			for (int line = 0; line < height; line++) {
				concatLines[line] = new StringBuilder();
			}

			for (int j = 0; j < cols; j++) {
				String[] currentLines = extended[i][j];

				for (int line = 0; line < height; line++) {
					concatLines[line].append(currentLines[line]);
				}
			}

			for (int line = 0; line < height; line++) {
				concatLines[line].append('\n');
				builder.append(concatLines[line].toString());
			}
		}

		return builder.toString();
	}
}
