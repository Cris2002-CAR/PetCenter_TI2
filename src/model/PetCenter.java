package model;

public class PetCenter{

	/**
	A constant limiting the number of veterinarians
	*/
	public final int MAX_VETERINARIES = 7;

	/**
	A constant limiting the number of pets
	*/
	public final int MAX_ATTENDED_PETS = 120;

	/**
	A global variable to count the number of veterinarians added.
	*/
	private int numVeterinaries;

	/**
	A global variable to count the number of pets added.
	*/
	private int numPets;

	/**
	An array of type Veterinary to add each veterinarian in a position.
	*/
	private Veterinary[] veterinaries;

	/**
	A Pet type arrangement to add each pet in one position.
	*/
	private Pet[] pets;

	///////////////////////Method Constructs

	/**
	* Metodo constructs of PetCenter class
	*In this method all global variables are initialized.
	*/
	public PetCenter(){

		veterinaries = new Veterinary[MAX_VETERINARIES];
		pets = new Pet[MAX_ATTENDED_PETS];
		numVeterinaries = 0;
		numPets = 0;

	}
	//////////////////Gets

	/**
	*A get method for obtaining and displaying a veterinarian
	*The global arrangement of veterinarians is used to obtain one in a position.
	*@return veterinaries type Veterinary, returns a data of type veterinarian
	*/
	public Veterinary[] getVeterinaries(){

		return veterinaries;
	}

	/**
	*A get method for obtaining and displaying a pet
	*The global arrangement of veterinarians is used to obtain one in a position.
	*@return pets type Pet, returns a data of type Pet
	*/
	public Pet[] getPets(){

		return pets;
	}

	////////////////////Sets

	/**
	*A method to change a Veterinary data type
	*Global array veterinaries is used to change an object of type Veterinary
	*@param Veterinaries type Veterinary
	*/
	public void setVeterinaries(Veterinary[] veterinaries){

		this.veterinaries = veterinaries;
	}

	/**
	*A method to change a Pet data type
	*Global array pets is used to change an object of type Veterinary
	*@param pets type Pet
	*/
	public void setPet(Pet[] pets){

		this.pets = pets;
	}

	////////////////////Methods

	/**
	*Method used to add a veterinarian 
	*There should be no more than seven veterinarians in the arrangement.
	*The veterinarian array gets an object of type veterinarian in one position
	*@param id type String
	*@param name type String
	*@param lastname type String
	*@param uniqueNumber type String
	*@return addVeterinary type boolean, returns true if the conditions for adding a veterinarian are met, otherwise it returns false.
	*/
	public boolean addVeterinary(String id, String name, String lastname, String uniqueNumber){

		boolean find = false;

		if(numVeterinaries < MAX_VETERINARIES && (!find)){

			Veterinary veterinary = new Veterinary(id, name, lastname, uniqueNumber);
			for(int i=0; i<veterinaries.length && !find; i++){
				if(veterinaries[i] == null){
					veterinaries[i] = veterinary;
					find = true;
				}
				
			}
			numVeterinaries++;

			return true;
		}
		else{
			return false;

		}

	}

	/**
	*This method eliminates a veterinarian from the array
	*To delete a veterinarian, the pets array must be null.
	*Removes an object of type Veterinary from the array.
	*@param uniqueNumbre type String, veterinaries[i].getUniqueNumber().equals(uniqueNumber) 
	*/
	public void deleteVeterinary(String uniqueNumber){

		boolean find = false;

		int registerPet=0;
		for(int j = 0; j<pets.length; j++){
			if(pets[j] != null){
				registerPet++;
			}
		}

		for(int i = 0; i<veterinaries.length && !find; i++){
			if(veterinaries[i] != null){
				if(veterinaries[i].getUniqueNumber().equals(uniqueNumber) && (registerPet==0)){

				System.out.println("El veterinario "+veterinaries[i].getName()+ " con numero unico "+veterinaries[i].getUniqueNumber()+ " fue eliminado");
				veterinaries[i] = null;
				find = true;
				numVeterinaries--;
			  	}
			  	else{

			  		System.out.println("No se pudo eliminar el veterinario porque hay mascotas registradas o se ingreso mal su numero unico");
			  	}
			}		
		}
	}

