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
	public RabbitArea(String habitatIdentifier, String hLength, String width, 
		String plantType, String plantsNumber){

		super(habitatIdentifier, hLength, width);
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

	@Override
	public String showInfo(){

		String out = super.showInfo();

		return out;
	}
}