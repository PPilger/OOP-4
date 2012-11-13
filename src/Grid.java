import java.util.Arrays;

/**
 * Ein Bild, dass aus einem Grid mehrerer Elemente besteht.
 * 
 * @author Peter Pilgerstorfer
 * 
 * @param <P>
 *            Typ der Elemente
 */
public abstract class Grid<P> implements Pict {
	// Invariante: grid ist rechteckig (alle Zeilen sind gleich lang)
	// Invariante: die toString Darstellung der Elemente in grid enthaelt
	// ausschliesslich druckbare Zeichen (Zeilenumbrueche ausgenommen)
	private P[][] grid;

	/**
	 * Erstellt ein neues Grid aus dem angegebenen Array.
	 * 
	 * Vorbedingung: grid ist rechteckig (alle Zeilen sind gleich lang)
	 * Vorbedingung: die toString Darstellung der Elemente in grid enthaelt
	 * ausschliesslich druckbare Zeichen (Zeilenumbrueche ausgenommen)
	 */
	public Grid(P[][] grid) {
		this.grid = grid;
	}

	/**
	 * Gibt das Grid aus. Dabei wird die toString-Darstellung der Elemente
	 * verwendet. Alle Elemente werden dafuer (mit Leerzeichen) auf die selbe
	 * Groesse gebracht.
	 * 
	 * Nachbedingung: das zurueckgegebene Bild besteht nur aus druckbaren
	 * Zeichen.
	 */
	@Override
	public String toString() {
		// baut den Ergebnisstring
		StringBuilder builder = new StringBuilder();

		if (grid.length < 1 || grid[0].length < 1) {
			return "";
		}

		// Zeilen und Spaltenanzahl des Grids
		int rows = grid.length;
		int cols = grid[0].length;

		// Die Zeilen der toString-Ausgaben der Grid-Elemente
		String[][][] rendered = new String[rows][cols][];

		// Die erweiterten Elemente (mit Leerzeilen und Leerzeichen aufgefuellt)
		String[][][] extended = new String[rows][cols][];

		// Hoehe des hoechsten Elements
		int height = 0;

		// Breite des breitesten Elements
		int width = 0;

		// Eine Zeile voller Leerzeichen mit der Breite der Grid-Zellen
		String empty;

		// Elemente rendern und Groesse der Ausgabeelemente berechnen
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				String[] lines = grid[i][j].toString().split("\n");

				if (lines.length > height) {
					height = lines.length;
				}

				for (int line = 0; line < lines.length; line++) {
					if (lines[line].length() > width) {
						width = lines[line].length();
					}
				}

				rendered[i][j] = lines;
			}
		}

		// Zusicherung: height enthaelt die Hoehe des hoechsten Elements
		// Zusicherung: width enthaelt die Breite des breitesten Elements
		// Zusicherung: rendered enthaelt die (zeilenweise) toString-Darstellung
		// aller Elemente

		// Setzen des empty-Strings auf einen String der Breite width
		{
			char[] emptyLine = new char[width];
			Arrays.fill(emptyLine, ' ');

			empty = new String(emptyLine);
		}

		// Vergroesserung zu kleiner Elemente
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				String[] orig = rendered[i][j]; // original
				String[] ext = new String[height]; // vergroessert

				// Vergroesserung zu kurzer Zeilen
				for (int line = 0; line < orig.length; line++) {
					ext[line] = orig[line]
							+ empty.substring(orig[line].length());
				}

				// Anhaengen leerer Zeilen, um auf die volle Zeilenanzahl zu
				// kommen
				Arrays.fill(ext, orig.length, height, empty);

				// Zusicherung: ext hat height Zeilen mit je width Zeichen

				extended[i][j] = ext;
			}
		}

		// Bauen des Ausgabestrings anhand der vergroesserten Elemente
		for (int i = 0; i < rows; i++) {
			StringBuilder[] concatLines = new StringBuilder[height];

			for (int line = 0; line < height; line++) {
				concatLines[line] = new StringBuilder();
			}

			// Zeilenweise Verkettung der Ausgabeelemente
			for (int j = 0; j < cols; j++) {
				for (int line = 0; line < height; line++) {
					concatLines[line].append(extended[i][j][line]);
				}
			}

			// Zusicherung: in concatLines stehen die Ausgabezeilen der
			// aktuellen
			// Grid-Zeile

			// Verkettung der Zeilen
			for (int line = 0; line < height; line++) {
				builder.append(concatLines[line].toString());
				builder.append('\n');
			}
		}

		// Den letzten Zeilenumbruch entfernen
		builder.deleteCharAt(builder.length() - 1);

		return builder.toString();
	}
}
