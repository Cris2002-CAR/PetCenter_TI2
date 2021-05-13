package model;

public class PetCenter{

	/**

	*/
	public final int MAX_VETERINARIES = 7;

	/**

	*/
	public final int MAX_ATTENDED_PETS = 120;

	/**

	*/
	private int numVeterinaries;

	/**

	*/
	private int numPets;

	/**

	*/
	private Veterinary[] veterinaries;

	/**

	*/
	private Pet[] pets;

	///////////////////////Method Constructs

	/**
	*
	*
	*/
	public PetCenter(){

		veterinaries = new Veterinary[MAX_VETERINARIES];
		pets = new Pet[MAX_ATTENDED_PETS];
		numVeterinaries = 0;
		numPets = 0;

	}
	//////////////////Gets

	/**
	*
	*
	*@return
	*/
	public Veterinary[] getVeterinaries(){

		return veterinaries;
	}

	/**
	*
	*
	*@return
	*/
	public Pet[] getPets(){

		return pets;
	}

	////////////////////Sets

	/**
	*
	*
	*@param
	*/
	public void setVeterinaries(Veterinary[] veterinaries){

		this.veterinaries = veterinaries;
	}

	/**
	*
	*
	*@param
	*/
	public void setPet(Pet[] pets){

		this.pets = pets;
	}

	////////////////////Methods

	/**
	*
	*
	*@param
	*@return
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
	*
	*
	*@param
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
	*
	*
	*@param
	*@return
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
	*
	*
	*@param
	*/
	public void removePet(String name, String nameOwn){

		boolean find = false;
		for(int i=0; i<pets.length && !find && (pets[i].getStatus() == Status.WAITING); i++){
			if(pets[i] != null){
				if(pets[i].getName().equals(name) && (pets[i].getOwner().getName().equals(nameOwn))){
					System.out.println("La mascota "+pets[i].getName()+" ha sido eliminada");
					pets[i].setStatus(Status.INNATENDED_DEPARTURE);
					find = true;
				}
				else{

					System.out.println("No se puede eliminar esta mascota porque ya esta en consulta o fue atendida por un veterinario");
				}	
			}
		}



	}

	/**
	*
	*
	*@param
	*@return
	*/
	public int valuePriority(Priority priority){

		if(Priority.RED == priority){
			return 5;
		}

		else if(Priority.ORANGE == priority){
			return 4;
		}

		else if(Priority.YELLOW == priority){
			return 3;
		}

		else if(Priority.GREEN == priority){
			return 2;
		}

		else if(Priority.BLUE == priority){
			return 1;
		}

		return 0;
	}

	/**
	*
	*
	*@return
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
				priority1 = valuePriority(nexPet.getPriority());
				priority2 = valuePriority(pets[i].getPriority());
				if(priority2 > priority1){
					nexPet = pets[i];
				}
			}
		}
		return nexPet;
	}

	/**
	*
	*
	*@param
	*/
	public void startConsultation(String id){
		
		boolean find = false;

		for(int i=0; i<veterinaries.length && !find; i++){

			if(veterinaries[i] != null){

				if(veterinaries[i].getId().equals(id)){

					if(veterinaries[i].getAvailable()){
						Pet pet = findNextPet();
						if(pet.getStatus() != Status.INNATENDED_DEPARTURE){
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
	*
	*
	*@param
	*@return
	*/
	public Pet findPetByVeterinary(Veterinary veterinary){

		Pet pet = null;
		boolean find = false;

		for(int i=0; i<pets.length && !find; i++){
			if(pets[i].getAttend().equals(veterinary)){
				pet = pets[i];
				find = true;
			}
		}
		return pet;
	}

	/**
	*
	*
	*@param
	*/
	public void endConsultation(String id, String namePet, Status status){

		boolean find = false;

		for(int i=0; i<veterinaries.length && !find; i++){
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
		if(!find){
			System.out.print("El id ingresado no existe");
		}
	}

	/**
	*
	*
	*@return
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
	*
	*
	*@return
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
	*
	*
	*@return
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
	*
	*
	*@return
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
	*
	*
	*@return
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
	*
	*
	*/
	public void deleteAttendedPets(){

		pets = new Pet[MAX_ATTENDED_PETS];
	}

	public void mostrarVeterinarios(){

		for (int i=0;i<numVeterinaries; i++){

			System.out.println(veterinaries[i].getName());
			System.out.println(veterinaries[i].getId());
			System.out.println(veterinaries[i].getUniqueNumber());
			
		}

	}

	public void mostrarMascotas(){

		for(int i=0; i<numPets; i++){

			System.out.println(pets[i].getName());
			System.out.println(pets[i].getStatus());
		}
	}


	

	
}
