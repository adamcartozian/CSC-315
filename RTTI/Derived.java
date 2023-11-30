package RTTI;

public class Derived extends Base {

	private double u, v;

	public Derived () 
	{
		super();
		this.u = 10.0;
		this.v = 10.0;
	}


	public Derived (double u, double v) 
	{
		super (u+10.0, v+10.0);
	  this.u = u;
	  this.v = v;
	}


	public double getU()
	{
	  return u;
	}

	public void setU(double u)
	{
	  this.u = u;
	}

	public double getV()
	{
	  return v;
	}

	public void setV(double v)
	{
	  this.v = v;
	}

	public void override ()
	{
	}




}
