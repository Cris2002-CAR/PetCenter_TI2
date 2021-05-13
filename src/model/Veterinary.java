package model;

public class Veterinary{

	private String id;
	private String name;
	private String lastname;
	private String uniqueNumber;
	private boolean available;

	public Veterinary(String id, String name, String lastname, String uniqueNumber){

		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.uniqueNumber = uniqueNumber;
		available = true;

	}

	/////////////////////Gets

	public String getId(){

		return id; 
	}

	public String getName(){

		return name;
	}

	public String getLastname(){

		return lastname;
	}

	public String getUniqueNumber(){

		return uniqueNumber;
	}

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