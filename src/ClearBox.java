/**
 * 
 * Obertyp: Box
 * 
 * @author Christian Kletzander
 * 
 */
public class ClearBox extends Box {

	private double ratio;

	/**
	 * Die beiden zu verwendenden Zeichen (area,bound) werden im Konstruktor gesetzt
	 * und bleiben danach unveraendert.
	 * => Einschränkung: Bei der ClearBox ist das Zeichen area immer ' ' und bound immer *
	 * 
	 * @param width
	 *            Die Breite der Box
	 * @param height
	 *            Die Hoehe der Box
	 */
	public ClearBox(double width, double height) {
		super(width, height, ' ', '*');
		this.ratio = width / height;
	}

	public double getRatio() {
		return this.ratio;
	}

}
