package model;

public class PetHabitats{

	/**
	Unique identifier of a habitat
	*/
	protected String habitatIdentifier;

	/**
	Variable of the length of the habitat
	*/
	protected String hLength;

	/**
	variable of habitat width
	*/
	protected String width;


	///////////////Relations

	protected HabitatStatus habitatStatus;



	/////////////Construtor

	/**
	*Constructor method of the class PetHabitats 
	*Initializes attributes by parameters
	*@param pet type pet
	*@param habitatIdentifier type String
	*@param hLength type String
	*@param width type String
	*@param habitatStatus type HabitatStatus
	*/
	public PetHabitats(Pet pet, String habitatIdentifier, String hLength, String width, 
		HabitatStatus habitatStatus){

		this.habitatIdentifier = habitatIdentifier;
		this.hLength = hLength;
		this.width = width;
		this.habitatStatus = habitatStatus; 

	}

	////////////////Gets

	public Pet getPet(){
		return pet;
	}

	public String getHabitatidentifier(){
		return habitatIdentifier;
	}

	public String getHLength(){
		return hLength;
	}

	public String getWidth(){
		return width;
	}

	public HabitatStatus getHabitatStatus(){
		return habitatStatus;
	}

	/////////////////////////Sets

	public void setPet(Pet pet){
		this.pet = pet;
	}

	public void setHabitatidentifier(String habitatIdentifier){
		this.habitatIdentifier = habitatIdentifier;
	}

	public void setHLength(String hLength){
		this.hLength = hLength;
	}

	public void setWidth(String width){
		this.width = width;
	}

	public void getHabitatStatus(HabitatStatus habitatStatus){
		this.habitatStatus = habitatStatus;
	}

}