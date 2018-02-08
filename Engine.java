public class Engine
{
	private boolean crashed = false;

	public void calculate() throws EngineException
	{
		if(Math.random() < 0.001)
		{
			throw new EngineException();	
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