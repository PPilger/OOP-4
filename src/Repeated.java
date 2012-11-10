
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
		String ret ="";
		StringBuilder s4 = new StringBuilder();
		int max1 = 0, max2 = 0;
		int c1 = 0, c2 = 0;
		if(scaleVal < 1)
		{			
			for(P[] n1 : grid)
			{
				for(P n2: n1)
				{
					s4.append(n2.toString().charAt(0));
				}
				s4.append('n');
			}
		}
		else
		{
		for(P[] n1 : grid)
		{
			for(P n2: n1)
			{
				String[] s1 = n2.toString().split("\n");
				if(s1.length*scaleVal > max1){
					max1 = (int) ((int)s1.length*scaleVal);}
				if(s1[0].length()*scaleVal > max2){
					max2 = (int) ((int)s1[0].length()*scaleVal);
				}
			}
		}
		
		for(P[] n1 : grid)
		{
			c1++;
			for(P n2 : n1)
			{
				c2++;
				String[] s1 = n2.toString().split("\n");
				for(String s2 : s1)
				{
					StringBuilder s3 = new StringBuilder(s2);
					while(s2.length() < max1)
					{
						s3.append(' ');
					}
					s2 = s3.toString();
				}
				
				int i = 0;
				while(i < max2)
				{
					s4.append(s1[(i%(int)(s1.length*scaleVal))]);
					s4.append('\t');
					i++;
				}
			}
			s4.append("\n\t");
		}
		ret = s4.toString();}
		String[] s5 = ret.split("\t");
		ret = "";
		s4 = new StringBuilder();
		for(int i = 0; i < (c2-max2); i++)
		{
			for(int j = 0; j < c2 && i+j < s5.length; j+=max2)
			{
				s4.append(s5[i+j]);
			}
		}
		ret = s4.toString();
		return ret;
	}
}
