package ui;

import java.util.Scanner;

import model.PetCenter;

import model.PetNursery;

import model.Priority;

import model.Status;

import javax.swing.JOptionPane; 

public class Main{

	/**
	A scanner is initialized with a range of all methods.
	*/
	private Scanner reader = new Scanner(System.in);

	/**
	Relationship with the main class of the model (center) to connect the main class
	*/
	private PetCenter center;

	/**
	Relationship with the PetNursery class for access to the center's nursery
	*/
	private PetNursery nursery;

	/**
	Global data type boolean to close the menu with the condition required by the program.
	*/
	private boolean continued = true;

	/**
	*Constructor method for initializing attributes or relationships
	*/

	public Main(){

		center = new PetCenter();
		nursery = new PetNursery();
	}

	public static void main (String[] args){

		Main obj = new Main();

		do{
			
			obj.mainMenu();

		}while(obj.continued);
	 }


	 public void mainMenu(){

	 	int option = 0;


		System.out.println("  MAIN MENU  "
 			+"\n1. Veterinary emergencies"
 			+"\n2. Pet nursery and hospitalization"
 			+"\n3. End day");

 		System.out.print("Choose an option: ");

 		option = reader.nextInt();
 		reader.nextLine();
 		System.out.println();


 		switch(option){
 			case 1:
 				menu1();
 				break;
			case 2:
				petNurseryMenu();
				break;
			case 3:
				endDayReports();
				break;
 		}

	 	

	 }

	 /**
	 *In this method the user will be able to enter a menu, where he must choose what to do in the program.
	 *The global boolean variable is used to close the program when the user is able to do so.
	 */
	 public void menu1(){

	 	int option=0;
	 	int menuOption = 1;
	 	
	 	while(menuOption != 0){
	 		System.out.println("  \nEMERGENCY MENU  "
	 			+"\n0. Back to main menu"
	 			+"\n1. Add a vet"
	 			+"\n2. Remove vet"
	 			+"\n3. Register a pet"
	 			+"\n4. Remove a pet"
	 			+"\n5. Start a veterinary consultation"
	 			+"\n6. Finalize a veterinary consultation"
	 			+"\n7. Show the number of pets that have not been cared for");
	 			
	 		System.out.print("Choose an option: ");
	 		option = reader.nextInt();
	 		reader.nextLine();
	 		System.out.println();

	 		switch(option){
	 			case 1:
	 			System.out.println("___________________________________________________________________________");
	 			addVeterinary();
	 			break;

	 			case 2:
	 			System.out.println("___________________________________________________________________________");
	 			deleteVeterinary();
	 			break;

	 			case 3:
	 			System.out.println("___________________________________________________________________________");
	 			addPetandOwner();
	 			break;

	 			case 4:
	 			System.out.println("___________________________________________________________________________");
	 			removePet();
	 			break;

	 			case 5:
	 			System.out.println("___________________________________________________________________________");
	 			startConsultation();
	 			break;

	 			case 6:
	 			System.out.println("___________________________________________________________________________");
	 			endConsultation();
	 			break;

	 			case 7:
	 			System.out.println("___________________________________________________________________________");
	 			notAttendedPets();
	 			break;

	 			case 0:
	 			menuOption = 0;
	 			break;

	 		}
	 	}
	 }


	 public void petNurseryMenu(){

	 	int option = 0;
	 	int menuOption = 1;
	 	
	 	while(menuOption != 0){
	 		System.out.println("  \nPET NURSERY MENU  "  
	 			+"\n0. Back to main menu");

	 		System.out.print("Choose an option: ");
	 		option = reader.nextInt();
	 		reader.nextLine();
	 		System.out.println();

	 		switch(option){

	 			case 0:
	 				menuOption = 0;
	 				break;
 				case 1:
 					addPetToNursery();
 					break;


	 		}

	 	}
	 	
	 }



	 /**
	 *This method allows the user to add a veterinarian
	 *The relationship center is used to pass the veterinarian's data
	 */
	 public void addVeterinary(){

	 	System.out.println("Please enter the vet's personal information: ");
 
	 	System.out.print("ID: ");
	 	String id = reader.nextLine();

	 	System.out.print("Name: ");
	 	String name = reader.nextLine();

	 	System.out.print("Last name: ");
	 	String lastname = reader.nextLine();

	 	System.out.print("Veterinarian's unique number: ");
	 	String uniqueNumber = reader.nextLine();

	 	boolean saved = center.addVeterinary(id, name, lastname, uniqueNumber);
	 	
	 	if(saved){
	 		System.out.println("The veterinarian has been successfully added\n");
	 	}
	 	else{
	 		System.out.println("The number of veterinarians allowed has been exceeded\n");
	 	}

	 }

