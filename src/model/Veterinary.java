package model;

public class Veterinary{

	/**
	Variable to store the veterinarian's id
	*/
	private String id;

	/**
	Variable to store the veterinarian's name
	*/
	private String name;

	/**
	Variable to store the veterinarian's lastname
	*/
	private String lastname;

	/**
	Variable to store the unique number of the veterinarian.
	*/
	private String uniqueNumber;

	/**
	Boolean variable to know if the veterinarian will be available.
	*/
	private boolean available;

	/////////////////Method constructs

	/**
	*constructor method for creating the veterinary object
	*Initializes the available variable to true and initializes the others with the following parameters
	*@param id type String
	*@param name type String
	*@param lastname type String
	*@param uniqueNumber type String
	*/
	public Veterinary(String id, String name, String lastname, String uniqueNumber){

		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.uniqueNumber = uniqueNumber;
		available = true;

	}

	/////////////////////Gets

	/**
	*Obtains the id of a veterinarian to be able to use it.
	*@return id type String
	*/
	public String getId(){

		return id; 
	}

	/**
	*Obtains the name of a veterinarian to be able to use it.
	*@return name type String
	*/
	public String getName(){

		return name;
	}

	/**
	*Obtains the last name of a veterinarian to be able to use it.
	*@return lastname type String
	*/
	public String getLastName(){

		return lastname;
	}

	/**
	*Obtains the unic number of a veterinarian to be able to use it.
	*@return uniqueNumber type String
	*/
	public String getUniqueNumber(){

		return uniqueNumber;
	}

	/**
	*Obtains the available of a veterinarian to be able to use it.
	*@return available type boolean
	*/
	public boolean getAvailable(){

		return available;
	}

	//////////////////////////Sets

	/**
	*Change a veterinarian's ID
	*Change the id that is stored in the global variable
	*@param id type string
	*/
	public void setId(String id){

		this.id = id;

	}

	/**
	*Change a veterinarian's name
	*Change the name that is stored in the global variable
	*@param name type string
	*/
	public void setName(String name){

		this.name = name;
	}

	/**
	*Change a veterinarian's last name
	*Change the last name that is stored in the global variable
	*@param lastname type string
	*/
	public void setLastname(String lastname){

		this.lastname = lastname;
	}

	/**
	*Change a veterinarian's unic number
	*Change the unic number that is stored in the global variable
	*@param uniqueNumber type string
	*/
	public void setUniqueNumber(String uniqueNumber){

		this.uniqueNumber = uniqueNumber;
	}

	/**
	*Change a veterinarian's available
	*Change the available that is stored in the global variable
	*@param available type boolean
	*/
	public void setAvailable(boolean available){

		this.available = available;
	}
}