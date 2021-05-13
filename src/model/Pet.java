package model;

public class Pet{

	/**

	*/
	private String specie;

	/**

	*/
	private String name;

	/**

	*/
	private String age;

	/**

	*/
	private String race;

	/**

	*/
	private String symptoms;

	//////////////relations

	/**

	*/
	private Priority priority;

	/**

	*/
	private Status status;

	/**

	*/
	private Owner owner;

	/**

	*/
	private Veterinary attend;

	////////////////////Method Constructs

	/**
	*
	*
	*@param
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
	*
	*
	*@return
	*/
	public String getSpecie(){

		return specie;
	}

	/**
	*
	*
	*@return
	*/
	public String getName(){

		return name;
	}

	/**
	*
	*
	*@return
	*/
	public String getAge(){

		return age;
	}

	/**
	*
	*
	*@return
	*/
	public String getRace(){

		return race;
	}

	/**
	*
	*
	*@return
	*/
	public String getSymptoms(){

		return symptoms;
	}

	/**
	*
	*
	*@return
	*/
	public Priority getPriority(){

		return priority;
	}

	/**
	*
	*
	*@return
	*/
	public Status getStatus(){

		return status;
	}

	/**
	*
	*
	*@return
	*/
	public Owner getOwner(){

		return owner;
	}

	/**
	*
	*
	*@return
	*/
	public Veterinary getAttend(){

		return attend;
	}

	////////////////////////Sets

	public void setSpecie(String specie){

		this.specie = specie;
	}

	public void setName(String name){

		this.name = name;
	}

	public void setAge(String age){

		this.age = age;
	}

	public void setRace(String race){

		this.race = race;
	}

	public void setSymptoms(String symptoms){

		this.symptoms = symptoms;
	}

	public void setStatus(Status status){

		this.status = status;
	}

	public void setAttend(Veterinary attend){

		this.attend = attend;
	}


}