	 /**
	 *This method will allow the user to delete a veterinarian if the conditions for doing so are met.
	 *The center relationship is used to pass the unique number of the veterinarian, which will be used to eliminate the veterinarian.
	 */
	 public void deleteVeterinary(){

	 	System.out.println("Please enter the unique number of the veterinarian you wish to remove: ");

	 	String uniqueNumber = reader.nextLine();

	 	center.deleteVeterinary(uniqueNumber);
	 	
	 }

	 /**
	 *This method allows the user to register a pet and its owner.
	 *The center relationship is used to pass all the owner and pet data, and create the object
	 */
	 public void addPetandOwner(){

	 	System.out.println("Please enter the data of the pet you want to add: ");

	 	System.out.print("Specie: ");
	 	String specie = reader.nextLine();

	 	System.out.print("Name: ");
	 	String name = reader.nextLine();

	 	System.out.print("Age: ");
	 	String age = reader.nextLine();

	 	System.out.print("Race (Dog or cat): ");
	 	String race = reader.nextLine();

	 	System.out.print("Symptoms: ");
	 	String symptoms = reader.nextLine();

	 	System.out.println("Enter owner details: ");
	 	
	 	System.out.print("Name: ");
	 	String nameOwn = reader.nextLine();

	 	System.out.print("ID: ");
	 	String idOwn = reader.nextLine();

	 	System.out.print("Cellphone: ");
	 	String phoneOwn = reader.nextLine();
	 	
	 	System.out.print("Address: ");
	 	String addressOwn = reader.nextLine();
	 	System.out.println();
	 		 	

	 	System.out.println("Select the priority in which the pet should be cared for: "
	 		+"\n1: RED"
	 		+"\n2: ORANGE"
	 		+"\n3: YELLOW"
	 		+"\n4: GREEN"
	 		+"\n5: BLUE");

	 	int status = reader.nextInt();
	 	reader.nextLine();

	 	boolean saved = false;

	 	switch(status){

	 		case 1:
	 		saved = center.addPet(specie, name, age, race, symptoms, Priority.RED, Status.WAITING, nameOwn,
	 			idOwn, phoneOwn, addressOwn);
	 		break;

	 		case 2:
	 		saved = center.addPet(specie, name, age, race, symptoms, Priority.ORANGE, Status.WAITING, nameOwn,
	 			idOwn, phoneOwn, addressOwn);
	 		break;

	 		case 3:
	 		saved = center.addPet(specie, name, age, race, symptoms, Priority.YELLOW, Status.WAITING, nameOwn,
	 			idOwn, phoneOwn, addressOwn);
	 		break;

	 		case 4:
	 		saved = center.addPet(specie, name, age, race, symptoms, Priority.GREEN, Status.WAITING, nameOwn,
	 			idOwn, phoneOwn, addressOwn);
	 		break;

	 		case 5:
	 		saved = center.addPet(specie, name, age, race, symptoms, Priority.BLUE, Status.WAITING, nameOwn,
	 			idOwn, phoneOwn, addressOwn);
	 		break;

	 		default:
	 		System.out.println("Error. invalid option");
	 		break;
	 		
	 	}
	 	if(saved){
	 		System.out.println("The pet has been successfully registered\n");
	 	}
	 	else{
	 		System.out.println("The pet could not be registered because the allowed number has been exceeded\n");
	 	}

	 }

	 /**
	 *This method will allow the user to take a pet out of the center. 
	 *The center relation sends the data to the class method of the model and removes the pet.
	 */
	 public void removePet(){

	 	System.out.println("Please enter the name of the pet: ");
	 	String name = reader.nextLine();

	 	System.out.println("Please enter the owner's name: ");
	 	String nameOwn = reader.nextLine();	 	

	 	center.removePet(name, nameOwn);

	 }

	 /**
	 *This method allows the user to initiate a veterinary consultation.
	 *The relationship center is used to send the id of the veterinarian who will do the consultation.	
	 */
	 public void startConsultation(){

	 	System.out.print("Please enter the vet's ID: ");
	 	String id = reader.nextLine();

	 	center.startConsultation(id);

	 }

