package Hundir_la_Flota;

import java.util.InputMismatchException;
import java.util.Scanner;

/* AUTOR: FERNANDO LABRADOR GARC�A */

public class Tablero_del_Juego {

	//DECLARAMOS LOS ATRIBUTOS NECESARIOS PARA REALIZAR EL JUEGO DE UNDIR LA FLOTA
	
	protected static int fila = 10;
	protected static int columna = 10;
	protected static int posicionBarcoFila;
	protected static int posicionBarcoColumna;
	protected static int barcoTocado;
	protected static int numeroDisparos;
	protected static int numeroIntentos;
	protected static int numeroBarcos;
	protected static int numeroLanchas;
	protected static int numeroBuques;
	protected static int numeroAcorazados;
	protected static int numeroPortaaviones;
	protected static int filaBarco;
	protected static int columnaBarco;
	protected static boolean error = true;
	protected static char tableroJuego [][];
	
	/* 
	 * M�TODO VOID PARA PEDIR EL TAMA�O DEL TABLERO CUANDO ELEGIMOS EL NIVEL PERSONALIZADO.
	 * DE ESTA FORMA, PODEMOS DARLE EL TAMA�O QUE DESEEMOS.
	 * 
	 * DEBEREMOS DE PEDIR EL N�MERO DE POSICIONES DE LA COLUMNA Y LA FILA.
	 * 
	 */
	public static void pedirTamañoTableroPersonalizado(Scanner console) {
		
		System.out.println("Para comenzar con el juego, deber� introducir el tama�o del tablero "
						+ "(N� de posiciones de columna y filas).\n");
		
		error = true;
		
		while (error) {
			
			try {
				
				error = false;
				System.out.print("Columna: ");
				columna = console.nextInt();
				
			} catch (InputMismatchException e) {
				
				System.err.println("\nEl caracter introducido no es v�lido. Comience de nuevo:\n");
				console.next();
				error = true;
			}
		}

		error = true;
		
		while (error) {
			
			try {
				
				error = false;
				System.out.print("Fila: ");
				fila = console.nextInt();
				
			} catch (InputMismatchException e) {
				
				System.err.println("\nEl caracter introducido no es v�lido. Comience de nuevo:\n");
				console.next();
				error = true;
			}
		}
	}
	
	/* 
	 * M�TODO PARA PEDIR EL N�MERO DE BARCOS DE CADA TIPO CUANDO ELEGIMOS EL NIVEL PERSONALIZADO.
	 * AS�, PODEMOS ELEGIR QUE BARCOS Y CUANTOS QUEREMOS PARA JUGAR.
	 *
	 */
	public static void pedirBarcosTableroPersonalizado(Scanner console) {
		
		System.out.println("\nA continuaci�n, introduzca el n�mero de cada tipo de barco.\n");
		
		error = true;
		
		while (error) {
			
			try {
				
				error = false;
				System.out.print("Lanchas: ");
				numeroLanchas = console.nextInt();
				
			} catch (InputMismatchException e) {
				
				System.err.println("\nEl caracter introducido no es v�lido. Comience de nuevo:\n");
				console.next();
				error = true;
			}
		}

		error = true;
		
		while (error) {
			
			try {
				
				error = false;
				System.out.print("Buques: ");
				numeroBuques = console.nextInt();
				
			} catch (InputMismatchException e) {
				
				System.err.println("\nEl caracter introducido no es v�lido. Comience de nuevo:\n");
				console.next();
				error = true;
			}
		}
	
		error = true;
		
		while (error) {
			
			try {
				
				error = false;
				System.out.print("Acorazados: ");
				numeroAcorazados = console.nextInt();
				
			} catch (InputMismatchException e) {
				
				System.err.println("\nEl caracter introducido no es v�lido. Comience de nuevo:\n");
				console.next();
				error = true;
			}
		}
		
		error = true;
		
		while (error) {
			
			try {
				
				error = false;
				System.out.print("Portaaviones: ");
				numeroPortaaviones = console.nextInt();
				
			} catch (InputMismatchException e) {
				
				System.err.println("\nEl caracter introducido no es v�lido. Comience de nuevo:\n");
				console.next();
				error = true;
			}
		}
	}
	
