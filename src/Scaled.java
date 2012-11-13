/**
 * 
 * @author Koegler Alexander
 * 
 * @param <P>
 *            Typ der Elemente
 */
public class Scaled<P extends Pict> extends Grid<P> {
	// Invariante: grid ist rechteckig (alle Zeilen sind gleich lang)
	// Invariante: die toString Darstellung der Elemente in grid enthaelt
	// ausschliesslich druckbare Zeichen (Zeilenumbrueche ausgenommen)
	private P[][] grid;

	/**
	 * Erstellt ein neues Scaled Objekt aus dem angegebenen Array.
	 * 
	 * Vorbedingung: grid ist rechteckig (alle Zeilen sind gleich lang)
	 * Vorbedingung: die toString Darstellung der Elemente in grid enthaelt
	 * ausschliesslich druckbare Zeichen (Zeilenumbrueche ausgenommen)
	 */
	public Scaled(P[][] grid) {
		super(grid);
		this.grid = grid;
	}

	/**
	 * Veraendert die Groesse des Bildes. Dabei werden die einzelenen Elemente
	 * des grids mit factor skaliert.
	 * 
	 * Vorbedingung: 0.1 <= factor <= 10.0
	 */
	@Override
	public void scale(double factor) {
		for (P[] row : this.grid) {
			for (P element : row) {
				element.scale(factor);
			}
		}
	}
}
