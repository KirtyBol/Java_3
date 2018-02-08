public class Pilot
{
	private boolean crashed = false;

	public void calculate() throws PilotException
	{
		if(Math.random() < 0.005)
		{
			throw new PilotException();	
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