	/* 
	 * M�TODO PARA PEDIR EL N�MERO DE DISPAROS QUE PODEMOS REALIZAR CUANDO ELEGIMOS EL NIVEL PERSONALIZADO.
	 * DE ESTA MANERA PODEMOS COMPLICARLO M�S O MENOS.
	 *
	 */
	public static void pedirNumeroDisparosTableroPersonalizado(Scanner console) {
		
		error = true;
		
		while (error) {
			
			try {
				
				error = false;
				System.out.print("\nY, por �ltimo, introduzca el n�mero de disparos: ");
				numeroIntentos = console.nextInt();
				
			} catch (InputMismatchException e) {
				
				System.err.println("\nEl caracter introducido no es v�lido. Comience de nuevo:\n");
				console.next();
				error = true;
			}
			
		}
		System.out.println();
	}
	
	/*
	 * M�TODO EN EL CUAL VAMOS A INSERTAR EL N�MERO DE POSICIONES QUE TENDRA NUESTYRO TABLERO.
	 * DE MANERA INICIAL TENEMOS 10 DE COLUMNA Y 10 DE FILA. ESTAS POSICIONES SER�N MARCADAS CON UN GUI�N '-'
	 * QUE REPRESENTA EL AGUA DONDE ESTAR�N LOS BARCOS.
	 * 
	 */
	public static void crearTablero() {

		tableroJuego = new char [columna][fila];
		
		for (int x = 0; x < columna; x++) {
			
			for (int y = 0; y < fila; y++) {
				tableroJuego[x][y] = '-';

			}
		}
		
	}
	
	/*
	 * M�TODO DONDE MOSTRAREMOS EL TABLERO DE REFERENCIA EN EL QUE EL USUARIO PODR� VER LOS BARCOS Y
	 * EN QUE POSICIONES SE ENCUENTRAN (ESTO ES SOLO DE PRUEBA).
	 * 
	 */
	public static void mostrarTableroReferencia() {
		
		//Variables
		char letrasTablero = 'A';
	
		System.out.print("\n+-+ TABLERO REFERENCIA +-+\n\n");
		System.out.print("    ");
		for (int x = 0; x < columna; x++) {
			
			if (x <= 10) {
				
				System.out.print("   " + x);
				
			} else if (x > 10) {
				 
				System.out.print("  " + x);
			}
		}
			
		System.out.println();
		for (int i = 0; i < fila; i++) {
					
			if (i < 10) {
				
				System.out.print((letrasTablero + "(" + (i) + ")" + "   "));
				letrasTablero++;
			} else {
				
				System.out.print((letrasTablero + "(" + (i) + ")" + "  "));
				letrasTablero++;
			}
					
			for (int j = 0; j < columna; j++) {
				System.out.print(tableroJuego[j][i] + "   ");
			}
			System.out.println();
		}
			
	}
	
	/*
	 * M�TODO EN EL CUAL MOSTRAMOS EL TABLERO EN EL QUE EL JUGADOR INTERACTUA.
	 * LOS BARCOS ESTARAN OCULTOS.
	 */
	public static void mostrarTableroJuego() {
		
		//Variables
		char letrasTablero = 'A';
	
		System.out.print("\n\n+-+ TABLERO JUEGO +-+\n\n");
		System.out.print("    ");
		for (int x = 0; x < columna; x++) {
			
			if (x <= 10) {
				
				System.out.print("   " + x);
				
			} else if (x > 10) {
				 
				System.out.print("  " + x);
			}
		}
			
		System.out.println();
		for (int i = 0; i < fila; i++) {
			
			if (i < 10) {
				
				System.out.print((letrasTablero + "(" + (i) + ")" + "   "));
				letrasTablero++;
			} else {
				
				System.out.print((letrasTablero + "(" + (i) + ")" + "  "));
				letrasTablero++;
			}

					
			for (int j = 0; j < columna; j++) {
			    
			    if(tableroJuego[j][i] != '-' && tableroJuego[j][i] != 'A' && tableroJuego[j][i] != 'X') {
			    	
			        System.out.print("-   ");
			        
			    } else {
			    	
			    System.out.print(tableroJuego[j][i] + "   ");
			    
			    }
			}
			System.out.println();
		}
	}
	
