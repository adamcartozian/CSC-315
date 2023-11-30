package RTTI;



public class Base {
	private double x, y;
	
	public Base () {
	  this.x = 0.0;
	  this.y = 0.0;
	}

	public Base (double x, double y)
	{
	  this.x = x;
	  this.y = y;
	}
	
	public double getX()
	{
	  return x;
	}

	public void setX(double x)
	{
	  this.x = x;
	}

	public double getY()
	{
	  return y;
	}

	public void setY(double y)
	{
	  this.y = y;
	}

	public void override ()
	{
	}

}







