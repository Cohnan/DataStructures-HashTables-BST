package view;

import java.util.Iterator;

import model.data_structures.IArregloDinamico;
import model.vo.VOMovingViolation;

public class MovingViolationsManagerView 
{
	public MovingViolationsManagerView() {
		
	}
	
	public void printMenu() {
		System.out.println("---------ISIS 1206 - Estructuras de datos----------");
		System.out.println("---------------------Taller 7----------------------");
		System.out.println("0. Cargar datos de infracciones en movimiento");
		System.out.println("1. Consultar informaci�n asociada a un valor ObjectID");
		System.out.println("2. Consultar los ObjectID's en un rango dado");
		System.out.println("3. Cerrar programa - Terminar Ejecuci�n");
		System.out.println("Digite el numero de opcion para ejecutar la tarea, luego presione enter: (Ej., 1):");
		
	}
	
	/**
	 * Imprime la informaci�n sobre la carga de datos
	 * @param Arreglo Dinamico con la informacion de los datos cargados en cada mes
	 */
	public void printMovingViolationsLoadInfo(IArregloDinamico<Integer> resultados0) {
		int totalInfracciones = 0;
		int totalMeses = resultados0.darTamano();
		int infMes;
		System.out.println("  ----------Informaci�n Sobre la Carga------------------  ");
		for (int i = 0; i < totalMeses; i++) {
			infMes = resultados0.darObjeto(i);
			System.out.println("Infracciones Mes " + (i+1)+": " + infMes);
			totalInfracciones += infMes;
		}
		System.out.println("Total Infracciones Semestre: " + totalInfracciones);
	}
	/**
	 *Imprime el requerimiento 1 - TODO 
	 * @param TODO
	 */
	public void printMovingViolationsReq1(VOMovingViolation infraccion) {
		
		
		if(infraccion == null){
			System.out.println("Infracci�n - Object ID - inv�lida");
		}else{
		System.out.println("Informaci�n sobre la infracci�n con ID: " + infraccion.getObjectId());
		System.out.println("Location" + infraccion.getLocation());
		System.out.println("AddressID: "+infraccion.getAddressID());
		System.out.println("StreetSegID: " + infraccion.getStreetsegID());
		System.out.println("XCoord: " + infraccion.getXCoord());
		System.out.println("YCoord: " + infraccion.getYCoord());
		System.out.println("TicketIssueDate: "+ infraccion.getTicketIssueDate());
		}
	}

	public void printMessage(String mensaje) {
		System.out.println(mensaje);		
	}
	

	public void printMovingViolationsReq2(Iterable<VOMovingViolation> iterador) {
		int contador = 0;
		System.out.println("#"+"\t"+"ObjectID"+"\t"+"Location"+"\t"+"Address ID"+"\t"+"StreetSegID"+"\t"+"XCoord"+"\t"+"YCoord"+"\t"+"TicketIssueDate");
		for(VOMovingViolation s: iterador ){
		contador ++;
		System.out.println(contador+"."+"\t" + s.getObjectId() +"\t" + s.getLocation()+"\t" +s.getAddressID()+"\t" +s.getStreetsegID()+"\t" +s.getXCoord()+ "/t" +s.getYCoord()+ "\t" +s.getTicketIssueDate());
		}
	}
	
	
	
	
}
