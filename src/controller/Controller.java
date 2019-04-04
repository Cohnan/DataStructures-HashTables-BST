package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.Gson;

import model.data_structures.*;
import model.util.Sort;
import model.vo.VOMovingViolation;
import view.MovingViolationsManagerView;

public class Controller {

	/*
	 * Atributos
	 */
	public static final String[] movingViolationsFilePaths = new String[] {"data/Moving_Violations_Issued_in_January_2018.json", 
   	     "Moving_Violations_Issued_in_February_2018.json",
   	     "Moving_Violations_Issued_in_March_2018.json",
   	     "Moving_Violations_Issued_in_April_2018.json",
   	     "Moving_Violations_Issued_in_May_2018.json",
   	     "Moving_Violations_Issued_in_June_2018.json",
   	     "Moving_Violations_Issued_in_July_2018.json",
		 "Moving_Violations_Issued_in_August_2018.json",
		 "Moving_Violations_Issued_in_September_2018.json", 
		 "Moving_Violations_Issued_in_October_2018.json",
		 "Moving_Violations_Issued_in_November_2018.json",
		 "Moving_Violations_Issued_in_December_2018.json"
   	     };

	private static MovingViolationsManagerView view;

	private static int semestreCargado;

	private static ITablaSimOrd<Integer, VOMovingViolation> arbolBR;

	/*
	 * Constructor
	 */
	public Controller() {
		view = new MovingViolationsManagerView();

		arbolBR = null;
	}

	/*
	 * Metodos para requerimientos
	 */
	private static IArregloDinamico<Integer> loadMovingViolations(int n, ITablaSimOrd<Integer, VOMovingViolation>[] tablas) {
		return LoadMovingViolations.loadMovingViolations(n, tablas);
	}

	private Iterable<VOMovingViolation> requerimiento2Met(int min, int max) {

		return arbolBR.valuesInRange(min, max);

	}

	/*
	 * Ejecucion
	 */
	public void run() {

		Scanner sc = new Scanner(System.in);
		boolean fin = false;

		while(!fin)
		{
			view.printMenu();

			int option = sc.nextInt();

			switch(option)
			{
			case 0:
				// Cargar infracciones
				arbolBR = new BlancoRojoBST<Integer, VOMovingViolation>(); 
				view.printMovingViolationsLoadInfo(this.loadMovingViolations(1, new ITablaSimOrd[] {arbolBR}));
				semestreCargado = 1;
				break;

			case 1:
				// Requerimiento 1
				view.printMessage("ObjectID a buscar: ");
				VOMovingViolation aux = arbolBR.get(sc.nextInt());
				view.printMovingViolationsReq1(aux);
				break;

			case 2:
				//Requerimiento 2
				view.printMessage("Object ID menor: ");
				int menor = sc.nextInt();
				view.printMessage("Object ID mayor: ");
				int mayor = sc.nextInt();
				view.printMovingViolationsReq2(requerimiento2Met(menor, mayor));


			case 3:	
				fin=true;
				sc.close();
				break;
			}
		}
	}

	/*
	 * Metodos ayudantes
	 */
	/**
	 * Convertir fecha a un objeto LocalDate
	 * @param fecha fecha en formato dd/mm/aaaa con dd para dia, mm para mes y aaaa para agno
	 * @return objeto LD con fecha
	 */
	private static LocalDate convertirFecha(String fecha)
	{
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	/**
	 * Convertir fecha y hora a un objeto LocalDateTime
	 * @param fecha fecha en formato yyyy-MM-dd'T'HH:mm:ss'.000Z' con dd para dia, mm para mes y yyy para agno, HH para hora, mm para minutos y ss para segundos
	 * @return objeto LDT con fecha y hora integrados
	 */
	private static LocalDateTime convertirFecha_Hora_LDT(String fechaHora)
	{
		return LocalDateTime.parse(fechaHora, DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH:mm:ss"));

	}
	
	public static void main(String[] args) {
		// Calculos para el analisis pedido en el Taller
		arbolBR = new BlancoRojoBST<Integer, VOMovingViolation>(); 
		loadMovingViolations(1, new ITablaSimOrd[] {arbolBR});
		
		// Total nodos
		System.out.println("El numero total de nodos es: " + arbolBR.darTamano());
		
		// Altura del arbol
		System.out.println("La altura del arbol es: " + arbolBR.height());
		
		// Altura promedio
		float altProm = 0;
		for (Integer key : arbolBR) {
			altProm += arbolBR.getHeight(key);
		}
		
		altProm /= arbolBR.darTamano();
		System.out.println("La altura promedio del arbol es: " + altProm);
		
	}
}