	/**
	*This method adds a pet to the pets arrangement.
	*There can be no more than 120 pets in the arrangement.
	*Adds an object of type Pet to the pet array
	*@param specie type String
	*@param name type String
	*@param age type String
	*@param race type String
	*@param symptoms type String
	*@param priority type String
	*@param status type String
	*@param nameOwn type String
	*@param idOwn type String
	*@param phoneOwn type String
	*@param addressOwn type String
	*@return addPet type boolean, if the conditions are fulfilled it returns true, otherwise it returns false
	*/
	public boolean addPet(String specie, String name, String age, String race, String symptoms, 
		Priority priority, Status status, String nameOwn, String idOwn, String phoneOwn, String addressOwn){

		Owner owner = new Owner(nameOwn, idOwn, phoneOwn, addressOwn);

		boolean find = false; 

		if((numPets < MAX_ATTENDED_PETS) && (!find)){

			Pet pet = new Pet(specie, name, age, race, symptoms, owner, priority, status);
			for(int i=0; i < pets.length  && !find ; i++){

				if(pets[i] == null){
					pets[i] = pet;
					find = true;
				}
			}
			numPets++;

			return true;
		}
		else{
			return false;
		}
	}

	/**
	*This method allows you to change the status of a pet.
	*Object of type Pet must have status WAITING
	*Change pet status to "INNATENDED_DEPARTURE".
	*@param name type String, pets[i].getName().equals(name)
	*@param nameOwn type String, pets[i].getOwner().getName().equals(nameOwn)
	*/
	public void removePet(String name, String nameOwn){

		boolean find = false;
		for(int i=0; i<pets.length && !find && (pets[i].getStatus() == Status.WAITING); i++){
			if(pets[i] != null){
				if(pets[i].getName().equals(name) && (pets[i].getOwner().getName().equals(nameOwn))){
					System.out.println("La mascota "+pets[i].getName()+" ha sido eliminada");
					pets[i].setStatus(Status.INNATENDED_DEPARTURE);
					pets[i].setPriority(Priority.CERO);
					find = true;
				}
				else{

					System.out.println("No se puede eliminar esta mascota porque ya esta en consulta o fue atendida por un veterinario");
				}	
			}
		}



	}

	/**
	*This method assigns a numerical value to a priority for comparison.
	*@param priority type Priority
	*@return priorityResult type int, obtains the pet's priority to assign a numerical value to it
	*/
	public int valuePriority(Priority priority){

		int priorityResult = 0;

		if(Priority.RED == priority){
			priorityResult = 5;
		}

		else if(Priority.ORANGE == priority){
			priorityResult = 4;
		}

		else if(Priority.YELLOW == priority){
			priorityResult = 3;
		}

		else if(Priority.GREEN == priority){
			priorityResult = 2;
		}

		else if(Priority.BLUE == priority){
			priorityResult = 1;
		}
		else if(Priority.CERO == priority){
			priorityResult = 0;
		}

		return priorityResult;
	}

	/**
	*This method is responsible for passing the pet with the highest priority to a veterinarian.
	*@return nextPet type Pet, returns the pet with the highest priority
	*/
	public Pet findNextPet(){

		Pet nexPet = null;

		int priority1=0;
		int priority2=0;

		if(pets[0] != null){

			nexPet = pets[0];
		}

		for(int i=1; i<pets.length; i++){
			if(pets[i] != null){
				if(pets[i].getStatus().equals(Status.WAITING)){
					priority1 = valuePriority(nexPet.getPriority());
					priority2 = valuePriority(pets[i].getPriority());
					if(priority2 > priority1){
						nexPet = pets[i];
					}
				}				
			}	
		}
		return nexPet;
	}

	/**
	*This method takes care of starting the consultation with a veterinarian.
	*To initiate a consultation, the pet must have the status "WAITING".
	*The object in pets type Pet will have a status change chosen by the user.
	*@param id type String, veterinaries[i].getId().equals(id) 
	*/
	public void startConsultation(String id){
		
		boolean find = false;

		for(int i=0; i<veterinaries.length && !find; i++){

			if(veterinaries[i] != null){

				if(veterinaries[i].getId().equals(id)){

					if(veterinaries[i].getAvailable()){
						Pet pet = findNextPet();
						if(pet.getStatus() == Status.WAITING){
							find = true;
							pet.setStatus(Status.IN_CONSULTATION);
							pet.setAttend(veterinaries[i]);
							veterinaries[i].setAvailable(false);
							System.out.println("La mascota "+pet.getName()+" ha iniciado consulta");
						}
						else{

							System.out.println("No hay mascota para atender");
							find = true;
						}

					}
					else{

						System.out.println("El veterinario no esta disponible");
						find = true;
					}

				}
			}	
		}
		if(!find){
			System.out.println("El veterinario con id: "+id+" no existe");
		}

	}

