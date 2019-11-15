import java.util.Arrays;

public class Hash {
	
	// Atributos
	String [] arreglo;
	int size, cont;
	
	// M�todo constructor
	public Hash(int tam) {
		
		size = tam;
		arreglo = new String[tam];
		Arrays.fill(arreglo, "-1");
		
	}
	
	// M�todo para la funci�n hash
	public void funcionHash(String[] cadenaArreglo, String[] arreglo) {
		
		int i;
		for(i = 0; i < cadenaArreglo.length; i++) {
			
			String clave = cadenaArreglo[i];
			int indiceArreglo = Integer.parseInt(clave) % 19; // Conversi�n de tipo de dato
			System.out.println("\n El �ndice es " + indiceArreglo + " para la clave " + clave); // Monitoreo
			
			// Tratando las colisiones
			while(arreglo[indiceArreglo] != "-1") {
				
				System.out.println("\n ------------------------------------- ");
				indiceArreglo++;
				System.out.println("\n Ocurri� una colisi�n en el �ndice " + (indiceArreglo - 1) + "\n Cambiar al �ndice " + indiceArreglo); // Monitoreo
				indiceArreglo %= size;
			}
			arreglo[indiceArreglo] = clave; // Agrega elemento cuando se encuentre
		}
	}
	
	// M�todo para mostrar la tabla
	// Los ciclos funcionan solo por est�tica
	public void mostrar() {
		
		int incremento = 0;
		int i, j;
		
		System.out.println("\n\n\t\t\t\t\t\t\t\t\t Tabla Hash ");
		for(i = 0; i < 1; i++) {
			
			incremento += 20;
			
			for(j = 0; j < 240; j++) {
				
				System.out.print("-");
			}
			System.out.println();

			for(j = incremento - 20; j < incremento; j++) {
				
				System.out.format(" |     %3s " + " ", j); // Cuesti�n de est�tica
			}
			System.out.println(" | "); // Cuesti�n de est�tica
			
			for(int n = 0; n < 240; n++) {
				
				System.out.print("-");
			}
			
			System.out.println();
			
			for(j = incremento - 20; j < incremento; j++) {
				
				if(arreglo[j].equals("-1")) {
					
					System.out.println(" |        "); // Cuesti�n de est�tica
				} else {
					
					System.out.print(String.format(" | %3s " + " ", arreglo[j])); // Cuesti�n de est�tica
				}
			}
			System.out.println(" | ");
			
			for(j = 0; j < 240; j++) {
				
				System.out.print("-");
			}
			System.out.println();
		}
	}
	
	// M�todo para buscar y dar un �ndice a la clave
	public String buscarClave(String clave) {
		
		int indiceArreglo = Integer.parseInt(clave) % 19;
		int cont = 0;
		
		while(arreglo[indiceArreglo] != "-1") {
			
			if(arreglo[indiceArreglo] == clave) {
				
				System.out.println("\n La clave " + clave + " se encuentra en el �ndice " + indiceArreglo);
				return arreglo[indiceArreglo];
			}
			indiceArreglo++;
			indiceArreglo %= size;
			cont++; // Recorrido de la tabla
			
			// Validaci�n del contador
			if(cont > 7) {
				
				break; 
			}
		}
		return null; // No se encuentra la clave
	}

}
