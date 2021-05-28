package model;

public class DogArea extends PetHabitats{

	/**
	Number of toys in the dog's house
	*/
	private int toyNumbers;

	///////////Constructor

	/**
	*
	*
	*/
	public DogArea(Pet pet, String habitatIdentifier, String hLength, String width, 
		HabitatStatus habitatStatus, int toyNumbers){

		super(pet, habitatIdentifier, hLength, width, habitatStatus);
		this.toyNumbers = toyNumbers;
	}

	///////////Get
	public int getToysNumbers(){
		return toyNumbers;
	}

	/////////Set
	public void setToysNumbers(int toyNumbers){
		this.toyNumbers = toyNumbers;
	}
}