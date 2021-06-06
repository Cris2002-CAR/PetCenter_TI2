package model;

public class BirdArea extends PetHabitats{

	/**
	the height of each cage
	*/
	private String height;

	/**
	Maximum number of birds per cage
	*/
	private String maximumBirds;

	/////////////Relations

	/**
	Relationship to the enum CageType to obtain the cage type of the bird.
	*/
	private CageType cage;

	///////////////Constructor

	/**
	 * Bird area construction method for creating bird living spaces
	 * Initializes attributes by parameters
 	 * @param habitatIdentifier type String
	 * @param hLength type String
	 * @param width type String
	 * @param height type String
	 * @param maximumBirds type String
	 * @param cage type CageType
	*/
	public BirdArea(String habitatIdentifier, String hLength, String width, 
		String height, String maximumBirds, CageType cage){

		super(habitatIdentifier, hLength, width);
		this.height = height;
		this. maximumBirds = maximumBirds;
		this.cage = cage;
	}

	//////////////////////Gets

	public String getHeight(){
		return height;
	}

	public String getMaximumBirds(){
		return maximumBirds;
	}

	public CageType getCage(){
		return cage;
	}

	/////////////Sets

	public void setHeight(String height){
		this.height = height;
	}

	public void setMaximumBirds(String maximumBirds){
		this.maximumBirds = maximumBirds;
	}

	public void setCage(CageType cage){
		this.cage = cage;
	}

	@Override
	public String showInfo(){

		String out = super.showInfo();

		return out;
	}

}