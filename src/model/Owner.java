package model;

public class Owner{

	/**

	*/
	private String name;

	/**

	*/
	private String id;

	/**

	*/
	private String phone;

	/**

	*/
	private String address;

	////////////////Method constructs

	/**
	*
	*
	*@param
	*/
	public Owner(String name, String id, String phone, String address){

		this.name = name;
		this.id = id;
		this.phone = phone;
		this.address = address;
	}

	//////////////////gets

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
	public String getId(){

		return id;
	}

	/**
	*
	*
	*@return
	*/
	public String getPhone(){

		return phone;
	}

	/**
	*
	*
	*@return
	*/
	public String getAddress(){

		return address;
	}

	////////////////////Sets

	public void setName(String name){

		this.name = name;
	}

	public void setId(String id){

		this.id = id;
	}

	public void setPhone(String phone){

		this.phone = phone;
	}

	public void setAddress(String address){

		this.address = address;
	}
}