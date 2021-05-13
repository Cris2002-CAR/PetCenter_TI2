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
	
	*/
	private PetCenter center;

	/**
	
	*/
	private boolean continued = true;

	public static void main (String[] args){

		Main obj = new Main();
		obj.Menu();

	 }

	 /**
	 *In this method the user will be able to enter a menu, where he must choose what to do in the program.
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

	 			case 9:
	 			mostrarVeterinarios();
	 			break;

	 			case 10:
	 			mostrarMascotas();
	 			break;
	 		}
	 	}
	 }

	 /**
	 *This method allows the user to add a veterinarian
	 *
	 *@param
	 *@return 
	 */

	 public void addVeterinary(){

	 	System.out.println("Por favor ingrese la informacion personal del veterinario: ");
 
	 	System.out.print("Cedula: ");
	 	String id = reader.nextLine();
	 	reader.nextLine();

	 	System.out.print("Nombre: ");
	 	String name = reader.nextLine();
	 	reader.nextLine();

	 	System.out.print("Apellido: ");
	 	String lastname = reader.nextLine();
	 	reader.nextLine();

	 	System.out.print("Numero unico del veterinario: ");
	 	String uniqueNumber = reader.nextLine();
	 	reader.nextLine();

	 	boolean saved = center.addVeterinary(id, name, lastname, uniqueNumber);
	 	
	 	if(saved){
	 		System.out.println("El veterinario ha sido agregado exitosamente\n");
	 	}
	 	else{
	 		System.out.println("Se ha sobrepasado el numero de veterinarios permitidos\n");
	 	}

	 }

	 /**
	 *
	 */

	 public void deleteVeterinary(){

	 	System.out.println("Por favor ingrese el numero unico del veterinario que desea eliminar: ");

	 	String uniqueNumber = reader.nextLine();
	 	reader.nextLine();

	 	center.deleteVeterinary(uniqueNumber);
	 	
	 }

	 /**
	 *
	 */

	 public void addPetandOwner(){

	 	System.out.println("Por favor ingrese los datos de la mascota que desea agregar: ");

	 	System.out.print("Especie: ");
	 	String specie = reader.nextLine();
	 	reader.nextLine();

	 	System.out.print("Nombre: ");
	 	String name = reader.nextLine();
	 	reader.nextLine();

	 	System.out.print("Edad: ");
	 	String age = reader.nextLine();
	 	reader.nextLine();

	 	System.out.print("Raza (Si es perro o gato): ");
	 	String race = reader.nextLine();
	 	reader.nextLine();

	 	System.out.print("Sintomas: ");
	 	String symptoms = reader.nextLine();
	 	reader.nextLine();

	 	System.out.println("Ingrese los datos del dueno: ");
	 	
	 	System.out.print("Nombre: ");
	 	String nameOwn = reader.nextLine();
	 	reader.nextLine();

	 	System.out.print("Cedula: ");
	 	String idOwn = reader.nextLine();
	 	reader.nextLine();

	 	System.out.print("Celular: ");
	 	String phoneOwn = reader.nextLine();
	 	reader.nextLine();
	 	
	 	System.out.print("Direccion: ");
	 	String addressOwn = reader.nextLine();
	 	reader.nextLine();
	 		 	

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
	 *
	 */

	 public void removePet(){

	 	System.out.println("Por favor ingrese el nombre de la mascota: ");
	 	String name = reader.nextLine();
	 	reader.nextLine();

	 	System.out.println("Por favor ingrese el nombre del dueno: ");
	 	String nameOwn = reader.nextLine();
	 	reader.nextLine();
	 	

	 	center.removePet(name, nameOwn);

	 }

	 /**
	 */

	 public void startConsultation(){

	 	System.out.println("Por favor ingrese el cedula del veterinario: ");
	 	String id = reader.nextLine();
	 	reader.nextLine();

	 	center.startConsultation(id);

	 }

	 /**
	 */

	 public void endConsultation(){

	 	System.out.println("Por favor ingrese la cedula del veterinario: ");
	 	String id = reader.nextLine();
	 	reader.nextLine();

	 	System.out.println("Por favor ingrese el nombre de la mascota: ");
	 	String namePet = reader.nextLine();
	 	reader.nextLine();

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

	 public void notAttendedPets(){

	 	System.out.println("El numero de mascotas que no han sido atendidas es: "+center.notAttendedPets());
	 }

	 public void veterinaryMostAttendPets(){

	 	System.out.println("El veterinario con mayor numero de consultas es: "+center.veterinaryMostAttendPets());
	 }

	 public void attendsPetsForPriority(){

	 	int priorities[] = center.attendsPetsForPriority();

	 	System.out.println("Hay "+priorities[0]+" mascotas con prioridad roja");
	 	System.out.println("Hay "+priorities[1]+" mascotas con prioridad naranja");
	 	System.out.println("Hay "+priorities[2]+" mascotas con prioridad amarrila");
	 	System.out.println("Hay "+priorities[3]+" mascotas con prioridad verde");
	 	System.out.println("Hay "+priorities[4]+" mascotas con prioridad azul");
	 }

	 public void notAttendPercentage(){

	 	System.out.println("El porcentaje de mascotas que salieron sin ser atendidas es: "+center.notAttendPercentage()+"%");
	 }

	 public void deleteAttendedPets(){

	 	center.deleteAttendedPets();
	 	System.out.println("Todas las mascotas atendidas han sido eliminadas");
	 }

	 public void mostrarVeterinarios(){

	 	center.mostrarVeterinarios();
	 }

	 public void mostrarMascotas(){

	 	center.mostrarMascotas();
	 }

	 


 
  













} 

