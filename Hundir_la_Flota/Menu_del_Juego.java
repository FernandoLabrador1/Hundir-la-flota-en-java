package Hundir_la_Flota;

import java.util.Scanner;

/* AUTOR: FERNANDO LABRADOR GARC�A */

public class Menu_del_Juego {

   /* 
    * CLASE MAIN EN LA CUAL ALMACENAMOS EL MEN� CON SUS DIVERSAS OPCIONES:
    * (F�CIL, MEDIO, DIF�CIL, PERSONALIZADO Y SALIR)
	* 
	* EL USUARIO DEBER� DE ELEGIR UNA DE LAS OPCIONES MENCIONADAS E
	* INTENTAR� HUNDIR TODOS LOS BARCOS ANTES DE QUE SE LE ACABEN LOS DISPAROS.
	* 
	* - NIVEL F�CIL CONSTA DE 10 BARCOS (5 LANCHAS, 3 BUQUES, I ACORAZADO Y 1 PORTAAVIONES)
	* 	Y DE 50 DISPAROS.
	* 
	* - NIVEL MEDIO CONSTA DE 5 BARCOS (2 LANCHAS, 1 BUQUE, 1 ACORAZADO Y 1 PORTAAVIONES)
	* 	Y DE 30 DISPAROS.
	* 
	* - NIVEL DIF�CIL CONSTA DE 2 BARCOS (1 LANCHA Y 1 BUQUE)
	* 	Y DE 10 DISPAROS
	* 
	* - NIVEL PERSONALIZADO, EL USUARIO ELIGE EL TAMA�O DEL TABLERO,
	*   EL N�MERO DE BARCOS DE CADA TIPO Y EL N�MERO DE DISPAROS.
	* 
	* NOTA: "EN EL NIVEL PERSONALIZADO NO HACER UN TABLERO MUY PEQUE�O E INTRODUCIR MUCHOS BARCOS, 
	* 		 NO FUNCIONAR� DEBIDO A QUE SUPERAR� EL N�MERO DE POSICIONES DEL TABLERO".
	* 
	*/
 	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		//Variables
		char opcion;
		boolean cerrar = true;
		
