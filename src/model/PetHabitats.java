package model;

public abstract class PetHabitats{

	/**
	Unique identifier of a habitat
	*/
	private String habitatIdentifier;

	/**
	Variable of the length of the habitat
	*/
	private String hLength;

	/**
	variable of habitat width
	*/
	private String width;


	///////////////Relations

	protected HabitatStatus habitatStatus;

	private Pet pet;

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
	public PetHabitats(String habitatIdentifier, String hLength, String width){

		this.habitatIdentifier = habitatIdentifier;
		this.hLength = hLength;
		this.width = width;
		habitatStatus = HabitatStatus.V;
		pet = null; 

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

	public void setHabitatStatus(HabitatStatus habitatStatus){
		this.habitatStatus = habitatStatus;
	}

	//public abstract String showInfo();

	public String showInfo(){

		String out = "";

		/*
		if(getHabitatStatus() == HabitatStatus.S){

			out = habitatIdentifier+" Condition: healthy ";
		}
		else{

			out = habitatIdentifier+" Condition: sick ";
		}
		*/

		out = habitatIdentifier+""+habitatStatus;
		

		return out;
	}

	//public abstract PetHabitats setUpHabitats();

	

}