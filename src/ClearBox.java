/**
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
