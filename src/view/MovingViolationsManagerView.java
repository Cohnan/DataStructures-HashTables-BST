package view;

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
		System.out.println("1. Consultar información asociada a un valor ObjectID");
		System.out.println("2. Consultar los ObjectID's en un rango dado");
		System.out.println("3. Cerrar programa - Terminar Ejecución");
		System.out.println("Digite el numero de opcion para ejecutar la tarea, luego presione enter: (Ej., 1):");
		
	}
	
	/**
	 * Imprime la informaciï¿½n sobre la carga de datos
	 * @param Arreglo Dinamico con la informacion de los datos cargados en cada mes
	 */
	public void printMovingViolationsLoadInfo(IArregloDinamico<Integer> resultados0) {
		int totalInfracciones = 0;
		int totalMeses = resultados0.darTamano();
		int infMes;
		System.out.println("  ----------Informaciï¿½n Sobre la Carga------------------  ");
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
			System.out.println("Infracción - Object ID - inválida");
		}else{
		System.out.println("Información sobre la infracción con ID: " + infraccion.getObjectId());
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
}