	/*
	 * M�TODO DONDE NOS IR� DANDO DIFERENTES POSICIONES DE COLUMNA/FILA.
	 */
	public static void posicionesAleatorias() {
		
		do {
			
			posicionBarcoFila = (int) Math.round(Math.random() * (fila -1));
			posicionBarcoColumna = (int) Math.round(Math.random() * (columna -1));
			
		} while (tableroJuego[posicionBarcoColumna][posicionBarcoFila] !='-');
	}
	
	/*
	 * M�TODO EN EL QUE COMPROBAMOS EL SOLAPAMIENTO DE LOS BARCOS.
	 * 
	 * PARA ELLO LO QUE HACEMOS ES MEDIANTE UNAS CONDCIONES Y BUCLES COMPROBAR
	 * QUE CUANDO NOS DE UNA POSICI�N ALEATORIA NO COINCIDA CON QUE HAYA UN BARCO.
	 * 
	 * TAMBI�N DIFERENCIAMOS MEDIANTE UN STRING QUE TIPO DE BARCO ES. 
	 */
	public static boolean comprobarSolapamientoBarcos(String tipoBarco) {
		
		//Variables
		boolean repetir = true;
		
		if (tipoBarco.equals("Lancha")) {
			
			do {
				posicionesAleatorias();
				
			} while (posicionBarcoColumna > (columna-1));
			
				for (int i = 0; i < 1; i++) {
					
					if (tableroJuego[posicionBarcoColumna][posicionBarcoFila] !='-') {
						
						repetir = false;
						break;
						
					} 
				}
				return repetir;
				
		} else if (tipoBarco.equals("Buque")) {
			
			do {
				posicionesAleatorias();
				
			} while (posicionBarcoColumna > (columna-3));
			
				for (int i = 0; i < 3; i++) {
					
					if (tableroJuego[posicionBarcoColumna + i][posicionBarcoFila] !='-') {
						
						repetir = false;
						break;
						
					} 
				}
				return repetir;
			
		} else if (tipoBarco.equals("Acorazado")) {
			
			do {
				posicionesAleatorias();
				
			} while (posicionBarcoColumna > (columna-4));
			
				for (int i = 0; i < 4; i++) {
					
					if (tableroJuego[posicionBarcoColumna + i][posicionBarcoFila] !='-') {
						
						repetir = false;
						break;
						
					} 
				}
				return repetir;
			
		} else {
			
			do {
				posicionesAleatorias();
				
			} while (posicionBarcoFila > (fila-5));
			
				for (int i = 0; i < 5; i++) {
					
					if (tableroJuego[posicionBarcoColumna][posicionBarcoFila + i] !='-') {
						
						repetir = false;
						break;
						
					} 
				}
				return repetir;
		}
	}
	