	/**
	*This method takes care of finalizing a veterinary consultation.
	*@param id type String, veterinaries[i].getId().equals(id)
	*@param namePet type String, pet.getName().equals(namePet)
	*@param status type Status
	*/
	public void endConsultation(String id, String namePet, Status status){

		boolean find = false;

		for(int i=0; i<veterinaries.length && !find; i++){
			if(veterinaries != null){
				if(veterinaries[i].getId().equals(id)){
					if(!veterinaries[i].getAvailable()){
						Pet pet = findPetByVeterinary(veterinaries[i]);
						if(pet != null){
							if(pet.getName().equals(namePet)){

								pet.setStatus(status);
								veterinaries[i].setAvailable(true);
								System.out.println("La mascota "+pet.getName()+" ha finalizado la consulta exitosamente");
								find = true;

							}
							else{

								System.out.println("El nombre de la mascota no coincide con el que atiende el veterinario");
							}
						}
						else{
							System.out.println("El veterinario no esta atendiendo ninguna mascota");
						}
					}
				}	
			}
		}
		if(!find){
			System.out.print("El id ingresado no existe");
		}
	}

	/**
	*The method takes care of finding the veterinarian who attended the pet.
	*@param veterinary type Veterinary, pets[i].getAttend().equals(veterinary) 
	*@return pet type Pet, returns a data of type pet 
	*/
	public Pet findPetByVeterinary(Veterinary veterinary){

		Pet pet = null;
		boolean find = false;

		for(int i=0; i<pets.length && !find; i++){
			if(pets[i] != null){
				if(pets[i].getAttend().equals(veterinary)){
					pet = pets[i];
					find = true;
				}
			}	
		}
		return pet;
	}

	/**
	*This method is responsible for showing pets that have not been cared for.
	*@return notAttend type int, returns an integer with the number of pets that have not been attended to
	*/
	public int notAttendedPets(){

		int notAttend = 0;

		for(int i=0; i<pets.length; i++){
			if(pets[i] != null){
				if(pets[i].getStatus() == Status.WAITING)
					notAttend++;
			}
		}

		return notAttend;
	}

	/**
	*This method verifies that there are no pets to be attended.
	*@return check type boolean, if check is false it will let the day end, otherwise it will not let it do so
	*/
	public boolean checkNotWaitingPets(){

		boolean check = false;

		for(int i=0; i<pets.length && !check; i++){
			if(pets[i] != null){
				if(pets[i].getStatus() == Status.WAITING){
					check = true;
				}
			}
		}
		return check;
	}

	/**
	*This method is in charge of obtaining the veterinarian with the most queries.
	*@return veterinaries[pos].getName() type String, get the name of the veterinarian with the most inquiries
	*/
	public String veterinaryMostAttendPets(){

		int attends[] = new int[numVeterinaries];

		for(int i=0; i<pets.length; i++){

			if(pets[i] != null){
				if(pets[i].getStatus() == Status.HOSPITALIZATION || pets[i].getStatus() == Status.AUTHORIZE_DEPARTURE ){
					for(int j=0; j<numVeterinaries; j++){

						if(pets[i].getAttend().equals(veterinaries[j])){
							attends[j]++;
						}

					}
					
				}
			}
		}

		int max = attends[0];
		int pos = 0;

		for(int k=1; k<attends.length; k++){

			if(attends[k]>max){
				max=attends[k];
				pos = k;
			}
		}

		return veterinaries[pos].getName();

	}

	/**
	*This method is in charge of counting each pet by priority.
	*@return pririties type int, returns an array with the number of pets per priority.
	*/
	public int[] attendsPetsForPriority(){

		int priorities[] = new int[5];

		for(int i=0; i<pets.length; i++){
			if(pets[i] != null){
				if(pets[i].getPriority() == Priority.RED){
					priorities[0] = priorities[0]+1;
				}
				else if(pets[i].getPriority() == Priority.ORANGE){
					priorities[1] = priorities[1]+1 ;
				}
				else if(pets[i].getPriority() == Priority.YELLOW){
					priorities[2] = priorities[2]+1;
				}
				else if(pets[i].getPriority() == Priority.GREEN){
					priorities[3] = priorities[3]+1;
				}
				else if(pets[i].getPriority() == Priority.BLUE){
					priorities[4] = priorities[4]+1;
				}
			}
		}
		return priorities;

	}

	/**
	*This method takes care of getting the percentage of pets with the status "INNATENDED_DEPARTURE".
	*@return percentage type double
	*/
	public double notAttendPercentage(){

		int notAttend = 0;

		for(int i=0; i<pets.length; i++){
			if(pets[i] != null){
				if(pets[i].getStatus().equals(Status.INNATENDED_DEPARTURE)){
					notAttend++;
				}
			}
		}

		double percentage = notAttend/numPets;
		return percentage;
	}

	/**
	*This method eliminates all pets at the end of the day.
	*the global pets array becomes null
	*/
	public void deleteAttendedPets(){

		pets = new Pet[MAX_ATTENDED_PETS];
	}

	
}
