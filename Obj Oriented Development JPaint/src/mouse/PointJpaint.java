package mouse;

public class PointJpaint {

	private final double x;
	private final double y;
	
	public PointJpaint(double x, double y) 
		{
	      	this.x = x;
	        this.y = y;
	    }
	  
	  public double getX() 
	  		{ 
		  		return x; 
		  	}
	  public double getY() 
	  		{ 
		  		return y; 
		  	}
	

	 public String toString()
	 		{
		 		return (x + "," + y);
	 		}

}
