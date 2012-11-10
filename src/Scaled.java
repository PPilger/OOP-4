/**
 * 
 * @author VHD
 *
 * @param <P>
 */
public class Scaled<P extends Pict> extends Grid<P> {

	private P[][] grid;
	
	@SuppressWarnings("unchecked")
	public Scaled(P[][] grid) {
		super(grid);
		this.grid = grid;		
	}

	@Override
	public void scale(double factor) {
		// TODO Auto-generated method stub
		for(P[] n1 : this.grid)
		{
			for (P n2: n1)
			{
				n2.scale(factor);
			}
		}
	}
}
