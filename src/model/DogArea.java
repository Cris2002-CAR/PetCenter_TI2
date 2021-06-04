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
	public DogArea(String habitatIdentifier, String hLength, String width, 
		 int toyNumbers){

		super(habitatIdentifier, hLength, width);
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

	@Override
	public String showInfo(){

		String out = super.showInfo();

		return out;
	}
}