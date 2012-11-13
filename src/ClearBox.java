/**
 * 
 * Obertyp: Box
 * Beim Untertyp "ClearBox" handelt es sich um eine Spezialisierung, denn die Moeglichkeit
 * ein Zeichen in der Box selbst zu waehlen ist nicht mehr gegeben. Man bekommt
 * nur noch die Moeglichkeit die Breite und Hoehe zu waehlen.
 * 
 * @author Christian Kletzander
 * 
 */
public class ClearBox extends Box {

	private double ratio;

	public ClearBox(int width, int height) {
		super(width, height, ' ', '*');
		this.ratio = width / height;
	}

	public double getRatio() {
		return this.ratio;
	}

}
