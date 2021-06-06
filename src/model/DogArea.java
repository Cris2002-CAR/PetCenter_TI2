package model;

public class DogArea extends PetHabitats{

	/**
	Number of toys in the dog's house
	*/
	private int toyNumbers;

	///////////Constructor

	/**
	 * Dog area construction method for creating dog living spaces
	 * Initializes attributes by parameters
 	 * @param habitatIdentifier type String
	 * @param hLength type String
	 * @param width type String
	 * @param toyNumbers type int
	*/
	public DogArea( String habitatIdentifier, String hLength, String width, 
		int toyNumbers){

		super(habitatIdentifier, hLength, width);
		this.toyNumbers = toyNumbers;
	}

	////////////////////////gets

	public int getToysNumbers(){
		return toyNumbers;
	}

	////////////////////////Sets
	
	public void setToysNumbers(int toyNumbers){
		this.toyNumbers = toyNumbers;
	}

	@Override
	public String showInfo(){

		String out = super.showInfo();

		return out;
	}
}