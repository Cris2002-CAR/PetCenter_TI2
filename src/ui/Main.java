package ui;

import java.util.Scanner;

import model.PetCenter;

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
	Global data type boolean to close the menu with the condition required by the program.
	*/
	private boolean continued = true;

	public static void main (String[] args){

		Main obj = new Main();
		obj.Menu();

	 }

	 /**
	 *In this method the user will be able to enter a menu, where he must choose what to do in the program.
	 *The global boolean variable is used to close the program when the user is able to do so.
	 */
	 public void Menu(){

	 	int option;
	 	
	 	center = new PetCenter();
	 	while(continued){

	 		option = Integer.parseInt(JOptionPane.showInputDialog("Menu"
	 			+"\n1. Agregar un veterinario"
	 			+"\n2. Eliminar veterinario"
	 			+"\n3. Registrar una mascota"
	 			+"\n4. Retirar una mascota"
	 			+"\n5. Iniciar una consulta"
	 			+"\n6. Finalizar una consulta"
	 			+"\n7. Mostras el numero de mascostas que no han sido atendidas"
	 			+"\n8. Terminar el dia"));

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

	 			case 8:
	 			System.out.println("___________________________________________________________________________");
	 			endDayReports();
	 			break;

	 		}
	 	}
	 }

	 /**
	 *This method allows the user to add a veterinarian
	 *The relationship center is used to pass the veterinarian's data
	 */
	 public void addVeterinary(){

	 	System.out.println("Por favor ingrese la informacion personal del veterinario: ");
 
	 	System.out.print("Cedula: ");
	 	String id = reader.nextLine();

	 	System.out.print("Nombre: ");
	 	String name = reader.nextLine();

	 	System.out.print("Apellido: ");
	 	String lastname = reader.nextLine();

	 	System.out.print("Numero unico del veterinario: ");
	 	String uniqueNumber = reader.nextLine();

	 	boolean saved = center.addVeterinary(id, name, lastname, uniqueNumber);
	 	
	 	if(saved){
	 		System.out.println("El veterinario ha sido agregado exitosamente\n");
	 	}
	 	else{
	 		System.out.println("Se ha sobrepasado el numero de veterinarios permitidos\n");
	 	}

	 }

	 /**
	 *This method will allow the user to delete a veterinarian if the conditions for doing so are met.
	 *The center relationship is used to pass the unique number of the veterinarian, which will be used to eliminate the veterinarian.
	 */
	 public void deleteVeterinary(){

	 	System.out.println("Por favor ingrese el numero unico del veterinario que desea eliminar: ");

	 	String uniqueNumber = reader.nextLine();

	 	center.deleteVeterinary(uniqueNumber);
	 	
	 }

	 /**
	 *This method allows the user to register a pet and its owner.
	 *The center relationship is used to pass all the owner and pet data, and create the object
	 */
	 public void addPetandOwner(){

	 	System.out.println("Por favor ingrese los datos de la mascota que desea agregar: ");

	 	System.out.print("Especie: ");
	 	String specie = reader.nextLine();

	 	System.out.print("Nombre: ");
	 	String name = reader.nextLine();

	 	System.out.print("Edad: ");
	 	String age = reader.nextLine();

	 	System.out.print("Raza (Si es perro o gato): ");
	 	String race = reader.nextLine();

	 	System.out.print("Sintomas: ");
	 	String symptoms = reader.nextLine();

	 	System.out.println("Ingrese los datos del dueno: ");
	 	
	 	System.out.print("Nombre: ");
	 	String nameOwn = reader.nextLine();

	 	System.out.print("Cedula: ");
	 	String idOwn = reader.nextLine();

	 	System.out.print("Celular: ");
	 	String phoneOwn = reader.nextLine();
	 	
	 	System.out.print("Direccion: ");
	 	String addressOwn = reader.nextLine();
	 	System.out.println();
	 		 	

	 	System.out.println("Seleccione la prioridad en la que la mascota debe ser atendida: "
	 		+"\n1: Roja"
	 		+"\n2: Naranja"
	 		+"\n3: Amarrila"
	 		+"\n4: Verde"
	 		+"\n5: Azul");

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
	 		
	 	}
	 	if(saved){
	 		System.out.println("La mascota se ha registrado exitosamente\n");
	 	}
	 	else{
	 		System.out.println("No se ha podido registrar la mascota por que se ha excedido el numero permitido\n");
	 	}

	 }

	 /**
	 *This method will allow the user to take a pet out of the center. 
	 *The center relation sends the data to the class method of the model and removes the pet.
	 */
	 public void removePet(){

	 	System.out.println("Por favor ingrese el nombre de la mascota: ");
	 	String name = reader.nextLine();

	 	System.out.println("Por favor ingrese el nombre del dueno: ");
	 	String nameOwn = reader.nextLine();	 	

	 	center.removePet(name, nameOwn);

	 }

	 /**
	 *This method allows the user to initiate a veterinary consultation.
	 *The relationship center is used to send the id of the veterinarian who will do the consultation.	
	 */
	 public void startConsultation(){

	 	System.out.print("Por favor ingrese el cedula del veterinario: ");
	 	String id = reader.nextLine();

	 	center.startConsultation(id);

	 }

	 /**
	 *This method allows to finalize a veterinary consultation previously started.
	 *The relationship center is used to send the veterinarian and pet data to the method that completes the consultation.
	 */
	 public void endConsultation(){

	 	System.out.print("Por favor ingrese la cedula del veterinario: ");
	 	String id = reader.nextLine();

	 	System.out.print("Por favor ingrese el nombre de la mascota: ");
	 	String namePet = reader.nextLine();

	 	System.out.println("Por favor indique con que estado sale la mascota: "
	 		+"\n1. Salida autorizada"
	 		+"\n2. Hospitalizacion");

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
	 		System.out.print("ERROR. opcion invalida");
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

	 		System.out.print("Todavia hay mascotas por atender");
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

	 	System.out.println("El numero de mascotas que no han sido atendidas es: "+center.notAttendedPets());
	 }

	 /**
	 *This method obtains the veterinarian with the most consultations.
	 *The relationship center gets the veterinarian by calling the method
	 */
	 public void veterinaryMostAttendPets(){

	 	System.out.println("El veterinario con mayor numero de consultas es: "+center.veterinaryMostAttendPets());
	 }

	 /**
	 *This method counts each pet by priority
	 *The center relation is used to call a method and assign it to an array to display the data.
	 */
	 public void attendsPetsForPriority(){

	 	int priorities[] = center.attendsPetsForPriority();

	 	System.out.println("Hay "+priorities[0]+" mascotas con prioridad roja");
	 	System.out.println("Hay "+priorities[1]+" mascotas con prioridad naranja");
	 	System.out.println("Hay "+priorities[2]+" mascotas con prioridad amarrila");
	 	System.out.println("Hay "+priorities[3]+" mascotas con prioridad verde");
	 	System.out.println("Hay "+priorities[4]+" mascotas con prioridad azul");
	 }

	 /**
	 *This method calculates the percentage of pets that left without being attended by a veterinarian.
	 *The center relation is used to call the method that calculates the percentage and displays it to the user.
	 */
	 public void notAttendPercentage(){

	 	System.out.println("El porcentaje de mascotas que salieron sin ser atendidas es: "+center.notAttendPercentage()+"%");
	 }

	 /**
	 *This method takes care of eliminating all pets once the day is over.
	 *The relationship center is used to call the method that is in charge of eliminating all pets.
	 */
	 public void deleteAttendedPets(){

	 	center.deleteAttendedPets();
	 	System.out.println("Todas las mascotas atendidas han sido eliminadas");
	 }

	

	 


 
  













} 

