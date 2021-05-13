package model;

public class Veterinary{

	/**

	*/
	private String id;

	/**

	*/
	private String name;

	/**

	*/
	private String lastname;

	/**

	*/
	private String uniqueNumber;

	/**

	*/
	private boolean available;

	/////////////////Method constructs

	/**
	*
	*
	*@param
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
	*
	*
	*@return
	*/
	public String getId(){

		return id; 
	}

	/**
	*
	*
	*@return
	*/
	public String getName(){

		return name;
	}

	/**
	*
	*
	*@return
	*/
	public String getLastname(){

		return lastname;
	}

	/**
	*
	*
	*@return
	*/
	public String getUniqueNumber(){

		return uniqueNumber;
	}

	/**
	*
	*
	*@return
	*/
	public boolean getAvailable(){

		return available;
	}

	//////////////////////////Sets

	public void setId(String id){

		this.id = id;

	}

	public void setName(String name){

		this.name = name;
	}

	public void setLastname(String lastname){

		this.lastname = lastname;
	}

	public void setUniqueNumber(String uniqueNumber){

		this.uniqueNumber = uniqueNumber;
	}

	public void setAvailable(boolean available){

		this.available = available;
	}
}