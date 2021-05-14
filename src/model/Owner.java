package model;

public class Owner{

	/**
	Variable to store the name of an owner
	*/
	private String name;

	/**
	Variable to store the id of an owner
	*/
	private String id;

	/**
	Variable to store the phone of an owner
	*/
	private String phone;

	/**
	Variable to store the address of an owner
	*/
	private String address;

	////////////////Method constructs

	/**
	*Constructor method to create an object of type Owner
	*Variables are initialized by parameters
	*@param name type String
	*@param id type String
	*@param phone type String
	*@param address type String
	*/
	public Owner(String name, String id, String phone, String address){

		this.name = name;
		this.id = id;
		this.phone = phone;
		this.address = address;
	}

	//////////////////gets

	/**
	*Obtains the owner's name in order to be able to use it
	*@return name type String
	*/
	public String getName(){

		return name;
	}

	/**
	*Obtains the owner's id in order to be able to use it
	*@return id type String
	*/
	public String getId(){

		return id;
	}

	/**
	*Obtains the owner's phone in order to be able to use it
	*@return phone type String
	*/
	public String getPhone(){

		return phone;
	}

	/**
	*Obtains the owner's address in order to be able to use it
	*@return address type String
	*/
	public String getAddress(){

		return address;
	}

	////////////////////Sets

	/**
	*change the owner's name
	*changes the name that is stored in the global variable
	*@param name type String
	*/
	public void setName(String name){

		this.name = name;
	}

	/**
	*change the owner's id
	*changes the id that is stored in the global variable
	*@param id type String
	*/
	public void setId(String id){

		this.id = id;
	}

	/**
	*change the owner's phone
	*changes the phone that is stored in the global variable
	*@param phone type String
	*/
	public void setPhone(String phone){

		this.phone = phone;
	}

	/**
	*change the owner's address
	*changes the address that is stored in the global variable
	*@param address type String
	*/
	public void setAddress(String address){

		this.address = address;
	}
}