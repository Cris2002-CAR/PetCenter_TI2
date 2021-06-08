package model;

import java.util.ArrayList;

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

	/////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////EXTENDS TI3 attributes


   	/**
   	ArrayList with hospitalized animals 
   	*/
	private ArrayList <Pet> listHpets;

	/**
   	Counter for the number of cats in the nursery 
   	*/
	public double numCats;
	
	/**
   	Counter for the number of dogs in the nursery 
   	*/
	public double numDogs;
	
	/**
   	Counter for the number of reptils in the nursery 
   	*/
	public double numReptils;

	/**
   	Counter for the number of rabbits in the nursery 
   	*/
	public double numRabbits;

	/**
   	Counter for the number of birds in the nursery 
   	*/
	public double numBirds;

	/**
	Counter for the number of healthy pets in the day care center 
	*/ 
	public double healthyPets;

	/**
   	Counter for the number of sick pets in the day care center 
   	*/
	public double sickPets;

	/**
   	counter for all pets 
   	*/
	public double totalPets;


	////////////////////Constants for limits

	////////////////////////////Cat limits
	/**
   	Constant with minimum row limit in the cat area
   	*/
	private final int MIN_CATROW = 0;

	/**
   	Constant with the maximum limit of rows in the cat area 
   	*/
	private final int MAX_CATROW = 2;

	/**
   	Constant with the minimum column limit in the cat area
   	*/
	private final int MIN_CATCOL = 0;

	/**
   	Constant with the maximun column limit in the cat area 
   	*/
	private final int MAX_CATCOL = 2;

	///////////////////////////Dogs limits
	/**
   	Constant with minimum row limit in the dog area
   	*/
	private final int MIN_DOGROW = 3;

	/**
   	Constant with the maximum limit of rows in the dog area 
   	*/
	private final int MAX_DOGROW = 5;

	/**
   	Constant with the minimum column limit in the dog area 
   	*/
	private final int MIN_DOGCOL = 0;

	/**
   	Constant with the maximun column limit in the dog area 
   	*/
	private final int MAX_DOGCOL = 2;

	////////////////////////////////reptil limits
	/**
   	Constant with minimum row limit in the reptil area 
   	*/
	private final int MIN_REPTILROW = 0;

	/**
   	Constant with the maximum limit of rows in the reptil area 
   	*/
	private final int MAX_REPTILROW = 1;

	/**
   	Constant with the minimum column limit in the reptil area 
   	*/
	private final int MIN_REPTILCOL = 3;

	/**
   	Constant with the maximun column limit in the reptil area 
   	*/
	private final int MAX_REPTILCOL = 4;

    //////////////////////////Rabbit limits
	/**
   	Constant with minimum row limit in the rabbit area 
   	*/
	private final int MIN_RABBITROW = 2;

	/**
   	Constant with the maximum limit of rows in the rabbit area
   	*/
	private final int MAX_RABBITROW = 3;

	/**
   	Constant with the minimum column limit in the rabbit area
   	*/
	private final int MIN_RABBITCOL = 3;

	/**
   	Constant with the maximun column limit in the rabbit area
   	*/
	private final int MAX_RABBITCOL = 4;

	///////////////////////////Bird limits
	/**
   	Constant with minimum row limit in the bird area 
   	*/
	private final int MIN_BIRDROW = 4;

	/**
   	Constant with the maximum limit of rows in the bird area
   	*/
	private final int MAX_BIRDROW = 5;

	/**
   	Constant with the minimum column limit in the bird area 
   	*/
	private final int MIN_BIRDCOL = 3;

	/**
   	Constant with the maximum column limit in the bird area 
   	*/
	private final int MAX_BIRDCOL = 4;

	////////////////////////// MATRIX

	/**
   	Habitat matrix for each pet 
   	*/
	private PetHabitats[][] habitats;

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
		habitats = new PetHabitats[6][5];
		setUpHabitats();
		listHpets = new ArrayList<Pet>();
		hopitalizationPet();

		numCats = 0;
		numDogs = 0;
	    numReptils = 0;
	    numRabbits = 0;
		numBirds = 0;

		healthyPets = 0;
		sickPets = 0;

		totalPets = 0;

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

				System.out.println(veterinaries[i].getName()+" veterinarian whith unique number "+veterinaries[i].getUniqueNumber()+ " was deleted");
				veterinaries[i] = null;
				find = true;
				numVeterinaries--;
			  	}
			  	else{

			  		System.out.println("The veterinarian could not be eliminated because there are registered pets or their unique number was entered incorrectly");
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
					System.out.println("The pet "+pets[i].getName()+" was deleted");
					pets[i].setStatus(Status.INNATENDED_DEPARTURE);
					pets[i].setPriority(Priority.CERO);
					find = true;
				}
				else{

					System.out.println("This pet cannot be eliminated because it is already in consultation or was attended by a veterinarian");
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
							System.out.println(pet.getName()+" pet has started consultation");
						}
						else{

							System.out.println("There is no pet to attend");
							find = true;
						}

					}
					else{

						System.out.println("The vet is not available");
						find = true;
					}

				}
			}	
		}
		if(!find){
			System.out.println("The vet with id: "+ id +" does not exist");
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
								pet.setPriority(Priority.CERO);
								veterinaries[i].setAvailable(true);
								System.out.println(pet.getName()+" pet has successfully completed the consultation");
								find = true;

							}
							else{

								System.out.println("The pet's name does not match the one seen by the vet");
							}
						}
						else{
							System.out.println("The vet is not treating any pets");
						}
					}
				}	
			}
		}
		if(!find){
			System.out.print("The id entered does not exist");
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

	///////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////EXTENS TI3 Methods

	/**
	 * This method takes care of sending a hospitalized pet to the day care center.
	 * pre:The habitat matrix is initialized, all counter variables are initialized.
	 * pos:In case there is space, the pet will stay in the first habitat that has a null pet.
	 * @return; returns a message indicating whether or not the pet entered the day care center
	*/ 
	public String hopitalizationPet(){

		String out = "";

		boolean find = false;
		boolean find2 = false;

		for(int i = 0; i<pets.length && !find; i++){
			if(pets[i] != null){
				if(pets[i].getStatus().equals(Status.HOSPITALIZATION)){
					listHpets.add(pets[i]);
					find = true;

				}
			}
		}
		if(find){
			for(int a = 0; a<listHpets.size() && !find2; a++){

				if(listHpets.get(a).getSpecie().equalsIgnoreCase("gato") || listHpets.get(a).getSpecie().equalsIgnoreCase("cat")){
					for(int i = MIN_CATROW; i<= MAX_CATROW && !find2; i++){
						for(int j = MIN_CATCOL; j <= MAX_CATCOL && !find2; j++){
							if(habitats[i][j].getPet() == null){
								habitats[i][j].setPet(listHpets.get(a));
								habitats[i][j].setHabitatStatus(HabitatStatus.E);
								out = "The cat "+listHpets.get(a).getName()+" was add in guacal "+habitats[i][j].getHabitatidentifier();
								numCats++;
								sickPets++;
								totalPets++;
								find2 = true;
							}
						}
					}
				}
				else if(listHpets.get(a).getSpecie().equalsIgnoreCase("perro") || listHpets.get(a).getSpecie().equalsIgnoreCase("dog")){
					for(int i = MIN_DOGROW; i<= MAX_DOGROW && !find2; i++){
						for(int j = MIN_DOGCOL; j <= MAX_DOGCOL && !find2; j++){
							if(habitats[i][j].getPet() == null){
								habitats[i][j].setPet(listHpets.get(a));
								habitats[i][j].setHabitatStatus(HabitatStatus.E);
								out = "The dog "+listHpets.get(a).getName()+" was add in house "+habitats[i][j].getHabitatidentifier();
								numDogs++;
								sickPets++;
								totalPets++;
								find2 = true;
							}
						}
					}
				}
				else if(listHpets.get(a).getSpecie().equalsIgnoreCase("reptil")){
					for(int i = MIN_REPTILROW; i<= MAX_REPTILROW && !find2; i++){
						for(int j = MIN_REPTILCOL; j <= MAX_REPTILCOL && !find2; j++){
							if(habitats[i][j].getPet() == null){
								habitats[i][j].setPet(listHpets.get(a));
								habitats[i][j].setHabitatStatus(HabitatStatus.E);
								out = "The reptil "+listHpets.get(a).getName()+" was add in aquarium "+habitats[i][j].getHabitatidentifier();
								numReptils++;
								sickPets++;
								totalPets++;
								find2 = true;
							}
						}
					}
				}
				else if(listHpets.get(a).getSpecie().equalsIgnoreCase("conejo") || listHpets.get(a).getSpecie().equalsIgnoreCase("rabbit")){
					for(int i = MIN_RABBITROW; i<= MAX_RABBITROW && !find2; i++){
						for(int j = MIN_RABBITCOL; j <= MAX_RABBITCOL && !find2; j++){
							if(habitats[i][j].getPet() == null){
								habitats[i][j].setPet(listHpets.get(a));
								habitats[i][j].setHabitatStatus(HabitatStatus.E);
								out = "The rabbit "+listHpets.get(a).getName()+" was add in house "+habitats[i][j].getHabitatidentifier();
								numRabbits++;
								sickPets++;
								totalPets++;
								find2 = true;
							}
						}
					}
				}
				else if(listHpets.get(a).getSpecie().equalsIgnoreCase("bird") || listHpets.get(a).getSpecie().equalsIgnoreCase("ave")){
					for(int i = MIN_BIRDROW; i<= MAX_BIRDROW && !find2; i++){
						for(int j = MIN_BIRDCOL; j <= MAX_BIRDCOL && !find2; j++){
							if(habitats[i][j].getPet() == null){
								habitats[i][j].setPet(listHpets.get(a));
								habitats[i][j].setHabitatStatus(HabitatStatus.E);
								out = "The bird "+listHpets.get(a).getName()+" was add in cage "+habitats[i][j].getHabitatidentifier();
								numBirds++;
								sickPets++;
								totalPets++;
								find2 = true;
							}
						}
					}
				}
			}
		}

		if(!find){
			out ="There ara not hospitalization pets";
		}
		else if(!find2){
			out = "The area is full";
		}

		return out;
	}

	/**
	 *This method is responsible for entering a pet into the day care. 
	 * pre: The habitats and counter variables are initialized.
	 * pos: The pet remains in the first habitat with pet null and that is in the limits according to its species.
	 * @param specie A string with the pet's species
	 * @param name A string with the pet's name
	 * @param age A string with the pet's age
	 * @param race A string with the pet's race
	 * @param nameOwn A string with the pet owner's name on it
	 * @param idOwn A string with the pet owner's id on it
	 * @param phoneOwn A string with the pet owner's phone on it
	 * @param addreessOwn A String with the pet owner's name on it
	 * @return A string indicating whether or not the pet was able to enter the nursery.
	*/
	public String addPetToNursery(String specie, String name, String age, String race, String nameOwn, String idOwn, 
		String phoneOwn, String addressOwn){

		String out = "";

		boolean find = false;

		Owner own = new Owner(nameOwn, idOwn, phoneOwn, addressOwn);

		Pet pet = new Pet(specie, name, age, race, own);

		if(pet.getSpecie().equalsIgnoreCase("gato") || pet.getSpecie().equalsIgnoreCase("cat")){
			for(int i = MIN_CATROW; i<= MAX_CATROW && !find; i++){
				for(int j = MIN_CATCOL; j <= MAX_CATCOL && !find; j++){
					if(habitats[i][j].getPet() == null){
						habitats[i][j].setPet(pet);
						habitats[i][j].setHabitatStatus(HabitatStatus.S);
						out = "The cat was add in guacal "+habitats[i][j].getHabitatidentifier();
						numCats++;
						healthyPets++;
						totalPets++;
						find = true;
					}
				}
			}
		}
		else if(pet.getSpecie().equalsIgnoreCase("perro") || pet.getSpecie().equalsIgnoreCase("dog")){
			for(int i = MIN_DOGROW; i<= MAX_DOGROW && !find; i++){
				for(int j = MIN_DOGCOL; j <= MAX_DOGCOL && !find; j++){
					if(habitats[i][j].getPet() == null){
						habitats[i][j].setPet(pet);
						habitats[i][j].setHabitatStatus(HabitatStatus.S);
						out = "The dog was add in house "+habitats[i][j].getHabitatidentifier();
						numDogs++;
						healthyPets++;
						totalPets++;
						find = true;
					}
				}
			}
		}
		else if(pet.getSpecie().equalsIgnoreCase("reptil")){
			for(int i = MIN_REPTILROW; i<= MAX_REPTILROW && !find; i++){
				for(int j = MIN_REPTILCOL; j <= MAX_REPTILCOL && !find; j++){
					if(habitats[i][j].getPet() == null){
						habitats[i][j].setPet(pet);
						habitats[i][j].setHabitatStatus(HabitatStatus.S);
						out = "The reptil was add in aquarium "+habitats[i][j].getHabitatidentifier();
						find = true;
						numReptils++;
						healthyPets++;
						totalPets++;
					}
				}
			}
		}
		else if(pet.getSpecie().equalsIgnoreCase("conejo") ||  pet.getSpecie().equalsIgnoreCase("rabbit")){
			for(int i = MIN_RABBITROW; i<= MAX_RABBITROW && !find; i++){
				for(int j = MIN_RABBITCOL; j <= MAX_RABBITCOL && !find; j++){
					if(habitats[i][j].getPet() == null){
						habitats[i][j].setPet(pet);
						habitats[i][j].setHabitatStatus(HabitatStatus.S);
						out = "The rabbit was add in house "+habitats[i][j].getHabitatidentifier();
						numRabbits++;
						healthyPets++;
						totalPets++;
						find = true;
					}
				}
			}
		}
		else if(pet.getSpecie().equalsIgnoreCase("bird") || pet.getSpecie().equalsIgnoreCase("ave")){
			for(int i = MIN_BIRDROW; i<= MAX_BIRDROW && !find; i++){
				for(int j = MIN_BIRDCOL; j <= MAX_BIRDCOL && !find; j++){
					if(habitats[i][j].getPet() == null){
						habitats[i][j].setPet(pet);
						habitats[i][j].setHabitatStatus(HabitatStatus.S);
						out = "The bird was add in cage "+habitats[i][j].getHabitatidentifier();
						numBirds++;
						healthyPets++;
						totalPets++;
						find = true;
					}
				}
			}
		}

		if(!find){
			out = "The pet was not added";
		}
		return out;
	}

	/**
	 *This method initializes all habitats with default values. 
	*/
	public void setUpHabitats(){
		setUpCat();
		setUpDog();
		setUpReptil();
		setUpRabbit();
		setUpBird();
		
	}
	
	/**
	 *This method initializes the cat zone according to its limits.
	 * Global constants are used to initialize the zone 
	*/
	public void setUpCat(){

		int catCount = 1;

		for(int i = MIN_CATROW; i<= MAX_CATROW; i++){
			for(int j = MIN_CATCOL; j <= MAX_CATCOL; j++){
				habitats[i][j] = new CatArea("G"+catCount, "15", "15", "15", "20 KL");
				catCount++;
				
			}
		}
	}

	/**
	 *This method initializes the dog zone according to its limits.
	 * Global constants are used to initialize the zone 
	*/
	public void setUpDog(){

		int dogCount = 1;

		for(int i = MIN_DOGROW; i<= MAX_DOGROW; i++){
			for(int j = MIN_DOGCOL; j <= MAX_DOGCOL; j++){
				habitats[i][j] = new DogArea("D"+dogCount, "25", "25", 5);
				dogCount++;
			}
		}
	}

	/**
	 *This method initializes the reptil zone according to its limits.
	 * Global constants are used to initialize the zone 
	*/
	public void setUpReptil(){

		int reptilCount = 1;

		for(int i = MIN_REPTILROW; i<= MAX_REPTILROW; i++){
			for(int j = MIN_REPTILCOL; j <= MAX_REPTILCOL; j++){		
				habitats[i][j] = new ReptileArea("R"+reptilCount, "10", "10", "Metal y vidrio", AquariumType.EARTH);
				reptilCount++;
			}
		}
	}

	/**
	 *This method initializes the rabbit zone according to its limits.
	 * Global constants are used to initialize the zone 
	*/
	public void setUpRabbit(){

		int rabbitCount = 1;

		for(int i = MIN_RABBITROW; i<= MAX_RABBITROW; i++){
			for(int j = MIN_RABBITCOL; j <= MAX_RABBITCOL; j++){
				habitats[i][j] = new RabbitArea("C"+rabbitCount, "12", "12","Savila", "10");
				rabbitCount++;		
			}
		}
	}

	/**
	 *This method initializes the bird zone according to its limits.
	 * Global constants are used to initialize the zone 
	*/
	public void setUpBird(){

		int birdCount = 1;

		for(int i = MIN_BIRDROW; i<= MAX_BIRDROW; i++){
			for(int j = MIN_BIRDCOL; j <= MAX_BIRDCOL; j++){		
				habitats[i][j] = new BirdArea("B"+birdCount, "18", "18", "16", "5", CageType.GROUND_CAGE); 
				birdCount++;
			}
		}
	}


	/**
	 *This method shows whether a pet is in the nursery and in which habitat it is located. 
	 * @return Displays a message informing whether or not the pet is in day care. 
	*/
	public String findPetInNursery(String name){

		String out = "";

		ArrayList<PetHabitats> habitat = findHabitats(name);

		for(int i = 0; i<habitat.size(); i++){
			out +="La mastota esta en: "+habitat.get(i).showInfo()+"\n"; 

		}

		if(habitat.size() == 0){

			out = "The pet is not in the nursery";
		}

		return out;
			
	}

	/**
	 * This method stores in an arraylist the habitat of the pets that have the name entered by the user.
	 * @return the habitats in which the pets are kept.
	*/
	public ArrayList<PetHabitats> findHabitats(String name){

		ArrayList<PetHabitats> habitat = new ArrayList<PetHabitats>();

		for(int i = 0; i<habitats.length; i++){
			for(int j = 0; j<habitats[0].length; j++){
				if(habitats[i][j].getPet() != null){
					if(habitats[i][j].getPet().getName().equals(name)){
						habitat.add(habitats[i][j]);
					}
				}
			}
		}
		return habitat;				
	}

	/**
	 *This method paints the entire nursery 
	 * pre: The habitats matrix is initialized 
	*/
	public void printMap(){

		String out = "";

		for(int i = 0; i<habitats.length; i++){
			for(int j = 0; j<habitats[0].length; j++){
				if(habitats[i][j] != null){
					System.out.print(habitats[i][j].showInfo()+"-");
				}	
			}
			System.out.println();
		}
	}

	/**
	 * This method is responsible for displaying the information of a habitat.
	 * pre: the habitats matrix is initialized
	 * @return habitat information
	*/ 
	public String showHabitatInformation(String habitatIdentifier,int count){

		String out = "";

		boolean find = false;

		for(int i = 0; i<habitats.length && !find; i++){
			for(int j = 0; j<habitats[0].length  && !find; j++){
				if(habitats[i][j].getHabitatidentifier().equals(habitatIdentifier+count)){
					out = "\n Habitat Information: "+habitats[i][j].showHabitat();
					find = true;
				}
			}
		}

		return out;
	}

	/**
	 * This method calculates and displays nursery statistics.
	 * pre: The counter variables are initialized
	 * @return all nursery statistics
	*/
	public String showNurseryStatistics(){

		String out = "";

		double percentageCat = (numCats * 100)/9;
		double percentageDog = (numDogs * 100)/9;
		double percentageReptil = (numReptils * 100)/4;
		double percentageRabbits = (numRabbits * 100)/4;
		double percentageBirds = (numBirds * 100)/4;

		double percentageTotal = (totalPets * 100)/30;

		double percentageHealthy = (healthyPets * 100)/30;

		double percentageSick = (sickPets * 100)/30;

		out = "The percentage of occupancy in the cat area is: "+percentageCat;

		out += "\nThe percentage of occupancy in the dog area is: "+percentageDog;

		out += "\nThe percentage of occupancy in the reptil area is: "+percentageReptil;

		out += "\nThe percentage of occupancy in the rabbit area is: "+percentageRabbits;

		out += "\nThe percentage of occupancy in the bird area is: "+percentageBirds;

		out += "\nThe percentage of healthy pets is: "+percentageHealthy;

		out += "\nThe percentage of sick pets is: "+percentageSick;

		out += "\nThe total percentage of pets in the nursery is: "+percentageTotal;

		return out;
	}

		

}


	

