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
	*
	*
	*/

	public ReptileArea(Pet pet, String habitatIdentifier, String hLength, String width, 
		HabitatStatus habitatStatus, String aquariumMaterial, AquariumType aquarium){

		super(pet, habitatIdentifier, hLength, width, habitatStatus);
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
}