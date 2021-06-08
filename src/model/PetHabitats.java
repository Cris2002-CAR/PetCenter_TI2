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

	/**
	Relationship to HabitatStatus enum 
	*/
	protected HabitatStatus habitatStatus;

	/**
	Relationship to the pet class
	*/
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

	/**
	 * Method get to obtain the pet
	 * @return pet
	*/
	public Pet getPet(){
		return pet;
	}

	/**
	 * Method get to obtain the habitat identifier
	 * @return habitat identifier
	*/
	public String getHabitatidentifier(){
		return habitatIdentifier;
	}

	/**
	 * Method get to obtain the length of the habitat
	 * @return length
	*/
	public String getHLength(){
		return hLength;
	}

	/**
	 * Method get to obtain the habitat width
	 * @return width
	*/
	public String getWidth(){
		return width;
	}

	/**
	 * Method get to obtain habitat status
	 * @return habitat status
	*/
	public HabitatStatus getHabitatStatus(){
		return habitatStatus;
	}

	/////////////////////////Sets

	/**
	 * Method set to change the pet's habitat
	 * The mascot is changed in the global attribute 
	 * @param pet type Pet 
	*/
	public void setPet(Pet pet){
		this.pet = pet;
	}

	/**
	 * Method set to change the habitat identifier habitat
	 * The habitat identifier is changed in the global attribute
	 * @param habitatIdentifier type String 
	*/
	public void setHabitatidentifier(String habitatIdentifier){
		this.habitatIdentifier = habitatIdentifier;
	}

	/**
	 * Method set to change the length habitat 
	 * The length changed in the global attribute
	 * @param hLength type String
	*/
	public void setHLength(String hLength){
		this.hLength = hLength;
	}

	/**
	 * Method set to change the width habitat
	 * The width changed in the global attribute
	 * @param width type String 
	*/
	public void setWidth(String width){
		this.width = width;
	}

	/**
	 * Method set to change the Status habitat 
	 * The habitat status changed in the global attribute
	 * @param habitatStatus type HabitatStatus
	*/
	public void setHabitatStatus(HabitatStatus habitatStatus){
		this.habitatStatus = habitatStatus;
	}

	/**
	 * Displays habitat information
	*/
	public String showInfo(){

		String out = "";

		out = habitatIdentifier+""+habitatStatus;

		return out;
	}

	/**
	 * Show habitat's information 
	 * @return  the information of the habitat and it's pet
	*/
	public String showHabitat(){

		String out = "";

		if(habitatStatus == HabitatStatus.V){

			out = "\nHabitat: "+habitatIdentifier+"\nLength: "+hLength+"\nWidth: "+width+ "\nStatus: Empty";
		}
		else {
			out = "\nHabitat: "+habitatIdentifier+"\nLength: "+hLength+"\nWidth: "+width+ "\nStatus: Occupied";
			out += "\n\n Pet Information : "+"\nSpecie: "+pet.getSpecie()+"\nName: "+pet.getName()+"\nAge: "+pet.getAge()+"\nRace: "+pet.getRace();
		}

		if(habitatStatus == (HabitatStatus.E) && habitatStatus != HabitatStatus.V){
			out += "\nThe pet is sick";
		}
		else if(habitatStatus == (HabitatStatus.S) && habitatStatus != HabitatStatus.V){
			out += "\nThe pet is healthy";
		}

		return out;
	}

	

}