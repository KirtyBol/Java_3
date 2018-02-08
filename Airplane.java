public class Airplane
{

	private Engine[] engines = new Engine[]{new Engine(), new Engine(), new Engine(), new Engine()};
	private Flap[] flaps = new Flap[]{new Flap(), new Flap()};
	private Pilot[] pilots = new Pilot[]{new Pilot(), new Pilot(), new Pilot()};


	public void flight() throws CrashException
	{

		for(Flap flap : flaps) 
		{
			try{
				flap.calculate();
			} catch(FlapException x){
				flap.setCrashed(true);
			}
		}

		for(Engine engine : engines) 
		{
			try{
				engine.calculate();
			} catch(EngineException x){
				engine.setCrashed(true);
			}
		}

		for(Pilot pilot : pilots) 
		{
			try{
				pilot.calculate();
			} catch(PilotException x){
				pilot.setCrashed(true);
			}
		}

		if(flaps[0].isCrashed() && flaps[1].isCrashed()){
			throw new CrashException();
		}

		if((engines[0].isCrashed() && engines[3].isCrashed()) && (engines[2].isCrashed() || engines[1].isCrashed())){
			throw new CrashException();
		}

		if(pilots[0].isCrashed() && pilots[1].isCrashed() && pilots[2].isCrashed()){
			throw new CrashException();
		}
	}

	public Flap[] getFlaps(){
		return flaps;
	}

	public Pilot[] getPilots(){
		return pilots;
	}

	public Engine[] getEngines(){
		return engines;
	}



	/*Private int[] engine = [engine1, engine2, engine3, engine4];
		4 maal Engine
		 motor 1 en 4 zijn de buitenste, motor 2 en 3 zijn de binnenste
		 bij 1 of 2 kapotte motoren kan ie nog vligen, zijnner 3 kapot dan moet de 4e een binnenste zijn
	
	private int[] flapList = [flap1, flap2];
		2 maal Flap
		 stort neer bij falen van beide 
	
	private int[] pilot = [pilot1, pilot2, pilot3];
		3 maal Pilot
		 wanneer alle piloten uitvallen, neerstorten


	Per onderdeel kijken of die blijft functioneren
	Alle exceptions afhandelen
	 Bijhouden van welke onderdelen er uitvallen en welke niet
	 Generen van CrashException
	 Exception doorzetten naar Recorder
	*/

}