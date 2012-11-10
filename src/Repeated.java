/**
 * 
 * @author Koegler Alexander
 *
 * @param <P>
 */
public class Repeated<P> extends Grid<P> {

	private P[][] grid;
	private double scaleVal = 1;
	
	@SuppressWarnings("unchecked")
	public Repeated(P[][] grid) {
		super(grid);
		this.grid = grid;
	}

	@Override
	public void scale(double factor) {
		// TODO Auto-generated method stub
		scaleVal = factor;
		
	}
	
	public String toString()
	{
		String s1 = super.toString();
		if(scaleVal < 1)
		{
			return new String(s1.substring(0,1));
		}
		
		if(scaleVal == 1)
		{
			return s1;
		}
		StringBuilder s4 = new StringBuilder();
		String[] s2 = s1.split("\n");
		
		for(int i = 0; i < s2.length; i++)
		{
			StringBuilder s3 = new StringBuilder(s2[i]);
			int k = s2[i].length();
			for(int j = 0; s3.length() < (int) (k * scaleVal);j++)
			{
				s3.append(s2[i].charAt(j % k));
			}			
			s2[i] = s3.toString();
		}
		
		for(int i = 0; i < (int)(s2.length * scaleVal); i++)
		{
			s4.append(s2[i % s2.length]);
			s4.append('\n');
		}
		return s4.substring(0, s4.length()-1);
	}
}
