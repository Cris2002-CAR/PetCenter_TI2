package model;

public class CatArea extends PetHabitats{

	/**
	Cat habitat high
	*/
	private String height;

	/**
	Maximum weight of the guacal
	*/
	private String maximumWeight;

	///////////////Constructor

	/**
	*Cat area construction method for creating cat living spaces
	*
	*/
	public CatArea(Pet pet, String habitatIdentifier, String hLength, String width, 
		HabitatStatus habitatStatus, String height, String maximumWeight){

		super(pet, habitatIdentifier, hLength, width, habitatStatus);
		this.height = height;
		this.maximumWeight = maximumWeight;
	}

	//////////////Gets

	public String getHeight(){
		return height;
	}

	public String getMaximumWeight(){
		return maximumWeight;
	}

	////////////////Sets

	public void setHeight(String height){
		this.height = height;
	}

	public void setMaximumWeight(String maximumWeight){
		this.maximumWeight = maximumWeight;
	}
}