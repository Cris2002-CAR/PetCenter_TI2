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
	public CatArea(String habitatIdentifier, String hLength, String width, 
		 String height, String maximumWeight){

		super(habitatIdentifier, hLength, width);
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