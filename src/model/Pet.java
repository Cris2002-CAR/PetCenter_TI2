package model;

public class Pet{

	/**
	Variable to store the species of the pet
	*/
	private String specie;

	/**
	Variable to store the pet's name
	*/
	private String name;

	/**
	Variable to store the pet's age
	*/
	private String age;

	/**
	Variable to store the pet's race
	*/
	private String race;

	/**
	Variable to store the pet's symptoms
	*/
	private String symptoms;

	//////////////relations

	/**
	Relationship with the enum Priority class to obtain the pet priority
	*/
	private Priority priority;

	/**
	Relationship with the enum Status class to obtain the pet status
	*/
	private Status status;

	/**
	Relationship with the Owner class to get the pet owner
	*/
	private Owner owner;

	/**
	Link to the Veterinary class to obtain the veterinarian who attended the pet.
	*/
	private Veterinary attend;

	////////////////////Method Constructs

	/**
	*Constructor method to create an object of type Pet
	*Initializes the attend variable to null, and the others are initialized by parameters.
	*@param specie type String
	*@param name type String
	*@param age type String
	*@param race type String
	*@param symptoms type String
	*@param owner type Owner
	*@param priority type Priority
	*@param status type Status
	*/
	public Pet(String specie, String name, String age, String race, String symptoms, Owner owner, 
		Priority priority, Status status){

		this.specie = specie;
		this.name = name;
		this.age = age;
		this.race = race;
		this.symptoms = symptoms;
		this.priority = priority;
		this.status = status;
		this.owner = owner;
		attend = null;
	}

	////////////////////////Gets

	/**
	*Obtains the species of a pet in order to be able to use it
	*@return specie type String
	*/
	public String getSpecie(){

		return specie;
	}

	/**
	*Obtains the name of a pet in order to be able to use it
	*@return name type String 
	*/
	public String getName(){

		return name;
	}

	/**
	*Obtains the age of a pet in order to be able to use it
	*@return age type String
	*/
	public String getAge(){

		return age;
	}

	/**
	*Obtains the race of a pet in order to be able to use it
	*@return race type String
	*/
	public String getRace(){

		return race;
	}

	/**
	*Obtains the symptoms of a pet in order to be able to use it
	*@return symptoms type String
	*/
	public String getSymptoms(){

		return symptoms;
	}

	/**
	*Obtains the priority of a pet in order to be able to use it
	*@return priority type String
	*/
	public Priority getPriority(){

		return priority;
	}

	/**
	*Obtains the status of a pet in order to be able to use it
	*@return status type String
	*/
	public Status getStatus(){

		return status;
	}

	/**
	*Obtains the owner of a pet in order to be able to use it
	*@return owner type String
	*/
	public Owner getOwner(){

		return owner;
	}

	/**
	*Obtains the veterinarian who treated a pet's pet in order to use it.
	*@return attend type String
	*/
	public Veterinary getAttend(){

		return attend;
	}

	////////////////////////Sets

	/**
	*change the species of the pet
	*Changes the species stored in the global variable
	*@param specie type String
	*/
	public void setSpecie(String specie){

		this.specie = specie;
	}

	/**
	*change the pet's name
	*Change the name that is stored in the global variable
	*@param name type String
	*/
	public void setName(String name){

		this.name = name;
	}

	/**
	*change the pet's age
	*Change the age that is stored in the global variable
	*@param age type Strig
	*/
	public void setAge(String age){

		this.age = age;
	}

	/**
	*change the pet's race
	*Change the race that is stored in the global variable
	*@param race type String
	*/
	public void setRace(String race){

		this.race = race;
	}

	/**
	*change the pet's symptoms
	*Change the symptoms that is stored in the global variable
	*@param symptoms type String
	*/
	public void setSymptoms(String symptoms){

		this.symptoms = symptoms;
	}

	/**
	*change the pet's status
	*@param status type Status
	*/
	public void setStatus(Status status){

		this.status = status;
	}

	/**
	*change the pet's attend
	*@param attend type Veterinary
	*/
	public void setAttend(Veterinary attend){

		this.attend = attend;
	}


}