	/*
	 * M�TODO DONDE MEDIANTE UN MEN� DIFERENCIAMOS EL TIPO DE BARCO QUE QUEREMOS, Y UTILIZANDO
	 * EL M�TODO PARA COMPROBAR EL SOLAPAMIENTO PODREMOS IR INSERTANDO LOS BARCOS EN LAS POSICIONES CORRESPONDIENTES
	 * Y QUE NUNCA SE NOS SOLAPEN.
	 */
	public static void introducirBarcos(String tipoBarco) {
		
		switch(tipoBarco) {
		
			case "Lancha": 
	
					posicionesAleatorias();
					
					tableroJuego[posicionBarcoColumna][posicionBarcoFila] ='L';
	
					break;
					
			case "Buque":
				
				do {
					posicionesAleatorias();
					
				} while(!(comprobarSolapamientoBarcos("Buque")));
				
					for (int i = 0; i < 3; i++) {
						
						tableroJuego[posicionBarcoColumna + i][posicionBarcoFila] ='B';
					}
	
					break;
					
			case "Acorazado":
				
				do {
					posicionesAleatorias();
					
				} while(!(comprobarSolapamientoBarcos("Acorazado")));
				
					for (int i = 0; i < 4; i++) {
						
						tableroJuego[posicionBarcoColumna + i][posicionBarcoFila] ='Z';
					}
				
					break;
					
			case "Portaaviones":
				
				do {
					posicionesAleatorias();
					
				} while(!(comprobarSolapamientoBarcos("Portaaviones")));
				
					for (int i = 0; i < 5; i++) {
						
						tableroJuego[posicionBarcoColumna][posicionBarcoFila + i] ='P';
					}
					
					break;
			}
		}
	
	/*
	 * M�TODO DONDE PEDIREMOS EN QUE POSCIONES COLUMNA/FILA VAMOS A DISPARAR.
	 * 
	 * EN EL CASO QUE TOQUEMOS '-', NOS DIR� QUE HEMOS DISPARADO EN EL AGUA Y SE MARCAR� COMO 'A'
	 * Y EN EL CASO QUE TOQUEMOS 'L, B, Z, P' (LOS RESPECTIVOS BARCOS), NOS DIR� QUE HEMOS DISPARADO
	 * EN UN BARCO Y SE MARCAR� COMO 'X'.
	 */
	public static String dispararBarcos(Scanner console) {
		
		System.out.println("\nA continuaci�n, dispararemos a los barcos que se encuentran ocultos.");
		
		error = true;
		
		while (error) {
			
			try {
				
				error = false;
				System.out.print("\nSelecciona la posici�n de la columna (x): ");
				columnaBarco = console.nextInt();
				
				while (columnaBarco > columna) {
					
					System.out.println("\nLa posici�n seleccionada no est� dentro del rango permitido para este tablero.");
					System.out.print("Selecciona la posici�n de la columna (x): ");
					columnaBarco = console.nextInt();
				}
				
			} catch (InputMismatchException e) {
				
				System.err.println("\nEl caracter introducido no es v�lido. Comience de nuevo:");
				console.next();
				error = true;
			}
		}
		
		error = true;
		
		while (error) {
			
			try {
				
				error = false;
				System.out.print("Selecciona la posici�n de la fila (y): ");
				filaBarco = console.nextInt();
				
				while (filaBarco > fila) {
					
					System.out.println("\nLa posici�n seleccionada no est� dentro del rango permitido para este tablero.");
					System.out.print("Selecciona la posici�n de la fila (y): ");
					filaBarco = console.nextInt();
				}
				
			} catch (InputMismatchException e) {
				
				System.err.println("\nEl caracter introducido no es v�lido. Comience de nuevo:");
				console.next();
				error = true;
			}
		}

		if (tableroJuego[columnaBarco][filaBarco] =='-') {
			
			tableroJuego[columnaBarco][filaBarco] ='A';
			return "\n!Agua�\n";
			
		} else if (tableroJuego[columnaBarco][filaBarco] !='-' && tableroJuego[columnaBarco][filaBarco] !='A' && tableroJuego[columnaBarco][filaBarco] !='X') {
			
			tableroJuego[columnaBarco][filaBarco] ='X';
			barcoTocado++;
			return "\n!Tocado�\n";
			
		} else {
			
			return "\nYa habias disparado anteriormente en esta posici�n :D\n";
			
		}
	}
}