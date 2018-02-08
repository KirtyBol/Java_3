public class Flap
{
	private boolean crashed = false;

	public void calculate() throws FlapException
	{
		if(Math.random() < 0.005)
		{
			throw new FlapException();	
		}
	}

	public boolean isCrashed() 
	{
		return crashed;
	}

	public void setCrashed(boolean crashed) 
	{
		this.crashed = crashed;
	}
}