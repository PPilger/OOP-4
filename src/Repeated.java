/**
 * 
 * @author Koegler Alexander
 * 
 * @param <P>
 *            Typ der Elemente
 */
public class Repeated<P> extends Grid<P> {

	// Invariante: 0.1 <= factor <= 10.0
	private double scaleVal = 1;

	/**
	 * Erstellt ein neues Repeated Objekt aus dem angegebenen Array.
	 * 
	 * Vorbedingung: grid ist rechteckig (alle Zeilen sind gleich lang)
	 * Vorbedingung: die toString Darstellung der Elemente in grid enthaelt
	 * ausschliesslich druckbare Zeichen (Zeilenumbrueche ausgenommen)
	 */
	public Repeated(P[][] grid) {
		super(grid);
	}

	/**
	 * Veraendert die Groesse des Bildes. Wenn factor <= 1, wird der links obere
	 * Teil des Bildes mit toString zurueckgegeben. Wenn factor > 1, wird das
	 * Bild wiederholt aneinandergereiht um auf die gewuenschte Groesse zu
	 * kommen.
	 * 
	 * Vorbedingung: 0.1 <= factor <= 10.0
	 */
	@Override
	public void scale(double factor) {
		scaleVal = factor;
	}

	/**
	 * Gibt das Grid aus. Dabei wird die toString-Darstellung der Elemente
	 * verwendet. Alle Elemente werden dafuer (mit Leerzeichen) auf die selbe
	 * Groesse gebracht.
	 * 
	 * Wenn das Bild um einen Faktor factor skaliert wurde gilt folgendes:
	 * 
	 * Wenn factor < 1, wird der links obere Teil des Bildes mit toString
	 * zurueckgegeben. Wenn factor > 1, wird das Bild wiederholt
	 * aneinandergereiht um auf die gewuenschte Groesse zu kommen.
	 * 
	 * Nachbedingung: das zurueckgegebene Bild besteht nur aus druckbaren
	 * Zeichen.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String full = super.toString();
		String[] lines = full.split("\n");

		if (lines.length < 1 || lines[0].length() < 1) {
			return "";
		}

		int lineLength = lines[0].length();

		int height = (int) Math.ceil(lines.length * scaleVal);
		int width = (int) Math.ceil(lineLength * scaleVal);

		for (int i = 0; i < Math.min(height, lines.length); i++) {
			int w = width;

			for (; w > lineLength; w -= lineLength) {
				builder.append(lines[i]);
			}

			builder.append(lines[i].substring(0, w));
			builder.append('\n');
		}

		return builder.substring(0, builder.length() - 1);
	}
}
