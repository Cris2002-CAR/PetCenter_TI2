package model;

public class RabbitArea extends PetHabitats{

	/**
	Type of plant that has rabbit
	*/
	private String plantType;

	/**
	Number of plants that the rabbit will have
	*/
	private String plantsNumber;

	////////////Constructor

	/**
	*
	*
	*/
	public RabbitArea(Pet pet, String habitatIdentifier, String hLength, String width, 
		HabitatStatus habitatStatus, String plantType, String plantsNumber){

		super(pet, habitatIdentifier, hLength, width, habitatStatus);
		this.plantType = plantType;
		this.plantsNumber = plantsNumber;
	}

	//////////////Gets
	public String getPlantsNumber(){
		return plantsNumber;
	}

	public String getPlantType(){
		return plantType;
	}

	////////////Sets
	public void setPlantsNumber(String plantsNumber){
		this.plantsNumber = plantsNumber;
	}

	public void setPlantType(String plantType){
		this.plantType = plantType;
	}
}