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

	//////////////////////////EXTENDS TI3 attributes


	////////////////////Constants for limits
	private final int MIN_CATROW = 0;
	private final int MAX_CATROW = 2;
	private final int MIN_CATCOL = 0;
	private final int MAX_CATCOL = 2;

	private final int MIN_DOGROW = 3;
	private final int MAX_DOGROW = 5;
	private final int MIN_DOGCOL = 0;
	private final int MAX_DOGCOL = 2;

	private final int MIN_REPTILROW = 0;
	private final int MAX_REPTILROW = 1;
	private final int MIN_REPTILCOL = 3;
	private final int MAX_REPTILCOL = 4;

	private final int MIN_RABBITROW = 2;
	private final int MAX_RABBITROW = 3;
	private final int MIN_RABBITCOL = 3;
	private final int MAX_RABBITCOL = 4;

	private final int MIN_BIRDROW = 4;
	private final int MAX_BIRDROW = 5;
	private final int MIN_BIRDCOL = 3;
	private final int MAX_BIRDCOL = 4;

	////////////////////////// MATRIX

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

	////////////////EXTENS TI3 Methods

	

	public String addPetToNursery(String specie, String name, String age, String race, String nameOwn, String idOwn, 
		String phoneOwn, String addressOwn){

		String out = "";

		boolean find = false;

		Owner own = new Owner(nameOwn, idOwn, phoneOwn, addressOwn);

		Pet pet = new Pet(specie, name, age, race, own);

		if(pet.getSpecie().equalsIgnoreCase("gato")){
			for(int i = MIN_CATROW; i<= MAX_CATROW && !find; i++){
				for(int j = MIN_CATCOL; j <= MAX_CATCOL && !find; j++){
					if(habitats[i][j].getPet() == null){
						habitats[i][j].setPet(pet);
						habitats[i][j].setHabitatStatus(HabitatStatus.S);
						out = "The cat was add in guacal "+habitats[i][j].getHabitatidentifier();
						find = true;
					}
				}
			}
		}
		else if(pet.getSpecie().equalsIgnoreCase("perro")){
			for(int i = MIN_DOGROW; i<= MAX_DOGROW && !find; i++){
				for(int j = MIN_DOGCOL; j <= MAX_DOGCOL && !find; j++){
					if(habitats[i][j].getPet() == null){
						habitats[i][j].setPet(pet);
						habitats[i][j].setHabitatStatus(HabitatStatus.S);
						out = "The dog was add in house "+habitats[i][j].getHabitatidentifier();
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
					}
				}
			}
		}
		else if(pet.getSpecie().equalsIgnoreCase("conejo")){
			for(int i = MIN_RABBITROW; i<= MAX_RABBITROW && !find; i++){
				for(int j = MIN_RABBITCOL; j <= MAX_RABBITCOL && !find; j++){
					if(habitats[i][j].getPet() == null){
						habitats[i][j].setPet(pet);
						habitats[i][j].setHabitatStatus(HabitatStatus.S);
						out = "The rabbit was add in house "+habitats[i][j].getHabitatidentifier();
						find = true;
					}
				}
			}
		}
		else if(pet.getSpecie().equalsIgnoreCase("bird")){
			for(int i = MIN_BIRDROW; i<= MAX_BIRDROW && !find; i++){
				for(int j = MIN_BIRDCOL; j <= MAX_BIRDCOL && !find; j++){
					if(habitats[i][j].getPet() == null){
						habitats[i][j].setPet(pet);
						habitats[i][j].setHabitatStatus(HabitatStatus.S);
						out = "The bird was add in cage "+habitats[i][j].getHabitatidentifier();
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


	public void setUpHabitats(){

		int catCount = 1;
		int dogCount = 1;
		int reptilCount =1;
		int rabbitCount = 1;
		int birdCount = 1;

		for(int i = 0; i<habitats.length;i++){
			for(int j=0; j<habitats[0].length; j++){
				if(i>=MIN_CATROW && i<=MAX_CATROW){
					if(j>=MIN_CATCOL && j<=MAX_CATCOL){
						habitats[i][j] = new CatArea("G"+catCount, "15", "15", "15", "20 KL");
						catCount++;
					}
				}
				else if(i>=MIN_DOGROW && i<=MAX_DOGROW){
					if(j>=MIN_DOGCOL && j<=MAX_DOGCOL){
						habitats[i][j] = new DogArea("D"+dogCount, "25", "25", 5);
						dogCount++;
					}
				}
				else if(i>=MIN_REPTILROW && i<=MAX_REPTILROW){
					if(j>=MIN_REPTILCOL && j<=MAX_REPTILCOL){
						if(reptilCount <=2){
							habitats[i][j] = new ReptileArea("R"+reptilCount, "10", "10", "Metal y vidrio", AquariumType.EARTH);
							
						}
						else{
							habitats[i][j] = new ReptileArea("R"+reptilCount, "10", "10","Metal y vidrio", AquariumType.AMPHIBIAN);
						}
						reptilCount++;
					}
				}
				else if(i>=MIN_RABBITROW && i<=MAX_RABBITROW){
					if(j>=MIN_RABBITCOL && j<=MAX_RABBITCOL){
						habitats[i][j] = new RabbitArea("C"+rabbitCount, "12", "12","Savila", "10");
						rabbitCount++;
					}
				}
				else if(i>=MIN_BIRDROW && i<=MAX_BIRDROW){
					if(j>=MIN_BIRDCOL && j<=MAX_BIRDCOL){
						if(birdCount<=2){
							habitats[i][j] = new BirdArea("B"+birdCount, "18", "18", "16", "5", CageType.GROUND_CAGE);
						}
						else{
							habitats[i][j] = new BirdArea("B"+birdCount, "18", "18", "16", "5", CageType.GROUND_CAGE);
						}
						birdCount++;
					}
				}

			}
		}
	}

	
	public String findPetInNursery(String name){

		String out = "";

		ArrayList<PetHabitats> habitat = findHabitats(name);

		for(int i = 0; i<habitat.size(); i++){
			out += habitat.get(i).showInfo()+"\n"; 

		}

		return out;
			
	}

	public ArrayList<PetHabitats> findHabitats(String name){

		ArrayList<PetHabitats> habitat = new ArrayList<PetHabitats>();

		for(int i = 0; i<habitats.length; i++){
			for(int j = 0; j<habitats[0].length; j++){
				if(habitats[i][j] != null){
					if(habitats[i][j].getPet().getName().equals(name)){
						habitat.add(habitats[i][j]);
					}
				}
			}
		}
		return habitat;				
	}

	
	public String printMap(){

		String out = "";

		for(int i = 0; i<habitats.length; i++){
			for(int j = 0; j<habitats[0].length; j++){
				if(habitats[i][j] != null){
					out += habitats[i][j].getHabitatidentifier()+""+habitats[i][j].getHabitatStatus()+" - "+"\n";
				}	
			}
		}

		return out;
	}
		

}


	