	 /**
	 *This method allows to finalize a veterinary consultation previously started.
	 *The relationship center is used to send the veterinarian and pet data to the method that completes the consultation.
	 */
	 public void endConsultation(){

	 	System.out.print("Please enter the vet's ID: ");
	 	String id = reader.nextLine();

	 	System.out.print("Please enter the name of the pet: ");
	 	String namePet = reader.nextLine();

	 	System.out.println("Please indicate what state the pet leaves with: "
	 		+"\n1. AUTHORIZE DEPARTURE"
	 		+"\n2. HOSPITALIZATION");

	 	int option = 0;

	 	option = reader.nextInt();
	 	reader.nextLine();

	 	switch(option){

	 		case 1:
	 		center.endConsultation(id,namePet,Status.AUTHORIZE_DEPARTURE);
	 		break;

	 		case 2:
	 		center.endConsultation(id,namePet,Status.HOSPITALIZATION);
	 		break;

	 		default:
	 		System.out.print("ERROR. Invalid option");
	 		break;
	 	}

	 }

	 /**
	 *This method shows all the reports to end the day.
	 *If the condition is met, the boolean data type "continued" changes and closes the program. 
	 */
	 public void endDayReports(){
	 	boolean check = center.checkNotWaitingPets();
	 	if(check){

	 		System.out.println("There are still pets to attend to");
	 	}
	 	else{
	 		veterinaryMostAttendPets();
	 		attendsPetsForPriority();
	 		notAttendPercentage();
	 		deleteAttendedPets();
	 		continued = false;	
	 	}
	 }

	 /**
	 *This method counts unattended pets and displays them to the user.
	 *Relationship center calls the method that counts the mascot
	 */
	 public void notAttendedPets(){

	 	System.out.println("The number of pets that have not been cared for is: "+center.notAttendedPets());
	 }

	 /**
	 *This method obtains the veterinarian with the most consultations.
	 *The relationship center gets the veterinarian by calling the method
	 */
	 public void veterinaryMostAttendPets(){

	 	System.out.println("The veterinarian with the highest number of consultations is: "+center.veterinaryMostAttendPets());
	 }

	 /**
	 *This method counts each pet by priority
	 *The center relation is used to call a method and assign it to an array to display the data.
	 */
	 public void attendsPetsForPriority(){

	 	int priorities[] = center.attendsPetsForPriority();

	 	System.out.println("There are "+priorities[0]+" pets with red priority");
	 	System.out.println("There are "+priorities[1]+" pets with orange priority");
	 	System.out.println("There are "+priorities[2]+" pets with yellow priority");
	 	System.out.println("There are "+priorities[3]+" pets with green priority");
	 	System.out.println("There are "+priorities[4]+" pets with blue priority");
	 }

	 /**
	 *This method calculates the percentage of pets that left without being attended by a veterinarian.
	 *The center relation is used to call the method that calculates the percentage and displays it to the user.
	 */
	 public void notAttendPercentage(){

	 	System.out.println("The percentage of pets that left unattended is: "+center.notAttendPercentage()+"%");
	 }

	 /**
	 *This method takes care of eliminating all pets once the day is over.
	 *The relationship center is used to call the method that is in charge of eliminating all pets.
	 */
	 public void deleteAttendedPets(){

	 	center.deleteAttendedPets();
	 	System.out.println("All pets cared for have been removed");
	 }



	 ///////////////////////////////////////////////////////////////
	 ///////////////////////////////////////////EXTENS TI3

	 /**
	  * 
	  * 
	  * 
	 */

	 public void addPetToNursery(){

	 	String answer = "";

	 	System.out.println("  ADD A PET TO THE NURSERY  ");

	 	System.out.print("Specie: ");
	 	String specie = reader.nextLine();

	 	System.out.print("Name: ");
	 	String name = reader.nextLine();

	 	System.out.print("Age: ");
	 	String age = reader.nextLine();

	 	System.out.print("Race (Dog or cat): ");
	 	String race = reader.nextLine();

	 	String symptoms = "Sano";

	 	System.out.println("\nEnter owner details: ");
	 	
	 	System.out.print("Name: ");
	 	String nameOwn = reader.nextLine();

	 	System.out.print("ID: ");
	 	String idOwn = reader.nextLine();

	 	System.out.print("Cellphone: ");
	 	String phoneOwn = reader.nextLine();
	 	
	 	System.out.print("Address: ");
	 	String addressOwn = reader.nextLine();
	 	System.out.println();

	 	answer = center.addPetToNursery()(specie, name, age, race, symptoms, Priority.CERO, Status.IN_NURSERY, nameOwn,
	 							idOwn, phoneOwn, addressOwn);

	 	System.out.println(answer);


	 }

	

	 


 
  













} 

