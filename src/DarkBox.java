/**
 * Untertyp vom Obertyp "Pict"
 * 
 * @author Christian Kletzander
 */
public class DarkBox implements Pict {

	private char zeichen;
	private double width;
	private double height;

	/**
	 * Vorbedingung: Das Zeichen darf kein Leerzeichen sein.
	 * 
	 * @param width
	 *            Die Breite der Box
	 * @param height
	 *            Die Hoehe der Box
	 * @param zeichen
	 *            Das Zeichen, welches den Rand sowie das Innere der Box
	 *            darstellt
	 */
	public DarkBox(int width, int height, char zeichen) {
		this.zeichen = zeichen;
		this.width = width;
		this.height = height;
	}

	/**
	 * NOTE: Aendert das aktuelle Zeichen der DarkBox auf das neu gewaehlte.
	 * 
	 * Vorbedingung: Das Zeichen c darf nicht ein Leerzeichen sein.
	 * 
	 * @param c
	 *            Das neue Zeichen der DarkBox.
	 */
	public void changeChar(char c) {
		this.zeichen = c;
	}

	/** 
	 * @Override
	 * 
	 * Note: Returniert das Bild als String
	 * 
	 * Vorbedingung: 0.1 <= factor <= 10.0
	 * 
	 * @factor
	 * 		Ein Faktor zum skalieren des Bildes
	 */
	public void scale(double factor) {
		this.width *= factor;
		this.height *= factor;
	}

	/**
	 * @Override
	 * 
	 * Note: Returnierter String repraesentiert ein 2D-Bild
	 * 
	 * Nachbedingung: Besteht aus druckbaren Zeichen
	 */
	public String toString() {

		int scaledWidth = (int) Math.ceil(this.width);
		int scaledHeight = (int) Math.ceil(this.height);
		StringBuilder result = new StringBuilder();

		// Hoehe durchiterieren
		for (int i = 0; i < scaledHeight; i++) {
			// Breite durchiterieren
			for (int j = 0; j < scaledWidth; j++) {
				result.append(this.zeichen);
			}

			if (i < (scaledHeight - 1)) {
				result.append("\n");
			}

		}

		return result.toString();

	}

}
