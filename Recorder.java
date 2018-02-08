public class Recorder
{
	int crashCounter = 0;
	int failFlapCounter = 0;
	int failEngineCounter = 0;
	int failPilotCounter = 0;

	//Airplane[] airplane = new Airplane[1000000];
	// 1 miljoen keer een airplane aanmaken

	public void simulate()
	{
		for(int i = 0; i < 1000000; i++){
			Airplane airplane = new Airplane();

			try{
				airplane.flight();
			}
			catch(CrashException e){
				System.out.println("Vliegtuig "+(i+1)+" is neergestort.");
				crashCounter++;
			}

			if(airplane.getFlaps()[0].isCrashed() && airplane.getFlaps()[1].isCrashed()){
					failFlapCounter += 2;
					System.out.println("Flaps zijn kapot gegaan.");
			}

			if(airplane.getEngines()[0].isCrashed() && airplane.getEngines()[3].isCrashed() && (airplane.getEngines()[1].isCrashed() || airplane.getEngines()[2].isCrashed())){
					failEngineCounter += 2;
					System.out.println("Engines died");
					if(airplane.getEngines()[1].isCrashed()){
						failEngineCounter++;
					}
					if(airplane.getEngines()[2].isCrashed()){
						failEngineCounter++;
					}
			}
			else {
					if(airplane.getEngines()[0].isCrashed()){
						failEngineCounter++;
					}
					if(airplane.getEngines()[1].isCrashed()){
						failEngineCounter++;
					}			
					if(airplane.getEngines()[2].isCrashed()){
						failEngineCounter++;
					}
					if(airplane.getEngines()[3].isCrashed()){
						failEngineCounter++;
					}
			}

			if(airplane.getPilots()[0].isCrashed() && airplane.getPilots()[1].isCrashed() && airplane.getPilots()[2].isCrashed()){
					failPilotCounter += 3;
					System.out.println("pilots died");
			}

		}	
	
		System.out.println(crashCounter+" vliegtuigen zijn zojuist gecrasht.");
		System.out.println(failFlapCounter+" flaps zijn kapot gegaan.");
		System.out.println(failEngineCounter+" engines zijn kapot gegaan.");
		System.out.println(failPilotCounter+" piloten waren niet instaat om te vliegen.");
	}


}

//methode die 1 miljoein keer een zairplane aanmaakt
		//van het Airplane object de methode flight() aanroepen
		//flight() kan CrashException() aanroepen
		//bij houden wat er uivalt en dit uitprinten?



		//wanneer hij neerstort: welke vlucht en welke onderdelen
		// overzicht van hoeveel flaps, piloten, motoren er in totaal uitvielen van de 1 miljoen

