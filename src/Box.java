/**
 * 
 * @author Christian Kletzander
 * 
 */
public class Box implements Pict {

	private double width;
	private double height;
	private char area;
	private char bound;

	/**
	 * Vorbedingung: "bound" darf kein Leerzeichen sein
	 * 
	 * @param width
	 *            Die Breite der Box
	 * @param height
	 *            Die Hoehe der Box
	 * @param area
	 *            Das Zeichen mit dem der Inhalt der Box befüllt werden soll
	 * @param bound
	 *            Das Zeichen mit dem der Rand der Box gezeichnet werden soll
	 */
	public Box(double width, double height, char area, char bound) {
		this.width = width;
		this.height = height;
		this.area = area;
		this.bound = bound;
	}

	@Override
	public void scale(double factor) {
		this.width *= factor;
		this.height *= factor;
	}

	public String toString() {

		int scaledWidth = (int) Math.ceil(this.width);
		int scaledHeight = (int) Math.ceil(this.height);
		String result = "";

		// Nur Raender zeichnen
		if (scaledWidth < 2 || scaledHeight < 2) {

			for (int i = 0; i < 4; i++) {

				if (i == 2) {
					result += "\n";
				}

				result += this.bound;
			}

			return result;

		}

		// Höhe durchiterieren
		for (int i = 0; i < scaledHeight; i++) {
			// Breite durchiterieren
			for (int j = 0; j < scaledWidth; j++) {
				// Rand zeichnen
				if ((i == 0) || (i == (scaledHeight - 1)) || (j == 0)
						|| (j == (scaledWidth - 1))) {
					result += this.bound;
				} else {
					result += this.area;
				}
			}

			if (i < (scaledHeight - 1)) {
				result += "\n";
			}

		}

		return result;

	}

}
