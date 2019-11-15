import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		// Atributos
		String clave;
		long valor;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		Hash hash = new Hash(20); // Tabla Hash de 20 elementos
		String[] elementos = {"0123456", "1234567", "1245678", "1256789", "1267890", "1278901", "1289012", "1290123", "1201234", "1212345", "1252717", "1253444", "1253546", "1253779", "1257400", "1260368", "1260444", "1260579", "1260896", "1260367"}; // Arreglo de 20 elementos
		hash.funcionHash(elementos, hash.arreglo); // Recibe los elementos y el arreglo
		hash.mostrar();
		String buscado = hash.buscarClave("1260368"); // Se encuentra el elemento o no
		if(buscado ==  null) { // Si no se encuentra
			
			System.out.println("\n La clave 1260368 no se encuentra en la tabla ...");
		}
		
		// Método multiplicativo/dispersión
		System.out.println("\n ----------------------------------------------- ");
		System.out.println("\n\n\t Método Multiplicativo");
		System.out.println("\n Clave: ");
		clave = entrada.readLine();
		valor = Dispersion.transformaClave(clave);
		valor = Dispersion.dispersion(valor);
		System.out.println("\n La dispersión de la clave " + clave + " es " + valor);
		
		// Función centro de cuadrados
		System.out.println("\n ------------------------------------------------ ");
		System.out.println("\n\n\t Centro de Cuadrados");
		System.out.println("\n Clave: ");
		clave = entrada.readLine();
		valor = Cuadrados.centroCuadrados(clave);
		
	}

}