		while (cerrar) {
			
			System.out.println("|=== Hundir la flota ===|\n");
			System.out.print("Elija el nivel de dificultad:\n"
					+ "\n1. Fácil"
					+ "\n2. Medio"
					+ "\n3. Dif�cil"
					+ "\n4. Personalizado"
					+ "\n5. Salir"
					+ "\n\nOpci�n ---> ");
			opcion = Character.toLowerCase(console.next().charAt(0));
			
			switch (opcion) {
			
				case '1': System.out.println("\nNivel F�cil\n");
				
						Tablero_del_Juego.crearTablero();
						
						for (int i = 0; i < 5; i++) {
							
							Tablero_del_Juego.introducirBarcos("Lancha");
						}
						
						for (int i = 0; i < 3; i++) {
							
							Tablero_del_Juego.introducirBarcos("Buque");
						}
						
						Tablero_del_Juego.introducirBarcos("Acorazado");
						Tablero_del_Juego.introducirBarcos("Portaaviones");
						
						for (int i = 0; i < 50; i++) {
							
							Tablero_del_Juego.mostrarTableroReferencia();
							Tablero_del_Juego.mostrarTableroJuego();
							System.out.println(Tablero_del_Juego.dispararBarcos(console));
							Tablero_del_Juego.numeroDisparos++;
							
							if (Tablero_del_Juego.barcoTocado == 23) {
								
								Tablero_del_Juego.mostrarTableroReferencia();
								Tablero_del_Juego.mostrarTableroJuego();
								System.out.println("\nENHORABUENA!!!. Has logrado destruir todos los barcos.\n");
								break;
								
							} else if (Tablero_del_Juego.numeroDisparos == 50) {
								
								System.out.println("DERROTA!!!. Superaste el n�mero de disparos.\n");
							}
							
						}
						
						break;
						
				case '2': System.out.println("\nNivel Medio\n");
				
						Tablero_del_Juego.crearTablero();
						
						for (int i = 0; i < 2; i++) {
							
							Tablero_del_Juego.introducirBarcos("Lancha");
						}
						
						Tablero_del_Juego.introducirBarcos("Buque");
						Tablero_del_Juego.introducirBarcos("Acorazado");
						Tablero_del_Juego.introducirBarcos("Portaaviones");
						
						for (int i = 0; i < 30; i++) {
							
							Tablero_del_Juego.mostrarTableroReferencia();
							Tablero_del_Juego.mostrarTableroJuego();
							System.out.println(Tablero_del_Juego.dispararBarcos(console));
							Tablero_del_Juego.numeroDisparos++;
							
							if (Tablero_del_Juego.barcoTocado == 14) {
								
								Tablero_del_Juego.mostrarTableroReferencia();
								Tablero_del_Juego.mostrarTableroJuego();
								System.out.println("\nENHORABUENA!!!. Has logrado destruir todos los barcos.\n");
								break;
								
							} else if (Tablero_del_Juego.numeroDisparos == 30) {
								
								System.out.println("DERROTA!!!. Superaste el n�mero de disparos.\n");
							}
						}
						
						break;
						
				case '3': System.out.println("\nNivel Dif�cil\n");
				
						Tablero_del_Juego.crearTablero();
								
						Tablero_del_Juego.introducirBarcos("Lancha");
						Tablero_del_Juego.introducirBarcos("Buque");
						
						for (int i = 0; i < 10; i++) {
							
							Tablero_del_Juego.mostrarTableroReferencia();
							Tablero_del_Juego.mostrarTableroJuego();
							System.out.println(Tablero_del_Juego.dispararBarcos(console));
							Tablero_del_Juego.numeroDisparos++;
							
							if (Tablero_del_Juego.barcoTocado == 4) {
								
								Tablero_del_Juego.mostrarTableroReferencia();
								Tablero_del_Juego.mostrarTableroJuego();
								System.out.println("\nENHORABUENA!!!. Has logrado destruir todos los barcos.\n");
								break;
								
							} else if (Tablero_del_Juego.numeroDisparos == 10) {
								
								System.out.println("DERROTA!!!. Superaste el n�mero de disparos.\n");
							}
						}
						
						break;
						
				case '4': System.out.println("\nNivel Personalizado\n");
				
						Tablero_del_Juego.pedirTamañoTableroPersonalizado(console);
						Tablero_del_Juego.pedirBarcosTableroPersonalizado(console);
						Tablero_del_Juego.pedirNumeroDisparosTableroPersonalizado(console);
						
						Tablero_del_Juego.crearTablero();
						
						for (int i = 0; i < Tablero_del_Juego.numeroPortaaviones; i++) {
							
							Tablero_del_Juego.introducirBarcos("Portaaviones");
						}
						
						for (int i = 0; i < Tablero_del_Juego.numeroAcorazados; i++) {
							
							Tablero_del_Juego.introducirBarcos("Acorazado");
						}
						
						for (int i = 0; i < Tablero_del_Juego.numeroBuques; i++) {
							
							Tablero_del_Juego.introducirBarcos("Buque");
						}
						
						for (int i = 0; i < Tablero_del_Juego.numeroLanchas; i++) {
							
							Tablero_del_Juego.introducirBarcos("Lancha");
						}
						
						Tablero_del_Juego.numeroBarcos = Tablero_del_Juego.numeroLanchas + Tablero_del_Juego.numeroBuques + Tablero_del_Juego.numeroAcorazados + Tablero_del_Juego.numeroPortaaviones;
						
						for (int i = 0; i < Tablero_del_Juego.numeroIntentos; i++) {
							
							Tablero_del_Juego.mostrarTableroReferencia();
							Tablero_del_Juego.mostrarTableroJuego();
							System.out.println(Tablero_del_Juego.dispararBarcos(console));
							Tablero_del_Juego.numeroDisparos++;
							
							if (Tablero_del_Juego.barcoTocado == Tablero_del_Juego.numeroBarcos) {
								
								Tablero_del_Juego.mostrarTableroReferencia();
								Tablero_del_Juego.mostrarTableroJuego();
								System.out.println("\nENHORABUENA!!!. Has logrado destruir todos los barcos.\n");
								break;
								
							} else if (Tablero_del_Juego.numeroIntentos == i+1) {
								
								System.out.println("DERROTA!!!. Superaste el n�mero de disparos.\n");
							}
						}
						
						break;
						
				case '5': System.out.println("\n�Est�s seguro de que quieres cerrar el men�?");
				
						System.out.println("(S / N)");
						System.out.print("\n---> ");
						char S = Character.toUpperCase(console.next().charAt(0));
						
						if (S == 'S') {
							System.out.println("\nHasta luego !!!!");
							cerrar = false;
						}
						
						System.out.println();
						
						break;
						
				default: System.out.println("\nEl valor introducido no est� dentro del rango establecido."
						 + "\nPor favor, las opciones del men� son del 1 al 4.\n");
				
						break;
			}
		}
 	}
}
