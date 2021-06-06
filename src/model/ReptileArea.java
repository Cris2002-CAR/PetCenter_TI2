package model;

public class ReptileArea extends PetHabitats{

	/**
	Aquarium material
	*/
	private String aquariumMaterial;

	////////Relations
	/**
	Relationship to the enum AquariumType to obtain the reptile's aquarium type
	*/
	private AquariumType aquarium;

	/////////////Constructos
	
	/**
	 * Reptil area construction method for creating reptil living spaces
	 * Initializes attributes by parameters
 	 * @param habitatIdentifier type String
	 * @param hLength type String
	 * @param width type String
	 * @param aquariumMaterial type String
	 * @param aquarium type AquariumType
	*/
	public ReptileArea(String habitatIdentifier, String hLength, String width, 
		 String aquariumMaterial, AquariumType aquarium){

		super(habitatIdentifier, hLength, width);
		this.aquariumMaterial = aquariumMaterial;
		this.aquarium = aquarium;
		
	}

	///////////////////gets

	public String getAquariumMaterial(){
		return aquariumMaterial;
	}

	
	public AquariumType getAquarium(){
		return aquarium;
	}

	/////////////Sets

	public void setAquariumMaterial(String aquariumMaterial){
		this.aquariumMaterial = aquariumMaterial;
	}


	public void setAquarium(AquariumType aquarium){
		this.aquarium = aquarium;
	}

	@Override
	public String showInfo(){

		String out = super.showInfo();

		return out;
	}
}