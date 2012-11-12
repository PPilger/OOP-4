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
	 *            Das Zeichen mit dem der Inhalt der Box befuellt werden soll
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
		StringBuilder result = new StringBuilder();

		// Kopfzeile
		for (int i = 0; i < scaledWidth; i++) {
			result.append(this.bound);
		}

		result.append("\n");

		// Bei 2 beginnen, weil Kopf/Fu§zeile nicht behandelt wird
		for (int i = 2; i < scaledHeight; i++) {
			// Linker Rand
			result.append(this.bound);
			for (int j = 2; j < scaledWidth; j++) {
				result.append(this.area);
			}
			// Rechter Rand
			if (scaledWidth > 1) {
				result.append(this.bound);
			}

			result.append("\n");
		}

		// Fu§zeile
		if (scaledHeight > 1) {
			for (int i = 0; i < scaledWidth; i++) {
				result.append(this.bound);
			}
		}

		return result.toString();

	}

}
