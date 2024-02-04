package com.clases;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Escuela e = new Escuela();
		Scanner lector = new Scanner (System.in); 
		e.nuevoProfesor("Pepe", "1234", "Matematicas"); //PAL SERVLEEEEEEEEET
		e.nuevoProfesor("Juan", "1234", "Informatica");
		
		
		
		
		
		
		e.nuevoAlumno("Alicia", "2345");
		e.nuevoAlumno("Miguel", "2345");
		
		
	}
}